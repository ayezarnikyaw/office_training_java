package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class orderServer {
	ServerSocket server;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	public orderServer(){
		
	String command="";
	int quantity = 0;
	int result = 0;
	
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
			quantity = in.readInt();

			result=0;

			System.out.println("book Quantity = " + quantity);	
			
		    
			if (command.toUpperCase().equals("BOOK"))
				result = Book(quantity);
			else if (command.toUpperCase().equals("PENCIL"))
				result = Pencil( quantity);
			else if (command.toUpperCase().equals("EARSER"))
				result = Eraser( quantity);
			else if (command.toUpperCase().equals("PEN"))
				result = Pen(quantity);
			else if (command.toUpperCase().equals("RULER"))
				result = Ruler( quantity);
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
		private int Book(int qty) {
		    return (250 * qty);
		}
		private int Pencil(int qty) {
			return (150 * qty);
	   }
		private int Eraser(int qty) {
			return (100 * qty);
	   }
		private int Pen(int qty) {
			return (150 * qty);
	   }
		private int Ruler(int qty) {
			return (200 * qty);
	   }
		
	public static void main(String[] args) throws Exception{
		
		new orderServer();
		
		}	
	
}
