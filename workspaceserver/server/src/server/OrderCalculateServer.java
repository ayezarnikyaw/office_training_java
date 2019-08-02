package server;


import java.io.*;
import java.net.*;
public class OrderCalculateServer{
	
	ServerSocket server;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	public OrderCalculateServer(){ 
		String command="";
		int qty=0;
		int result=0;
		boolean flag = true;
		
		try{
		server = new ServerSocket(7000);
		System.out.println("Server is ready!");
		socket = server.accept();
		System.out.println("Connection is established.");
		
			while(flag){ 
				System.out.println("\nWaitingrequest.....");
				in = new DataInputStream(socket.getInputStream());
				command = in.readUTF();
				qty = in.readInt();		
				result=0;		
				System.out.println("Item Name = " + command + "Quantity = " + qty);
	
				if (command.toUpperCase().equals("BOOK"))
				result = Book(qty);
				else if (command.toUpperCase().equals("PENCIL"))
				result = Pencil(qty);
				else if (command.toUpperCase().equals("ERASER"))
				result = Eraser(qty);
				else if (command.toUpperCase().equals("PEN"))
				result = calculatepen(qty);
				else 
				result = Ruler(qty);
				out = new DataOutputStream(socket.getOutputStream());
				out.writeInt(result);
			}
		}catch(Exception e){
			try { socket.close();
				System.out.println("The connection is closed.");
			} catch (IOException e1){
				e1.printStackTrace();
			}
		}
	}

	private int Book(int n1) {
	return (250 * n1);
	}
	private int Pencil(int n1) {
	return (150 * n1);
	}
	private int Eraser(int n1) {
	return (100 * n1);
	}
	private int calculatepen(int n1) {
	return (150 * n1);
	}
	private int Ruler(int n1) {
	return (200 * n1);
	}
	
	public static void main(String[] args) throws Exception {
	new OrderCalculateServer();
	}
}