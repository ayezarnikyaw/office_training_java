package AWT;

import java.awt.Button;


import javax.swing.JFrame;

public class button {
	public static void main(String[] args) {
		JFrame f = new JFrame("Button Example");
		Button b = new Button("Click Here");
		b.setBounds(50,100,80,30);
		f.add(b);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);

		
	}

}
