package revision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonAndBgColor extends JFrame implements ActionListener{
	JButton b1 = new JButton("Yellow");
	JButton b2 = new JButton("Blue");
	JButton b3 = new JButton("Red");
	JButton b4 = new JButton("Green");
	JButton b5 = new JButton("Orange");
	JButton b6 = new JButton("Cyan");
	JLabel lbl = new JLabel("test");
	JPanel p1,p2,p3;
	
	 public ButtonAndBgColor() {
		// TODO Auto-generated constructor stub
		 this.setSize(290,200);
		 p1 = new JPanel();
		 p1.add(b1);
		 p1.add(b2);
		 p1.add(b3);
		 
		 p3=new JPanel();
		 p3.add(lbl);
		 
		 p2=new JPanel();
		 p2.add(b4);
		 p2.add(b5);
		 p2.add(b6);
		 
		 Container c = this.getContentPane();
		 c.add(p1, BorderLayout.NORTH);
		 c.add(p2,BorderLayout.SOUTH);
		 c.add(p3,BorderLayout.CENTER);
		 
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setVisible(true);
		  
		  b1.addActionListener(this);
		  b2.addActionListener(this);
		  b3.addActionListener(this);
		  b4.addActionListener(this);
		  b5.addActionListener(this);
		  b6.addActionListener(this);


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1){
			p1.setBackground(Color.YELLOW);
			p2.setBackground(Color.YELLOW);
			p3.setBackground(Color.YELLOW);
		}else if(e.getSource() == b2){
			p1.setBackground(Color.blue);
			p2.setBackground(Color.blue);
			p3.setBackground(Color.blue);			
		}else if(e.getSource() == b3){
			p1.setBackground(Color.RED);
			p2.setBackground(Color.RED);
			p3.setBackground(Color.RED);					
		}else if(e.getSource() == b4){
			p1.setBackground(Color.GREEN);
			p2.setBackground(Color.GREEN);
			p3.setBackground(Color.GREEN);				
		}else if(e.getSource() == b5){
			p1.setBackground(Color.ORANGE);
			p2.setBackground(Color.ORANGE);
			p3.setBackground(Color.ORANGE);

		}else if(e.getSource() == b6){
			p1.setBackground(Color.CYAN);
			p2.setBackground(Color.CYAN);
			p3.setBackground(Color.CYAN);

		}

		
		
		
		
	}
	public static void main(String[] args) {
		new ButtonAndBgColor();
	}

}
