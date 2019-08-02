package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class orderClient {
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	public orderClient() throws Exception{
		
		String command="";
		int quality = 0;
		int result = 0;
		char ch = 0;
		
		socket = new Socket("localhost", 7000);
		System.out.println("The client gets connection with server.");
		
		do{// interacts with user to get inputs
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter item you want to buy [book,pencil,earser,pen or ruler] : ");
			command = br.readLine();
			System.out.print("Enter quality : ");
			quality = Integer.parseInt(br.readLine());
			
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(command);
			out.writeInt(quality);
			
			in = new DataInputStream(socket.getInputStream());
			result=in.readInt();
			System.out.println("result = " + result);
			System.out.print("\nAny more (y/n)");
			ch=br.readLine().toLowerCase().charAt(0);

		}while (ch=='y');
		socket.close();
		System.out.println("disconnected with server!");
	
	}
	
	public static void main(String[] args) throws Exception{
		
		new orderClient();
	
	}
}
