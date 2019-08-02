import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateDeleteExample extends JFrame implements ActionListener,ItemListener {
	JLabel l1,l2,l3,l4,l5;
	JTextField txt2,txt3,txt4,txt5;
	JComboBox cboRno;
	JButton b1,b2;			
	Connection conn;
	String username = "root";
	String password = "";
	String url="jdbc:mysql://localhost:3306/mystudent";
	UpdateDeleteExample()
	{
		super("Student Data Modification");
		setSize(300,300);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1=new JButton("Update");
		b2=new JButton("Delete");
		
		l1=new JLabel("Roll No");
		l2=new JLabel("Name");
		l3=new JLabel("Phone Number");
		l4=new JLabel("Email");
		l5=new JLabel("Address");
		
		cboRno=new JComboBox();
		
		createDB();		
	    Statement st;
		try {
			st = conn.createStatement();
			String query="select distinct(roll_no) from studentbcmm";
		    ResultSet rs = st.executeQuery(query);
		    while (rs.next())
		      {
		    	cboRno.addItem(rs.getString(1));
		      }
		  
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		txt2=new JTextField(20);
		txt3=new JTextField(20);
		txt4=new JTextField(20);
		txt5=new JTextField(20);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(5,2));
		p.add(l1);
		p.add(cboRno);
		p.add(l2);
		p.add(txt2);
		p.add(l3);
		p.add(txt3);
		p.add(l4);
		p.add(txt4);
		p.add(l5);
		p.add(txt5);
		
		Container c=getContentPane();
		c.add(p,BorderLayout.CENTER);
		JPanel p2=new JPanel();
		p2.add(b1);
		p2.add(b2);
		c.add(p2,BorderLayout.SOUTH);
		b1.addActionListener(this);
		b2.addActionListener(this);
		cboRno.addItemListener(this);
		cboRno.setSelectedIndex(0);
		showData();
		show();
	}
	void createDB()
	{
		try{
		
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (url, username, password);
		}
		catch(Exception e)
		{
			System.out.println("connection error");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)
		{
			createDB();
			  int len;
              String query;
              PreparedStatement stmt2 = null;
  			int res=JOptionPane.showConfirmDialog(this,"Are u sure u want to modify");
  			if(res==0)
  			{
  				try {
  					stmt2 = conn.prepareStatement("update studentbcmm set name=?,phone_no=?,email=?,address=? where roll_no=?" );
  				} catch (SQLException ex) {
  						ex.printStackTrace();
  				} 

  				try {
  					String strrno=cboRno.getSelectedItem().toString();
  					String sname=txt2.getText();               
  					
  					stmt2.setString(1,sname);
  					stmt2.setInt(2,Integer.parseInt(txt3.getText()));
  					stmt2.setString(3,txt4.getText());//stmt2.setInt(4,txt4.getText());
  					stmt2.setString(4,txt5.getText());  					
  					stmt2.setString(5,strrno);
  					
  					stmt2.executeUpdate();											  	                          
  											                         
  					stmt2.close (); 
  					
  					conn.close (); 
  					JOptionPane.showMessageDialog(this,"Data has been updated","Inform",1);
  				} catch (SQLException ex) {  					
  					ex.printStackTrace();
  				}
  			}
		}	
		else if(e.getSource()==b2)
		{
			createDB();
			  int len;
              String query;
              PreparedStatement stmt2 = null;
  			int res=JOptionPane.showConfirmDialog(this,"Are u sure u want to remove");
  			if(res==0)
  			{
  				try {
  					stmt2 = conn.prepareStatement("delete from studentbcmm where roll_no=?" );
  				} catch (SQLException ex) {
  						ex.printStackTrace();
  				} 

  				try {
  					String strrno=cboRno.getSelectedItem().toString();
  					              
  					
  				  					
  					stmt2.setString(1,strrno);
  					
  					stmt2.executeUpdate();											  	                          
  											                         
  					stmt2.close (); 
  					
  					conn.close (); 
  					JOptionPane.showMessageDialog(this,"One has been deleted","Inform",1);
  				} catch (SQLException ex) {  					
  					ex.printStackTrace();
  				}
  				this.dispose();
  				new UpdateDeleteExample();
  			}
		}	
	}
	public static void main(String[] args) {
		new UpdateDeleteExample();
	}
	@Override
	public void itemStateChanged(ItemEvent e1) {
		if(e1.getSource()==cboRno)
		{  
			showData();
		}
		
		
	}
	private void showData() {
		 createDB();
			PreparedStatement stmt2 = null;
			  
			try {
					
					String query="select * from studentbcmm where roll_no=?";
					stmt2 = conn.prepareStatement(query);
					stmt2.setString(1,cboRno.getSelectedItem().toString());
				    ResultSet rs = stmt2.executeQuery();
				      
				   String s="Roll No\tName\tPhone\tEmail\tAddress\n";
				  
				    while (rs.next())
				      {
				    	               	
			                    
			                    txt2.setText(rs.getString("name"));
			                    txt3.setText(rs.getInt("phone_no")+"");
			                    txt4.setText(rs.getString("email"));
			                    txt5.setText(rs.getString("address"));
			                   
				        
				      }
				  
				   
				      stmt2.close();
				      conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}


