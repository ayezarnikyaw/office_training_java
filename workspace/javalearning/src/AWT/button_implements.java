package AWT;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class button_implements extends JFrame implements ActionListener{
	TextField tf;
	button_implements() {
		tf = new TextField();
		tf.setBounds(60,50,170,20);
		Button b = new Button("click me");
		b.setBounds(100,120,80,30);
		b.addActionListener(this);
		add(b);add(tf);
		setSize(300,300);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		tf.setText("Welcome");
		
	}
	
	public static void main(String[] args) {
		new button_implements();
	}
	
}
