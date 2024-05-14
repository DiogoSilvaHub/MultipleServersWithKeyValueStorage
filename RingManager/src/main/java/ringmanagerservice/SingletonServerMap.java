package ringmanagerservice;

import java.util.HashMap;
import java.util.Map;

public final class SingletonServerMap {

    // class Singleton
    // Saves variables and methods used in both Services

    private static SingletonServerMap INSTANCE;
    public static class Server {
        public String ip ;
        public String port;
        public int numberClients = 0;
        public String nextIP ;
        public String nextPort;
        //constructor
        public Server(String ip, String port, String nextIP, String nextPort) {
            this.ip = ip;
            this.port = port;
            this.nextIP = nextIP;
            this.nextPort = nextPort;

        }
    }
    private final Map<String, Server> serverMap = new HashMap<>();

    public static SingletonServerMap getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonServerMap();
        }

        return INSTANCE;
    }

    public Map<String, Server> getServerMap(){
        return serverMap;
    }

    public boolean addNumberOfClients(String key){
        if (serverMap.containsKey(key)){
            serverMap.get(key).numberClients += 1;
        }else {
            return false;
        }
        return true;
    }
}
