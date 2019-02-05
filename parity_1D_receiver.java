import java.net.*; 
import java.io.*; 
import java.util.*; 
   
public class parity_1D_receiver { 
      
    // Initialize socket and I/O streams 
    private Socket s = null; 
    private DataInputStream dis = null; 
    private DataOutputStream dos = null; 
      
    // Constructor to put ip address and port 
    public parity_1D_receiver(InetAddress ip,int port)throws IOException 
    { 
          
        // Opens a socket for connection 
        s = new Socket(ip,port); 
          
        dis = new DataInputStream(s.getInputStream()); 
        dos = new DataOutputStream(s.getOutputStream()); 
          
          Scanner sc = new Scanner(System.in); 
            int i, l, nob, sum = 0, chk_sum; 
            l = dis.readInt(); 
              
            int c_data[] = new int[l]; 
            int data[] = new int[l]; 
              
            System.out.println("Data received (alond with parity) is"); 
              
            for(i = 0; i<= data.length-1; i++) 
            {    
                data[i] = dis.readInt(); 
                System.out.println(data[i]); 
            } 
           
                int count1=0,count0=0;
        		for(i=0;i<data.length;i++){
        			if(data[i]==1){
        				count1++;
        			}	
        			if(data[i]==0){
        				count0++;
        			}
        		}
        		if(count1%2==0){
        			System.out.println("data correctly received");
        			dos.writeUTF("success"); 
        		}
        		else{
        			System.out.println("error occurred");
        			dos.writeUTF("failure"); 
        		}
            }  
          
        // Closing all connections 
        //dis.close(); 
     //   dos.close(); 
     //   s.close(); 
      
    // Driver Method 
    public static void main(String args[])throws IOException 
    {    
        // Getting ip address on which the receiver is running 
        // Here, it is "localhost" 
        InetAddress ip = InetAddress.getLocalHost(); 
        parity_1D_receiver cr = new parity_1D_receiver(ip,5000); 
    }     
} 