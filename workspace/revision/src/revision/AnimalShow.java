package revision;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AnimalShow extends JFrame implements ActionListener {
	JRadioButton cat = new JRadioButton("Cat");
	JRadioButton dog = new JRadioButton("Dog");
	JRadioButton monkey = new JRadioButton("Monkey");
	JRadioButton rabbit = new JRadioButton("Raddit");
	JRadioButton bear = new JRadioButton("bear");
	
	ButtonGroup btngroup = new ButtonGroup();
	JLabel lbl = new JLabel(new ImageIcon("animals/logo.jpg"));
	
	
	 public AnimalShow() {
		setTitle("Animals");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //full screen
		setSize((int)d.getWidth(),(int)d.getHeight());
		setLocationRelativeTo(null);
		
		int x = (int)((d.getWidth() - this.getWidth()))/2;
		int y = (int)((d.getHeight() - this.getHeight()))/2;
		setLocation(x, y);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p= new JPanel();
		
		p.add(bear);
		p.add(cat);
		p.add(dog);
		p.add(monkey);
		p.add(rabbit);
		
		btngroup.add(bear);
		btngroup.add(cat);
		btngroup.add(dog);
		btngroup.add(monkey);
		btngroup.add(rabbit);
		
		Container c= this.getContentPane();
		c.add(p, BorderLayout.NORTH);		
		c.add(lbl);
		
		cat.addActionListener(this);		
		dog.addActionListener(this);
		bear.addActionListener(this);
		rabbit.addActionListener(this);
		monkey.addActionListener(this);
		
		this.setVisible(true);


	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == cat)
		{
			lbl.setIcon(new ImageIcon("animals/cat.jpg"));
		}else if(obj == dog)
		{
			lbl.setIcon(new ImageIcon("animals/dog.jfif"));
		}else if(obj == bear)
		{
			lbl.setIcon(new ImageIcon("animals/bear.jfif"));
		}else if(obj == rabbit)
		{
			lbl.setIcon(new ImageIcon("animals/rabbit.jpg"));
		}else if(obj == monkey)
		{
			lbl.setIcon(new ImageIcon("animals/monkey.jfif"));
		}

		
	}
	
	public static void main(String[] args) {
		new AnimalShow();
	}

}
