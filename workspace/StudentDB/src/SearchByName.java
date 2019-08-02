import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchByName extends JFrame implements ActionListener {

	JButton btnBack,btnSearch;
	JTextField name;
	JTextArea area;
	Connection conn;
	String username = "root";
	String password = "";
	String url="jdbc:mysql://localhost:3306/mystudent";
	
	JScrollPane scrollpane;
	
	SearchByName(){
		setSize(500,500);
		setTitle("Search By Name");
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnSearch=new JButton("Search");
		
		name=new JTextField(20);
		area=new JTextArea(5,40);
		createDB();		
		Statement st;
		try {
			st = conn.createStatement();
			String query="select * from student";
			String count="select count(*) as count from student";

			
			ResultSet rs = st.executeQuery(query);
			
			String s="Name\tGender\tHobby\tClass\tDateOfBirth\n";
			  
			while (rs.next())
			{
						    	               	
			s+= rs.getString("name")+"\t";
			s+= rs.getString("gender")+"\t";
			s+= rs.getString("hobby")+"\t";
			s+= rs.getString("class")+"\t";
			s+= rs.getDate("dateOfBirth")+"\n";

			} 			



			area.setText(s);
				  
		}catch (SQLException e) {
					
			e.printStackTrace();
		}
		
		JPanel p1=new JPanel();
		p1.add(name);
		p1.add(btnSearch);
		getContentPane().add(p1, BorderLayout.NORTH);
		btnSearch.addActionListener(this);
		btnBack=new JButton("Back");
		JPanel p2=new JPanel();
		p2.add(btnBack);
		getContentPane().add(p2, BorderLayout.SOUTH);
		btnBack.addActionListener(this);
								      
		scrollpane = new JScrollPane(area);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
				
		this.setVisible(true);		
	}
	
	
	private void createDB() {
		// TODO Auto-generated method stub
		try{
			
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (url, username, password);
			
		}catch(Exception e){
			
			System.out.println("connection error");
		}		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(e.getSource()==btnBack)
			{
				new StudentManagement();
				this.dispose();
			}
			else if(e.getSource()==btnSearch)
			{
				createDB();
				PreparedStatement stmt2 = null;
				String strName = name.getText();
				
			try {
								
				String query = "select * from student where name like '%" + strName + "%'";
				stmt2 = conn.prepareStatement(query);

				ResultSet rs = stmt2.executeQuery();
				String s="Name\tGender\tHobby\tClass\t\tDateOfBirth\n";
				while (rs.next())
				{		         	
				s+= rs.getString("name")+"\t";
				s+=  rs.getString("gender")+"\t";
				s+=  rs.getString("hobby")+"\t";
				s+=   rs.getString("class")+"\t";
				s+= rs.getDate("dateOfBirth")+"\n";
				}
				area.setText(s);
				stmt2.close();
				conn.close();
			} catch (SQLException e1) {
								
				e1.printStackTrace();
			  }
			                  
		}		
	}
}
