import java.net.*;
import java.io.*;
class CRC_receiver
{
public static void main(String args[])throws Exception
{

ServerSocket ss=new ServerSocket(5000);
System.out.println("waiting for connection");
Socket soc=ss.accept();
System.out.println("connection established");String str="",str1="";
BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()));
int i;
int n=Integer.parseInt(in.readLine());
int m=Integer.parseInt(in.readLine());

int inp1[]=new int[m];

for(i=0;i<m;i++)
{
inp1[i]=Integer.parseInt(in.readLine());
}

int inp[]=new int[m+n-1];
for(i=0;i<m+n-1;i++)
{
inp[i]=Integer.parseInt(in.readLine());
}



///////
int k;
int tmp[]=new int[m];
for(k=0;k<m;k++){tmp[k]=inp[k];}
for(k=0;k<n;k++)
{

	if(tmp[0]==1)
	{
	for(i=1;i<m;i++)
	{
	if(tmp[i]==inp1[i]){tmp[i-1]=0;}
	else {tmp[i-1]=1;}
	}
	}
	else{
	for(i=1;i<m;i++)
	{tmp[i-1]=tmp[i];}}
	
	if(k+m==m+n-1){break;}
	tmp[--i]=inp[k+m];
}
///////

int error=0;
for(i=0;i<m-1;i++)
{
if(tmp[i]==1){error=1;break;}
}
if(error==1)
{
System.out.println("ERROR !!!\n code received is:");
for(i=0;i<m+n-1;i++)
{
System.out.print(inp[i]);
}
}
else
{
System.out.print("data is:");
for(i=0;i<n;i++)
{
System.out.print(inp[i]);
}
}



}
}