package AWT;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{
	JLabel lblUser, lblPwd;
	JTextField txtUser;
	JPasswordField txtPwd;
	JButton btnLogin,btnCancel;
	
	login(){
		setTitle("Login");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(300, 150);
		setLocation(100,200);
		
		txtUser=new JTextField(20);
		txtPwd=new JPasswordField(20);
		txtPwd.setEchoChar('*');
		
		lblUser=new JLabel("User name");
		lblPwd=new JLabel("Password");
		
		btnLogin=new JButton("Log in");
		btnCancel=new JButton("Cancel");
		Container c = getContentPane(); 
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(2,2));
		p1.add(lblUser);
		p1.add(txtUser);
		p1.add(lblPwd);
		p1.add(txtPwd);
		JPanel p2=new JPanel();
		p2.add(btnLogin);
		p2.add(btnCancel);
		
		c.add(p1,BorderLayout.CENTER);
		c.add(p2,BorderLayout.SOUTH);
		
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnLogin)
		{	String name=txtUser.getText();
			String pwd=new String(txtPwd.getPassword());
			if(name.equals("John")&&pwd.equals("123"))
			{	
				Home.name=txtUser.getText();
				new Home();	
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this,"Error", "Invalid User Name and Password",2);
			}
		}
		else
		{
			txtUser.setText("");
			txtPwd.setText("");
		}		
	}

		

}
