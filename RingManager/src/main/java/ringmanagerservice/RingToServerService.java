package ringmanagerservice;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import ringtoserverservice.Location;
import ringtoserverservice.RingToServerServiceGrpc;

import java.util.HashMap;
import java.util.Map;

public class RingToServerService extends RingToServerServiceGrpc.RingToServerServiceImplBase {

    Map<String, SingletonServerMap.Server> serverMap = SingletonServerMap.getInstance().getServerMap();

    Map<Integer, String> serverOrder = new HashMap<>();

    int maxServer = 3;


    @Override
    public void registerServer(Location location, StreamObserver<Location> responseObserver) {

        String ipAndPort = location.getIP()+"/"+location.getPort();

        // first checks if server is already registered
        if ( serverMap.containsKey(ipAndPort)){

            // if it is, sends it the ip and port of the next server
            responseObserver.onNext(Location.newBuilder().setIP(serverMap.get(ipAndPort).nextIP).setPort(serverMap.get(ipAndPort).nextPort).build());
            responseObserver.onCompleted();

        } else {

            // if it is not, checks if ring already has 3 servers registered
            if (serverMap.size() < maxServer) {

                // if it doesn't have 3 servers registered, it registers the server
                serverMap.put(ipAndPort, new SingletonServerMap.Server(location.getIP(), location.getPort(), " ", " "));

                // then saves te index of the server, example 1 if the server was the first to register
                int serverIDX = serverMap.size();

                serverOrder.put(serverIDX, ipAndPort);

                // then waits until 3 servers have registered
                while(serverMap.size() < maxServer){
                    serverMap = SingletonServerMap.getInstance().getServerMap();
                }

                // after the 3 servers have registered, it gets the ip and port of the next server using the saved index of each server
                String nextIP;
                String nextPort;
                if (serverIDX == maxServer){
                    nextIP = serverOrder.get(1).split("/")[0]; // ip/port -> array: 0 : ip ; 1 : port
                    nextPort = serverOrder.get(1).split("/")[1];
                }else {
                    nextIP = serverOrder.get(serverIDX + 1).split("/")[0];
                    nextPort = serverOrder.get(serverIDX + 1).split("/")[1];
                }

                // then it saves the ip and port of the next server
                serverMap.replace(ipAndPort, new SingletonServerMap.Server(location.getIP(), location.getPort(), nextIP, nextPort));

                // then it sends the ip and port of the next server to the server who made the request
                responseObserver.onNext(Location.newBuilder().setIP(nextIP).setPort(nextPort).build());
                responseObserver.onCompleted();

            }else {
                // if it does have 3 servers registered, it sends a message to the server who made the request saying that the ring is full
                Status status = Status.FAILED_PRECONDITION.withDescription("Ring is full (max "+maxServer+")");
                responseObserver.onError(status.asRuntimeException());

            }
        }


    }

}
