package superise;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class numcalculator extends JFrame implements ActionListener{
	JLabel Number = new JLabel("Enter a number");
	JTextField txtNumber;
	JTextArea area;
	JButton display;
	JPanel p1,p2,p3;
	
	public numcalculator() {
		// TODO Auto-generated constructor stub
		super("Multiplication Table");
		txtNumber = new JTextField(10);
		area = new JTextArea(20,20);
		display = new JButton("Display");
		
		setSize(290,200);
		 p1 = new JPanel();
		 p1.add(Number);
		 p1.add(txtNumber);
		 
//		 p2=new JPanel();
		// p2.add(area);
		 
		 p3=new JPanel();
		 p3.add(display);
		 
		 Container c = this.getContentPane();
		 c.add(p1, BorderLayout.NORTH);
		 c.add(p3,BorderLayout.SOUTH);
		 c.add(new JScrollPane(area),BorderLayout.CENTER);
		 
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.setVisible(true);
		  display.addActionListener(this);
		
				
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == display){
			
			int number = Integer.parseInt(txtNumber.getText());	
			int i;
			for(i=1;i<=12;i++){
				area.append (number+"*"+i+"="+(number*i)+"\n");
			}
			
						
			
		}
	}
	public static void main(String[] args) {
		new numcalculator();
	}

}
