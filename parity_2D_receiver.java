import java.net.*;
import java.io.*;
import java.util.*;

class parity_2D_receiver
{
	public static void main(String args[]) throws Exception
	{
		Socket s = new Socket("localhost",1110);
		DataInputStream din = new DataInputStream(s.getInputStream());
		int n = din.readInt();

	        int[][] bitData = new int[n+1][9];
		for(int a=0;a<=n;a++)
		{
		for(int i=0;i<9;i++)
		{
			bitData[a][i] = din.readInt();
			System.out.print(bitData[a][i]);
		}
		}
		System.out.print("\n");
                
		for(int i=0;i<n;i++)
		{
		int sum = 0;

		 for(int k=0;k<8;k++)
                {
                        if(bitData[i][k]==1)
                                sum=sum+1;
                }
                if((sum%2)==0)
                {
                        if(bitData[i][8]==0)
                                System.out.print("CCorrect\n");
                        else
                                System.out.print("EError\n");
                }
                else
                {
                        if(bitData[i][8]==1)
                                System.out.print("correct\n");
                        else
                                System.out.print("error\n");
                }
		}
		 for(int k=0;k<8;k++)
                {
                int sum = 0;

                 for(int i=0;i<n;i++)
                {
                        if(bitData[i][k]==1)
                                sum=sum+1;
                }
                if((sum%2)==0)
                {
                        if(bitData[n][k]==0)
                                System.out.print("CCorrect\n");
                        else
                                System.out.print("EError\n");
                }
                else
                {
                        if(bitData[n][k]==1)
                                System.out.print("correct\n");
                        else
                                System.out.print("error\n");
                }
                }

	}
}

