package AWT;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class label_ex extends JFrame implements ActionListener{
	JLabel lblName,lblAge;
	JTextField txtName,txtAge;
	JPanel p1,p2,p3,p;
	JButton btnShow;
	label_ex(){
		super("Label Example1");//for label
//		setTitle("label Example");
//		setSize(400,100);
		setLocation(100,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblName = new JLabel("Enter your name");
		lblAge = new JLabel("Enter your age");
		txtName = new JTextField("Mg Mg",15);
		txtAge = new JTextField(15);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p = new JPanel();
		
		btnShow = new JButton("show");
		p1.add(txtName);
		p2.add(txtAge);
		p3.add(btnShow);		
		
		Container c= getContentPane();
		p.setLayout(new GridLayout(2, 2));
		p.add(lblName);
		p.add(p1);
		p.add(lblAge);
		p.add(p2);
		
		
		c.setLayout(new BorderLayout());
		c.add(p, BorderLayout.CENTER);
		c.add(p3, BorderLayout.SOUTH);
		btnShow.addActionListener(this);
		c.add(p);
		this.pack(); //setsize
		setVisible(true);
		
		
		
	
	}
	
	public static void main(String[] args) {
		new label_ex();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnShow){
			String strName=txtName.getText();
			int age=Integer.parseInt(txtAge.getText());
			String str = "Name:" + strName + "\nAge" + age;
			JOptionPane.showMessageDialog(this,"information",str,JOptionPane.INFORMATION_MESSAGE);
			
			
			
		}
		
	}

}
