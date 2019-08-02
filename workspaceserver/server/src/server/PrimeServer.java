package server;

import java.io.*;
import java.net.*;
public class PrimeServer{
ServerSocket server;
Socket socket;
DataInputStream in;
DataOutputStream out;
public PrimeServer()
{
int num=0;
boolean result;
boolean flag = true;
try{
server = new ServerSocket(7000);
System.out.println("Server is ready!");
socket = server.accept();
System.out.println("Connection is established.");
while(flag)
{ System.out.println("\nWaitingrequest.....");
in = new DataInputStream(socket.getInputStream());
num = in.readInt();
result = isPrime(num);
out = new DataOutputStream(socket.getOutputStream());
out.writeBoolean(result);
}
}catch(Exception e){
try { socket.close();
System.out.println("The connection is closed.");
} catch (IOException e1)
{
e1.printStackTrace();
}
}
}
private boolean isPrime(int n1) {
int div=2;
while(n1%div!=0)
{
div++;
}
if(div==n1)
return true;
else
return false;
}
public static void main(String[] args) throws Exception {
new PrimeServer();
}
}