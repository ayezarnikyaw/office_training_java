package client;


import java.io.*;
import java.net.*;
public class OrderCalculateClient{
	
Socket socket;
DataInputStream in;
DataOutputStream out;

public OrderCalculateClient() throws Exception{
	String command="";
	int num1=0;
	int result=0;
	char ch=0;
	int total = 0;
	socket = new Socket("", 7000);
	System.out.println("The client gets connection with server.");
	
	do{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter item you want to buy [book,pencil,earser,pen or ruler] : ");
		command = br.readLine();
		System.out.print("Enter quantity : ");
		num1 = Integer.parseInt(br.readLine());

		out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(command);
		out.writeInt(num1);

		in = new DataInputStream(socket.getInputStream());
		result=in.readInt();
		System.out.println(command + ":" + num1 + " " +  result);
		total += result;
		System.out.print("\nTryit more (y/n)");
		ch=br.readLine().toLowerCase().charAt(0);
	}while (ch=='y');
		socket.close();
		System.out.println("Total = " + total);
		System.out.println("disconnected with server!");
		
	}
	public static void main(String[] args) throws Exception{
	new OrderCalculateClient();
	}
}
