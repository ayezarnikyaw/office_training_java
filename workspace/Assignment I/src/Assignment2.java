import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Assignment2 extends JFrame implements ActionListener{
	JMenuBar operationBar;
	JMenu operationMenu;
	JMenuItem add,sub,mul,div,exit;
	JTextField add1,add2,add3,sub1,sub2,sub3,mul1,mul2,mul3,div1,div2,div3;
	JButton btnadd,btnsub,btnmul,btndiv;
	JPanel pmain,p1,p2,p3,p4;
	Container c;
	
	public Assignment2() {
		// TODO Auto-generated constructor stub
		setTitle("Menu Test");
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
      	setSize((int)d.getWidth(),(int)d.getHeight());
      	
      	setLocationRelativeTo(null);
      	int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);	       
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
          operationBar = new JMenuBar();      
          operationMenu =new JMenu("Operation");

          add = new JMenuItem("addition");
          sub = new JMenuItem("subtration");
          mul = new JMenuItem("multiplication");
          div = new JMenuItem("division");
          exit = new JMenuItem("exit");
          
          add.setMnemonic(KeyEvent.VK_A);
          add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
          
          sub.setMnemonic(KeyEvent.VK_S);
          sub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
          
          mul.setMnemonic(KeyEvent.VK_M);
          mul.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
          
          div.setMnemonic(KeyEvent.VK_D);
          div.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
          
          exit.setMnemonic(KeyEvent.VK_E);
          exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));

          add1=new JTextField(10);
          add2=new JTextField(10);
          add3=new JTextField(10);
          sub1=new JTextField(10);
          sub2=new JTextField(10);
          sub3=new JTextField(10);
          mul1=new JTextField(10);
          mul2=new JTextField(10);
          mul3=new JTextField(10);
          div1=new JTextField(10);
          div2=new JTextField(10);
          div3=new JTextField(10);
         
          p1=new JPanel();
          p1.add(add1);
          p1.add(new JLabel("+"));
          p1.add(add2);
          p1.add(new JLabel("="));
          p1.add(add3);
          p1.add(btnadd=new JButton("ADD"));
          
          p2=new JPanel();
          p2.add(sub1);
          p2.add(new JLabel("-"));
          p2.add(sub2);
          p2.add(new JLabel("="));
          p2.add(sub3);
          p2.add(btnsub=new JButton("SUB"));
          
          p3=new JPanel();
          p3.add(mul1);
          p3.add(new JLabel("*"));
          p3.add(mul2);
          p3.add(new JLabel("="));
          p3.add(mul3);
          p3.add(btnmul=new JButton("MUL"));
         
          p4=new JPanel();
          p4.add(div1);
          p4.add(new JLabel("/"));
          p4.add(div2);
          p4.add(new JLabel("="));
          p4.add(div3);
          p4.add(btndiv=new JButton("DIV"));

          pmain=new JPanel();
          pmain.add(p1);
          pmain.add(p2);
          pmain.add(p3);
          pmain.add(p4);

          c=this.getContentPane();
          c.add(operationBar,BorderLayout.NORTH);
          c.add(pmain,BorderLayout.CENTER);   
      	
      	  p1.setVisible(false);
      	  p2.setVisible(false);
      	  p3.setVisible(false);
      	  p4.setVisible(false);

      	  
          operationBar.add(operationMenu);
          operationMenu.add(add);
          operationMenu.add(sub);
          operationMenu.add(mul);
          operationMenu.add(div);
          operationMenu.addSeparator();
          operationMenu.add(exit);
          
          this.setJMenuBar(operationBar);
          
          add.addActionListener(this);
          sub.addActionListener(this);
          mul.addActionListener(this);
          div.addActionListener(this);
          exit.addActionListener(this);

          btnadd.addActionListener(this);
          btnsub.addActionListener(this);
          btnmul.addActionListener(this);
          btndiv.addActionListener(this);
          
          setVisible(true);
          
          
	}
	public static void main(String[] args) {
		new Assignment2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add){
			
			p1.setVisible(true);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(false);
											
		}else if(e.getSource() == sub){
			
			p1.setVisible(false);
			p2.setVisible(true);
			p3.setVisible(false);
			p4.setVisible(false);		
			
		}else if(e.getSource() == mul){
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(true);
			p4.setVisible(false);				
		}
		else if(e.getSource() == div){
			p1.setVisible(false);
			p2.setVisible(false);
			p3.setVisible(false);
			p4.setVisible(true);	
			
		}else if(e.getSource() == exit){
			
			System.exit(0);			
		}
		
		if(e.getSource() == btnadd){					
//			int value = Integer.parseInt(add1.getText()) + Integer.parseInt(add2.getText());
			double value = Double.parseDouble(add1.getText()) + Double.parseDouble(add2.getText());
			add3.setText(String.valueOf(value));

		}else if(e.getSource() == btnsub){					

			double value = Double.parseDouble(sub1.getText()) - Double.parseDouble(sub2.getText());
			sub3.setText(String.valueOf(value));
		}else if(e.getSource() == btnmul){					

			double value = Double.parseDouble(mul1.getText()) * Double.parseDouble(mul2.getText());
			mul3.setText(String.valueOf(value));
		}else if(e.getSource() == btndiv){					

			double value = Double.parseDouble(div1.getText()) / Double.parseDouble(div2.getText());
			div3.setText(String.valueOf(value));
		}
		

	}




}
