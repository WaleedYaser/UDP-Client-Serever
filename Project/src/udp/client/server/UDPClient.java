package udp.client.server;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClient {
    
    static DatagramSocket clientsocket;
    
    public static void main(String[] args) {
        
        // read args from cmd
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        
        //create the client socket that used to contact to udp server 
        try {
            clientsocket=new DatagramSocket(9090);
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        while (true)
        {
            // read user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a word to convert to lower: ");
            String message = scanner.next();
            
            // sending to sever
            try 
            {
                byte[]senddata=message.getBytes();
                InetAddress IPAddress = InetAddress.getByName(host);
                DatagramPacket sendpacket = new DatagramPacket (senddata,
                                                              senddata.length,
                                                              IPAddress,
                                                              port);
                clientsocket.send(sendpacket);

                // receiving from server 
                byte[]receivedata=new byte[100];
                DatagramPacket recievepacket = new DatagramPacket (receivedata,
                                                                   receivedata.length);
                clientsocket.receive(recievepacket);
                String processedWord = new String(recievepacket.getData());
                System.out.println("Processed: " + processedWord);
                System.out.println("----------------------------");
                
            } catch(IOException ex) {
                System.err.println("IO exception");
            }   
        }             
    }
}