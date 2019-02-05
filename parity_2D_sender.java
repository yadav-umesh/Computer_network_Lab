import java.net.*;
import java.io.*;
import java.util.*;

class parity_2D_sender
{
	public static void main(String args[]) throws Exception{
		ServerSocket ss=new ServerSocket(1110);
		Socket s=ss.accept();
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		Scanner sc = new Scanner(System.in);
		int parity;
		System.out.println("Enter data to be sent: ");
		String str = sc.nextLine();
		char[] input=str.toCharArray();
		System.out.println(input);
		int n = str.length();
                dout.writeInt(n);
		int[][] out=new int[n+1][9];
		for(int i=0;i<n;i++)
                {
                int value = (int)input[i];
                int val = value;
                int j=7;
   
                while(val!=0)
                {
                        out[i][j--]=val%2;
                        val=val/2;
                }
		}
		for(int i=0;i<n;i++)
		{
			int sum=0;
                for(int k=0;k<8;k++)
                {
                        if(out[i][k]==1)
                                sum=sum+1;
                }
		
                if((sum%2)==0)
                {
                        out[i][8]=0;
                }
                else
                        out[i][8]=1;
		}
		for(int k=0;k<8;k++)
		{
			int sum=0;
		for(int i=0;i<n;i++)
		{
			if(out[i][k]==1)
				sum=sum+1;
		}
		if((sum%2)==0)
                {
                        out[n][k]=0;
                }
                else
                        out[n][k]=1;

		}

		//System.out.print("\n"+value+"\n");
		for(int i=0;i<=n;i++)
		{
		for(int k=0;k<9;k++)
		{
			System.out.print(out[i][k]);
			dout.writeInt(out[i][k]);
		}
		System.out.print("\n");
		}

		//for(int e : out)
		//	dout.writeInt(e);
		//dout.flush();

		

                //printf("%d-%d ",value,out[8]);
                //for(int k=0;k<8;k++)
                  //      printf("%d ",out[k]);
                //printf("\n");

		
	}
}