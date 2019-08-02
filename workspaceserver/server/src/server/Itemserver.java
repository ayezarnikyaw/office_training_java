package server;

import java.io.*;
import java.net.*;
public class Itemserver{
ServerSocket server;
Socket socket;
DataInputStream in;
DataOutputStream out;
public Itemserver()
{ String command="";

int num1=0;


int result=0;
boolean flag = true;
try{
server = new ServerSocket(7000);
System.out.println("Server is ready!");
socket = server.accept();
System.out.println("Connection is established.");
while(flag)
{ System.out.println("\nWaitingrequest.....");
in = new DataInputStream(socket.getInputStream());
command = in.readUTF();
num1 = in.readInt();

result=0;

System.out.println("num1 = " + num1);

if (command.toUpperCase().equals("BOOK"))
result = calculateBook(num1);
else if (command.toUpperCase().equals("PENCIL"))
result = calculatePencil(num1);
else if (command.toUpperCase().equals("ERASER"))
result = calculateEraser(num1);
else if (command.toUpperCase().equals("PEN"))
result = calculatepen(num1);



else 
result = calculatruler(num1);
out = new DataOutputStream(socket.getOutputStream());
out.writeInt(result);
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

private int calculateBook(int n1) {
return (250 * n1);
}
private int calculatePencil(int n1) {
return (150 * n1);
}
private int calculateEraser(int n1) {
return (100 * n1);
}
private int calculatepen(int n1) {
return (150 * n1);
}
private int calculatruler(int n1) {
return (200 * n1);
}

public static void main(String[] args) throws Exception {
new Itemserver();
}
}