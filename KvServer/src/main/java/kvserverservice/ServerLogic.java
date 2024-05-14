package kvserverservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import redis.clients.jedis.Jedis;
import ringtoserverservice.Location;
import servertoserverservice.ServerToServerServiceGrpc;

import java.util.HashMap;
import java.util.Map;

public final class ServerLogic {

    // class Singleton
    // Saves variables and methods used in both Services

    private static ServerLogic INSTANCE;
    private static Jedis jedis;
    private static Location locationNextServer;
    private static String IPPort;
    static Map<String, String> keyExistsMap = new HashMap<>();
    private static ServerToServerServiceGrpc.ServerToServerServiceBlockingStub blockingStub;

    public static ServerLogic getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ServerLogic();
        }

        return INSTANCE;
    }

    public Jedis getJedis() {
        return jedis;
    }
    public String getIPPort() {
        return IPPort;
    }
    public Map<String, String> getKeyExistsMap() {
        return keyExistsMap;
    }

    public ServerToServerServiceGrpc.ServerToServerServiceBlockingStub getBlockingStub() {
        return blockingStub;
    }

    public void setJedis(Jedis jedis) {
        ServerLogic.jedis = jedis;
    }

    public void setLocationNextServer(Location locationNextServer) {
        ServerLogic.locationNextServer = locationNextServer;
    }

    public void setIPPort(String IPPort) {
        ServerLogic.IPPort = IPPort;
    }

    public void setBlockingStub(ServerToServerServiceGrpc.ServerToServerServiceBlockingStub blockingStub) {
        ServerLogic.blockingStub = blockingStub;
    }

    public void replaceKeyExistsMap(String key, String value) {
        keyExistsMap.replace(key, value);
    }

    private static ManagedChannel channelNextServer;
    public ServerToServerServiceGrpc.ServerToServerServiceBlockingStub createBlockingStub(){
        channelNextServer = ManagedChannelBuilder.forAddress(locationNextServer.getIP(), Integer.parseInt(locationNextServer.getPort()))
                .usePlaintext()
                .build();
        return ServerToServerServiceGrpc.newBlockingStub(channelNextServer);
    }
}
