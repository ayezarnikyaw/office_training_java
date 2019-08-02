package server;
import java.io.*;
import java.net.*;
public class CalculatorServer{
ServerSocket server;
Socket socket;
DataInputStream in;
DataOutputStream out;
public CalculatorServer()
{ String command="";
int num1=0;
int num2=0;
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
num2 = in.readInt();
result=0;
System.out.println("command = " + command);
System.out.println("num1 = " + num1);
System.out.println("num2 = " + num2);
if (command.toUpperCase().equals("ADD"))
result = calculateAdd(num1, num2);
else if (command.toUpperCase().equals("SUB"))
result = calculateSub(num1, num2);
else if (command.toUpperCase().equals("MULT"))
result = calculateMult(num1, num2);
else
result = calculateDiv(num1, num2);
out = new DataOutputStream(socket.getOutputStream());
out.writeInt(result);
}
}catch(Exception e){
	try { 
		socket.close();
		System.out.println("The connection is closed.");
	} catch (IOException e1){
	e1.printStackTrace();
	}
}
}
private int calculateAdd(int n1, int n2) {
return (n1 + n2);
}
private int calculateSub(int n1, int n2) {
return (n1 -n2);
}
private int calculateMult(int n1, int n2) {
return (n1 * n2);
}
private int calculateDiv(int n1, int n2) {
return (n1 / n2);
}

public static void main(String[] args) throws Exception {
new CalculatorServer();
}
}