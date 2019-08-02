
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchAll extends JFrame implements ActionListener{
	JButton btnBack;
	Connection conn;
	String username = "root";
	String password = "";
	String url="jdbc:mysql://localhost:3306/mystudent";
	SearchAll()
	{
		setSize(500,500);
		setTitle("All Students' Data");
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createDB();		
	    Statement st;
	    JTable t1 = null ;
		try {
				st = conn.createStatement();
				String query="select * from student";
			    ResultSet rs = st.executeQuery(query);
			      
			    DefaultTableModel dtm = new DefaultTableModel();
			    ResultSetMetaData meta = rs.getMetaData();
			    
		        int numberOfColumns = meta.getColumnCount();
		        rs.last();
		        int noOfRow=rs.getRow();
		        Object [][] rowData = new Object[noOfRow][numberOfColumns];
		         
		        rs.beforeFirst();
		         int i=0;
			    while (rs.next())
			      {rowData[i][0] = rs.getString("name");
		              rowData[i][1] = rs.getString("gender");
		              rowData[i][2] = rs.getString("hobby")+"";
		              rowData[i][3] =  rs.getString("class");
		              rowData[i][4] =rs.getDate("dateOfBirth");
		              i++;
			        
			      }
	     
			   String[] columnNames = {"Name","Gender","Hobby","Class","DateOfBirth"};
			      t1 = new JTable(rowData,columnNames);
			    
			      st.close();
			      conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		JScrollPane scrollpane = new JScrollPane(t1);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		btnBack=new JButton("Back");
		JPanel p=new JPanel();
		p.add(btnBack);
		getContentPane().add(p, BorderLayout.SOUTH);
		btnBack.addActionListener(this);
		this.setVisible(true);
		
	}
	void createDB()
	{	try{		
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (url, username, password);
		}
		catch(Exception e)
		{	System.out.println("connection error");
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnBack)
		{
			new StudentManagement();
			this.dispose();
		}
	}

}

