import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UDPServer {
    
    public static void main(String[] args) {
          DatagramSocket server = null;
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
                    String response = ConvertToUpper(message) ;
                    byte[]senddata=response.getBytes();
                    InetAddress IPAddress = InetAddress.getByName("localhost");
                    DatagramPacket sendpacket = new DatagramPacket (senddata, 
                                                                    senddata.length,
                                                                    IPAddress,
                                                                    9090);
                    server.send(sendpacket);
                    System.out.println("Send: " + response);
                    System.out.println("----------------------------");
                    } catch (NullPointerException ex) {
                        System.err.println("Null exception");
                    } catch (IOException ex) {
                        System.err.println("IO exception");
                    }
            } 
               
        
  }
  
  public static String ConvertToUpper(String word)
  {
      return word.toUpperCase();
  }
  
}
