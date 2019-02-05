


import java.io.*; 
import java.net.*; 
import java.util.*; 
  
public class parity_1D_sender
{ 
    private int MAX = 100; 
    private Socket socket = null; 
    private ServerSocket servsock = null; 
    private DataInputStream dis = null; 
    private DataOutputStream dos = null; 
      
    public parity_1D_sender(int port) throws IOException 
    { 
        servsock = new ServerSocket(port); 
          
        socket = servsock.accept(); 
          
        dis = new DataInputStream(socket.getInputStream()); 
        dos = new DataOutputStream(socket.getOutputStream()); 
          
       
            int i, l, sum = 0, nob; 
            Scanner sc = new Scanner(System.in); 
            System.out.println("Enter data length"); 
            l = sc.nextInt(); 
              
            int data[] = new int[l+1]; 
              
            System.out.println("Enter data to send"); 
              
            for (i = 0; i < l; i++)  
            { 
                data[i] = sc.nextInt(); 
            }
                int count1=0,count0=0;
        		for(i=0;i<l;i++){
        			if(data[i]==1){
        				count1++;
        			}	
        		}
        		//i=i+1;
        		if(count1%2==0) data[l] = 0;
        		else data[l] = 1;
            

              
            System.out.println("Data being sent along with parity....."); 
              
            // Sends the data length to receiver 
            dos.writeInt(l+1); 
              
            // Sends the data one by one to receiver 
            for (int j = 0; j <=l ; j++) 
                dos.writeInt(data[j]); 
              
        
          
        // Closing all connections 
        dis.close(); 
        dos.close(); 
        socket.close(); 
    } 
  
    // Driver Method 
    public static void main(String args[]) throws IOException 
    { 
    	parity_1D_sender cs = new parity_1D_sender(5000); 
    } 
} 