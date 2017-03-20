import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UDPServer {
  public static void main(String[] args) throws IOException{
           
      try {
          //  create the udp server socket with specific port number
          DatagramSocket server=new DatagramSocket(2000);
           
          // preparing the packet structure for recived packet 
          
          byte[]receivedata=new byte[100];
          DatagramPacket recievepacket=new DatagramPacket (receivedata,receivedata.length);
          
          
              // waiting for incoming packet 
              server.receive(recievepacket);
              
              // Extracting recieved packet 
              String message =new String (recievepacket.getData());
              System.out.println(message);
              
              // send response to the client 
               
               String response="This is a greeting from the server " ;
               byte[]senddata=response.getBytes();
               InetAddress IPAddress=InetAddress.getByName("localhost");
               DatagramPacket sendpacket=new DatagramPacket (senddata,senddata.length,IPAddress,9090);
               server.send(sendpacket);
          
                  
              } catch (SocketException ex) {
          Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
      }
     
  }
       
}
