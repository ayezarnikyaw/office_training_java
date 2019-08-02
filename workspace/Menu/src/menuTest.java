import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class menuTest extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu menuFile;
	JMenuItem menuitemNew,menuitemOpen,menuitemSave,menuitemExit;
	
	menuTest(){
		setTitle("Menu Test");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)d.getWidth(),(int)d.getHeight());
      	//setExtendedState(JFrame.MAXIMIZED_BOTH); 
      	//setUndecorated(true);

		setLocationRelativeTo(null);
		int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);//Set Position on the screen	       
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mb=new JMenuBar();
		
		menuFile=new JMenu("File");
		
		menuitemNew=new JMenuItem("New");
		menuitemOpen=new JMenuItem("Open");
		menuitemSave=new JMenuItem("Save");
		menuitemExit=new JMenuItem("Exit");

		menuitemNew.setMnemonic(KeyEvent.VK_B);
		menuitemNew.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		JRadioButtonMenuItem showLinksMenu = new JRadioButtonMenuItem(
		         "Show Links", true);
		
		JCheckBoxMenuItem showWindowMenu = new JCheckBoxMenuItem(
		         "Show About", true);
		
		mb.add(menuFile);
		menuFile.add(menuitemNew);
		menuFile.add(menuitemOpen);
		menuFile.add(menuitemSave);
		menuFile.add(showLinksMenu);
		menuFile.add(showWindowMenu);
		menuFile.addSeparator();
		menuFile.add(menuitemExit);
		
		this.setJMenuBar(mb);		
		
		menuitemNew.addActionListener(this);
		menuitemOpen.addActionListener(this);
		menuitemSave.addActionListener(this);
		menuitemExit.addActionListener(this);
		
		setVisible(true);


	}
	public static void main(String[] args) {
		new menuTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==menuitemNew)
		{
			//new Student();
			//this.dispose();
			JOptionPane.showMessageDialog(this,"New","Information", 1);
		}
		else if(e.getSource()==menuitemOpen)
		{
			JOptionPane.showMessageDialog(this,"Open","Information", 1);
		}
		else if(e.getSource()==menuitemSave)
		{
			JOptionPane.showMessageDialog(this,"Save","Information", 1);
		}
		else if(e.getSource()==menuitemExit)
		{
			System.exit(0);
		}

	}


}
