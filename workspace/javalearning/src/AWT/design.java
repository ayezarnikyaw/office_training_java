package AWT;

import java.awt.Button;
import javax.swing.JFrame;

 class design extends JFrame{
	design(){
		Button b = new Button("click me"); 
		b.setBounds(30,100,80,30);
		add(b);
		setSize(300,300);
		setLayout(null);
		setVisible(true);
		
	}
	public static void main(String args[]){
		design d = new design();
	}
}
