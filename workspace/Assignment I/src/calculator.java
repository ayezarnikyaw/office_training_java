

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

public class calculator extends JFrame implements ActionListener{
	JMenuBar jm;
	JMenu opmenu;
	JMenuItem add,sub,multi,div,exit;
	JPanel padd,psub,pmulti,pdiv,pmain;
	JTextField txtadd1,txtadd2,txtadd3,txtsub1,txtsub2,txtsub3,txtmul1,txtmul2,txtmul3,txtdiv1,txtdiv2,txtdiv3;
	JButton btnadd,btnsub,btnmulti,btndiv;
	Container c;
	public calculator(){
		setTitle("Menu Test");
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
      	setSize((int)d.getWidth(),(int)d.getHeight());
      	setLocationRelativeTo(null);
      	int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);	       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jm=new JMenuBar();
        
        opmenu=new JMenu("Operation");
        jm.add(opmenu);
        
        add=new JMenuItem("ADD");
       
        opmenu.add(add);
        opmenu.add(sub=new JMenuItem("SUB"));
        opmenu.add(multi=new JMenuItem("MULTIPLICATION"));
        opmenu.add(div=new JMenuItem("DIVISION"));
        opmenu.addSeparator();
        opmenu.add(exit=new JMenuItem("Exit"));
        
        add.setMnemonic(KeyEvent.VK_A);
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        
        sub.setMnemonic(KeyEvent.VK_S);
        sub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        
        multi.setMnemonic(KeyEvent.VK_M);
        multi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        
        div.setMnemonic(KeyEvent.VK_D);
        div.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        
        exit.setMnemonic(KeyEvent.VK_E);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        
        txtadd1=new JTextField(10);
        txtadd2=new JTextField(10);
        txtadd3=new JTextField(10);
        txtsub1=new JTextField(10);
        txtsub2=new JTextField(10);
        txtsub3=new JTextField(10);
        txtmul1=new JTextField(10);
        txtmul2=new JTextField(10);
        txtmul3=new JTextField(10);
        txtdiv1=new JTextField(10);
        txtdiv2=new JTextField(10);
        txtdiv3=new JTextField(10);
        
        padd=new JPanel();
        padd.add(txtadd1);
        padd.add(new JLabel("+"));
        padd.add(txtadd2);
        padd.add(new JLabel("="));
        padd.add(txtadd3);
        padd.add(btnadd=new JButton("ADD"));
        
        psub=new JPanel();
        psub.add(txtsub1);
        psub.add(new JLabel("-"));
        psub.add(txtsub2);
        psub.add(new JLabel("="));
        psub.add(txtsub3);
        psub.add(btnsub=new JButton("SUB"));
        
        pmulti=new JPanel();
        pmulti.add(txtmul1);
        pmulti.add(new JLabel("*"));
        pmulti.add(txtmul2);
        pmulti.add(new JLabel("="));
        pmulti.add(txtmul3);
        pmulti.add(btnmulti=new JButton("MUL"));
       
        pdiv=new JPanel();
        pdiv.add(txtdiv1);
        pdiv.add(new JLabel("/"));
        pdiv.add(txtdiv2);
        pdiv.add(new JLabel("="));
        pdiv.add(txtdiv3);
        pdiv.add(btndiv=new JButton("DIV"));
        
        pmain=new JPanel();
        pmain.add(padd);
        pmain.add(psub);
        pmain.add(pmulti);
        pmain.add(pdiv);
           
        c=this.getContentPane();
        c.add(jm,BorderLayout.NORTH);
        c.add(pmain,BorderLayout.CENTER);   
    	
    	padd.setVisible(false);
    	psub.setVisible(false);
    	pmulti.setVisible(false);
    	pdiv.setVisible(false);
       
        
        add.addActionListener(this);
        sub.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);
        exit.addActionListener(this);
        
        btnadd.addActionListener(this);
        btnsub.addActionListener(this);
        btnmulti.addActionListener(this);
        btndiv.addActionListener(this);
   	
    	
    	this.setVisible(true);		
	}
		
	public static void main (String args[]){
		new calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==add)	{	
	        
		padd.setVisible(true);
		psub.setVisible(false);
		pmulti.setVisible(false);
		pdiv.setVisible(false);
				
		}
		else if(e.getSource()==sub){
			padd.setVisible(false);
			psub.setVisible(true);
			pmulti.setVisible(false);
			pdiv.setVisible(false);					
				}
		else if(e.getSource()==multi){
			padd.setVisible(false);
			psub.setVisible(false);
			pmulti.setVisible(true);
			pdiv.setVisible(false);
		}
		else if(e.getSource()==div){
			padd.setVisible(false);
			psub.setVisible(false);
			pmulti.setVisible(false);
			pdiv.setVisible(true);
		}
		else if(e.getSource()==exit){
			System.exit(0);
		}
				
		if(e.getSource()==btnadd){
			
		txtadd3.setText(String.valueOf((Integer.parseInt(txtadd1.getText())+Integer.parseInt(txtadd2.getText()))));
		}
		if(e.getSource()==btnsub){
			txtsub3.setText(String.valueOf((Integer.parseInt(txtsub1.getText())-Integer.parseInt(txtsub2.getText()))));
		}
		if(e.getSource()==btnmulti){
			txtmul3.setText(String.valueOf((Integer.parseInt(txtmul1.getText())*Integer.parseInt(txtmul2.getText()))));
		}
		if(e.getSource()==btndiv){
			txtdiv3.setText(String.valueOf((Integer.parseInt(txtdiv1.getText())/Integer.parseInt(txtdiv2.getText()))));
		}			
	}
}
