import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        
        //create the client socket that used to contact to udp server 
        
        DatagramSocket clientsocket=new DatagramSocket(9090);
        // sending to sever
     
        String message="Hello from client ";
        byte[]senddata=message.getBytes();
        InetAddress IPAddress=InetAddress.getByName("localhost");
         DatagramPacket sendpacket=new DatagramPacket (senddata,senddata.length,IPAddress,2000);
         clientsocket.send(sendpacket);
        
         // receiving from server 
           byte[]receivedata=new byte[100];
          DatagramPacket recievepacket=new DatagramPacket (receivedata,receivedata.length);
           clientsocket.receive(recievepacket);
                  
    }
   
    }