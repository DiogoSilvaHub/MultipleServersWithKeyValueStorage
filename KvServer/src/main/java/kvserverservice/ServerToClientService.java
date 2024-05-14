package kvserverservice;

import io.grpc.stub.StreamObserver;
import redis.clients.jedis.Jedis;
import servertoclientservice.Void;
import servertoclientservice.*;
import servertoserverservice.ServerToServerServiceGrpc;

public class ServerToClientService extends ServerToClientServiceGrpc.ServerToClientServiceImplBase{

    private static final Jedis jedis = ServerLogic.getInstance().getJedis();
    private static ServerToServerServiceGrpc.ServerToServerServiceBlockingStub blockingStub = null;

    @Override
    public void writeUpdate(Pair pair, StreamObserver<Void> responseObserver) {

        // check if connection with the next server of the ring has been made
        // if it is not, it connects to the next server of the ring
        if (blockingStub == null) {
            blockingStub = ServerLogic.getInstance().createBlockingStub();
            ServerLogic.getInstance().setBlockingStub(blockingStub);
        }
        blockingStub = ServerLogic.getInstance().getBlockingStub();

        // writes in jedis
        // sends write to next server
        jedis.set(pair.getKey(), pair.getValue());

        blockingStub.writeRead(servertoserverservice.Pair.newBuilder().setKey(pair.getKey()).setValue(pair.getValue()).setIPPort(ServerLogic.getInstance().getIPPort()).setFlagWriteRead(true).build());

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void read(Key key, StreamObserver<Value> responseObserver) {

        // check if connection with the next server of the ring has been made
        // if it is not, it connects to the next server of the ring
        if (blockingStub == null) {
            blockingStub = ServerLogic.getInstance().createBlockingStub();
            ServerLogic.getInstance().setBlockingStub(blockingStub);
        }
        blockingStub = ServerLogic.getInstance().getBlockingStub();

        // checks if in jedis
        // if not
        // sends read to next server
        // continues to check jedis until value is written or flag exists changes to "not found"
        // adds to map KeyExistsMap the key and associates it with the state "searching"
        // waits until the state associated with the key changes in KeyExistsMap
        // There are 3 possible states { searching, not found, value found in server redis of another KvServer}
        // After the state changes, it sends that new state to the client
        if (jedis.get(key.getKey()) != null){
            responseObserver.onNext(Value.newBuilder().setValue(jedis.get(key.getKey())).build());
            responseObserver.onCompleted();
        }else {
            ServerLogic.getInstance().getKeyExistsMap().put(key.getKey(), "searching");
            blockingStub.writeRead(servertoserverservice.Pair.newBuilder().setKey(key.getKey()).setValue(" ").setIPPort(ServerLogic.getInstance().getIPPort()).setFlagWriteRead(false).build());
            while(true){
                if (!ServerLogic.getInstance().getKeyExistsMap().get(key.getKey()).equals("searching")){
                    responseObserver.onNext(Value.newBuilder().setValue(ServerLogic.getInstance().getKeyExistsMap().get(key.getKey())).build());
                    responseObserver.onCompleted();
                    break;
                }
            }
        }



    }
}
