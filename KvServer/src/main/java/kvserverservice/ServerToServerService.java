package kvserverservice;

import io.grpc.stub.StreamObserver;
import redis.clients.jedis.Jedis;
import servertoserverservice.Pair;
import servertoserverservice.ServerToServerServiceGrpc;
import servertoserverservice.Void;

public class ServerToServerService extends ServerToServerServiceGrpc.ServerToServerServiceImplBase {

    private static final Jedis jedis = ServerLogic.getInstance().getJedis();
    private static ServerToServerServiceGrpc.ServerToServerServiceBlockingStub blockingStub = null;
    @Override
    public void writeRead(Pair pair, StreamObserver<Void> responseObserver){

        // check if connection with the next server of the ring has been made
        // if it is not, it connects to the next server of the ring
        if (blockingStub == null) {
            blockingStub = ServerLogic.getInstance().createBlockingStub();
            ServerLogic.getInstance().setBlockingStub(blockingStub);
        }
        blockingStub = ServerLogic.getInstance().getBlockingStub();

        if (pair.getFlagWriteRead()){ // If True = Write
            if (jedis.get(pair.getKey()) == null || !jedis.get(pair.getKey()).equals(pair.getValue())){
                jedis.set(pair.getKey(), pair.getValue());
                // write next
                blockingStub.writeRead(Pair.newBuilder().setKey(pair.getKey()).setValue(pair.getValue()).setIPPort(pair.getIPPort()).setFlagWriteRead(true).build());
            }else{
                //if (own ip != pair.getIP()) write next
                if (!ServerLogic.getInstance().getIPPort().equals(pair.getIPPort())){
                    blockingStub.writeRead(Pair.newBuilder().setKey(pair.getKey()).setValue(pair.getValue()).setIPPort(pair.getIPPort()).setFlagWriteRead(true).build());
                }else {
                    // else
                    if (ServerLogic.getInstance().getKeyExistsMap().containsKey(pair.getKey())){
                        ServerLogic.getInstance().replaceKeyExistsMap(pair.getKey(), pair.getValue());
                    }
                }
            }
        }else {// If False = Read
            if (jedis.get(pair.getKey()) == null){
                //if (own ip == pair.getIP()) client nao ha
                if (ServerLogic.getInstance().getIPPort().equals(pair.getIPPort())){
                    ServerLogic.getInstance().replaceKeyExistsMap(pair.getKey(), "not found");
                }else {
                    // read next
                    blockingStub.writeRead(Pair.newBuilder().setKey(pair.getKey()).setIPPort(pair.getIPPort()).setFlagWriteRead(false).build());
                }
            }else {
                //if (own ip != pair.getIP()) write next
                if (!ServerLogic.getInstance().getIPPort().equals(pair.getIPPort())){
                    blockingStub.writeRead(Pair.newBuilder().setKey(pair.getKey()).setValue(jedis.get(pair.getKey())).setIPPort(pair.getIPPort()).setFlagWriteRead(true).build());
                }
                // else stops loop
            }
        }
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }
}
