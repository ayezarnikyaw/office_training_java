package AWT;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Spring;

public class Home extends JFrame{
	static String name;
	JLabel lblName;
	Home(){
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,150);
		setLocation(100,200);
		
		lblName = new JLabel();
		lblName.setText("Welcome" +name);
		lblName.setFont(new Font("Times New Roman", Font.BOLD+Font.ITALIC , 16));
		lblName.setForeground(Color.BLUE);
		Container c= getContentPane();
		c.add(lblName);
		this.setVisible(true);
		
	}
	
	
	

}
