import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        
        //create the client socket that used to contact to udp server 
        
        DatagramSocket clientsocket=new DatagramSocket(9090);
        
        
        while (true)
        {
            // read user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a word to capitalize: ");
            String message = scanner.next();
            
            // sending to sever
            byte[]senddata=message.getBytes();
            InetAddress IPAddress=InetAddress.getByName("localhost");
            DatagramPacket sendpacket = new DatagramPacket (senddata,
                                                          senddata.length,
                                                          IPAddress,
                                                          2000);
            clientsocket.send(sendpacket);

            // receiving from server 
            byte[]receivedata=new byte[100];
            DatagramPacket recievepacket = new DatagramPacket (receivedata,
                                                               receivedata.length);
            clientsocket.receive(recievepacket);
            String processedWord = new String(recievepacket.getData());
            System.out.println("Processed: " + processedWord);
            System.out.println("----------------------------");
        }
                  
    }
   
    }