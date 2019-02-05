import java.io.*;import java.net.*;
import java.util.Scanner;
class CRC_sender
{
public static void main(String args[]) throws Exception
{
Socket soc=new Socket("127.0.0.1",5000);
System.out.println("connected");
String input="";
PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
Scanner sc=new Scanner(System.in);
System.out.println("enter data stream:");
String str=sc.nextLine();
//divident no. of bits n
int n=str.length();
out.println(n);
System.out.println("enter Divisor:");
String str1=sc.nextLine();
//divisor no. of bits m
int m=str1.length();
out.println(m);
int i,inp[];
inp=new int[n+m-1];
for(i=0;i<n+m-1;i++){inp[i]=0;}
for(i=0;i<n;i++)
{
inp[i]=Character.getNumericValue(str.charAt(i));
}

int inp1[]=new int[m];
for(i=0;i<m;i++)
{
inp1[i]=Character.getNumericValue(str1.charAt(i));
out.println(inp1[i]);
}

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

System.out.print("sum added is:");
for(i=0;i<m-1;i++)
System.out.print(tmp[i]);
System.out.println();
int data[]=new int[n+m-1];
for(i=0;i<n;i++)
data[i]=inp[i];
for(i=0;i<m-1;i++)
data[n+i]=tmp[i];
System.out.println("data is:");
for(i=0;i<n+m-1;i++)
{System.out.print(data[i]);
out.println(data[i]);}



}
}