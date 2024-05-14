package clientservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ringtoclientservice.RingToClientServiceGrpc;
import ringtoclientservice.Void;
import servertoclientservice.Key;
import servertoclientservice.Pair;
import servertoclientservice.ServerToClientServiceGrpc;
import servertoclientservice.Value;

import java.util.Scanner;

public class Client {

    static int Menu() {
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("######## MENU ##########");
            System.out.println("Options for Server Operations:");
            System.out.println(" 0: Write pair Key, Value to Server");
            System.out.println(" 1: Read Key from Server");
            System.out.println("..........");
            System.out.println("99: Exit");
            System.out.print("Enter an Option:");
            option = scan.nextInt();
        } while (!((option >= 0 && option <= 1) || option == 99));
        return option;
    }

    public static void main(String[] args) {
        try {
            if (args.length < 2) throw new RuntimeException("Not enough arguments (ringManagerIP, ringManagerPort)");
            String ringManagerIP = args[0];
            String ringManagerPort = args[1];

            //Connection of Client to server RingManager
            ManagedChannel channelRingManager = ManagedChannelBuilder.forAddress(ringManagerIP, Integer.parseInt(ringManagerPort))
                    .usePlaintext()
                    .build();
            RingToClientServiceGrpc.RingToClientServiceBlockingStub blockingStubRingManager = RingToClientServiceGrpc.newBlockingStub(channelRingManager);

            // Get location of KvServer from Ring Manager
            ringtoclientservice.Location locationServer = blockingStubRingManager.getKvServer(Void.newBuilder().build());
            System.out.println(locationServer);

            //Connection of Client to server KvServer
            ManagedChannel channelServer = ManagedChannelBuilder.forAddress(locationServer.getIP(), Integer.parseInt(locationServer.getPort()))
                    .usePlaintext()
                    .build();
            ServerToClientServiceGrpc.ServerToClientServiceBlockingStub blockingStubServer = ServerToClientServiceGrpc.newBlockingStub(channelServer);

            Scanner scan = new Scanner(System.in);
            while(true){
                int option = Menu();
                switch (option){
                    case 0: // Write pair Key, Value to Server
                        System.out.println("Insert Key:");
                        String key = scan.nextLine();
                        System.out.println("Insert Value");
                        String value = scan.nextLine();

                        blockingStubServer.writeUpdate(Pair.newBuilder().setKey(key).setValue(value).build());

                        System.out.println("Key: "+ key +", Value: "+ value +" saved");
                        break;
                    case 1: // Read Key from Server
                        System.out.println("Insert Key:");
                        String readKey = scan.nextLine();

                        Value readValue = blockingStubServer.read(Key.newBuilder().setKey(readKey).build());
                        System.out.println("Value of Key "+readKey+": "+readValue.getValue());

                        break;
                    case 99: // Exit
                        System.out.println("Bye!");
                        System.exit(0);
                }
            }

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
