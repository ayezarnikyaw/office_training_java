package client;

import java.io.*;
import java.net.*;
public class PrimeClient{
Socket socket;
DataInputStream in;
DataOutputStream out;
public PrimeClient() throws Exception
{
int num=0;
boolean result;
char ch=0;
socket = new Socket("localhost", 7000);
System.out.println("The client gets connection with server.");
do{// interacts with user to get inputs
BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter number: ");
num= Integer.parseInt(br.readLine());
out = new DataOutputStream(socket.getOutputStream());
out.writeInt(num);
in = new DataInputStream(socket.getInputStream());
result=in.readBoolean();
if(result)
{
System.out.println("It is prime.");
}
else
{
System.out.println("It is not prime.");
}
System.out.print("\nTryit more (y/n)");
ch=br.readLine().toLowerCase().charAt(0);
}while (ch=='y');
socket.close();
System.out.println("disconnected with server!");}
public static void main(String[] args) throws Exception
{
new PrimeClient();
}
}