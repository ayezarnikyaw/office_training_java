package AWT;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextBoxEg extends JFrame implements ActionListener{
	JTextField txt;
	TextBoxEg(){
		setTitle("Textfield test");
		setSize(300, 150);
		setLocation(100,200);
		
		txt=new JTextField("Move it");
		
		Container c = getContentPane();
		c.add(txt,BorderLayout.NORTH);
		txt.addActionListener(this);
		txt.setHorizontalAlignment(JTextField.LEFT);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new TextBoxEg();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txt){
			
			if(txt.getHorizontalAlignment()==JTextField.LEFT)
				txt.setHorizontalAlignment(JTextField.CENTER);
			else if(txt.getHorizontalAlignment()==JTextField.RIGHT)
				txt.setHorizontalAlignment(JTextField.LEFT);
			else if(txt.getHorizontalAlignment()==JTextField.CENTER)
				txt.setHorizontalAlignment(JTextField.RIGHT);
		}

	}

}
