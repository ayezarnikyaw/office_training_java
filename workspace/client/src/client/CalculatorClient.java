package client;

import java.io.*;
import java.net.*;
public class CalculatorClient{
Socket socket;
DataInputStream in;
DataOutputStream out;
public CalculatorClient() throws Exception
{
String command="";
int num1=0;
int num2=0;
int result=0;
char ch=0;
socket = new Socket("localhost", 7000);
System.out.println("The client gets connection with server.");
do{// interacts with user to get inputs
BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
System.out.print("Type a command (ADD, SUB, MULT, DIV) : ");
command = br.readLine();
System.out.print("Enter number 1 : ");
num1 = Integer.parseInt(br.readLine());
System.out.print("Enter number 2 : ");
num2 = Integer.parseInt(br.readLine());
out = new DataOutputStream(socket.getOutputStream());
out.writeUTF(command);
out.writeInt(num1);
out.writeInt(num2);
in = new DataInputStream(socket.getInputStream());
result=in.readInt();
System.out.println("result = " + result);
System.out.print("\nTryit more (y/n)");
ch=br.readLine().toLowerCase().charAt(0);
}while (ch=='y');
socket.close();
System.out.println("disconnected with server!");}
public static void main(String[] args) throws Exception
{
new CalculatorClient();
}
}