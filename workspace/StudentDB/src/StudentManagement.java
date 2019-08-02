import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StudentManagement extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu mnSearch;
    JMenuItem SearchAll, SearchByName,SearchByClass,Exit;
	
	StudentManagement(){
		setSize(300,300);
		setTitle("Student Management");
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mb = new JMenuBar();
		mnSearch=new JMenu("Search");
		SearchAll=new JMenuItem("ALL");
		SearchByName=new JMenuItem("By Name");
		SearchByClass=new JMenuItem("By Class");
		Exit=new JMenuItem("Exit");
		
		mb.add(mnSearch);
		mnSearch.add(SearchAll);
		mnSearch.add(SearchByName);
		mnSearch.add(SearchByClass);
		mnSearch.addSeparator();
		mnSearch.add(Exit);
		this.setJMenuBar(mb);
		
		SearchAll.addActionListener(this);
		SearchByName.addActionListener(this);
		SearchByClass.addActionListener(this);
		Exit.addActionListener(this);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new StudentManagement();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==SearchAll)
		{
			new SearchAll();
			this.dispose();
		}
		else if(e.getSource()==SearchByName)
		{
			new SearchByName();
			this.dispose();
		}
		else if(e.getSource()==SearchByClass)
		{
			new SearchByClass();
			this.dispose();
		}
		else if(e.getSource()==Exit)
		{
			System.exit(0);
		}
		
	}

}
