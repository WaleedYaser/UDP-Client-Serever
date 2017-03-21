package udp.client.server;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UDPServer {
    
    static DatagramSocket server;
    
    public static void main(String[] args) {
          
        try {
            //  create the udp server socket with specific port number
            server = new DatagramSocket(2000);
         } catch (SocketException ex) {
        Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
      }  
            // preparing the packet structure for recived packet 
          
            byte[]receivedata=new byte[100];
            DatagramPacket recievepacket=new DatagramPacket (receivedata,
                                                             receivedata.length);
          
            while (true)
            {
                try {
                    // waiting for incoming packet 
                    server.receive(recievepacket);

                    // Extracting recieved packet 
                    String message =new String (recievepacket.getData());
                    System.out.println("Recieve: " + message);

                    // send response to the client 
                    System.out.println("Processing ...");
                    String response = ConvertToLower(message) ;
                    byte[]senddata=response.getBytes();
                    InetAddress IPAddress = InetAddress.getByName("localhost");
                    DatagramPacket sendpacket = new DatagramPacket (senddata, 
                                                                    senddata.length,
                                                                    IPAddress,
                                                                    9090);
                    server.send(sendpacket);
                    System.out.println("Send: " + response);
                    System.out.println("----------------------------");
                    } catch (IOException ex) {
                        System.err.println("IO exception");
                    }
            } 
               
        
  }
  
    public static String ConvertToLower(String word)
    {
        // convert to lower in case of upper case only
        
        String wordPrcessed = "";
        char[] wordSplit = word.toCharArray();
        for (int i = 0; i < word.length(); i++)
        {
            if (Character.isUpperCase(wordSplit[i]))
            {
                wordPrcessed += Character.toLowerCase(wordSplit[i]);
            }
            else
            {
                wordPrcessed += wordSplit[i];
            }
        }
        return wordPrcessed;
    }
  
}
