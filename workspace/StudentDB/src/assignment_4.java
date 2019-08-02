import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class assignment_4 extends JFrame implements ActionListener{
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	JTextField txt1,txt2,txt3,txt4,txt5;
	JComboBox combo;
	JButton save,cancel,exit;
	
	static Connection conn;
	static String url = "jdbc:mysql://localhost:3306/mystudent";
	static String username = "root";
	static String password = "";
	static String sql;
	static PreparedStatement stmt=null;
	public String idFirst = "m-";
	public int idSecond = 0;

	
	
	public assignment_4() {
		// TODO Auto-generated constructor stub
		super("Movie");
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
      	setSize((int)d.getWidth(),(int)d.getHeight());
      	setLocationRelativeTo(null);
      	int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);//Set Position on the screen	       
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		lbl1 = new JLabel("Movie ID:");
		lbl2 = new JLabel("Movie Name:");
		lbl3 = new JLabel("Actor:");
		lbl4 = new JLabel("Actress:");
		lbl5 = new JLabel("Director:");
		lbl5 = new JLabel("Director:");
		lbl6 = new JLabel("Movie Type:");
		txt1 = new JTextField("1");	
		txt1.setEnabled(false);
		txt2 = new JTextField(20);
		txt3 = new JTextField(20);
		txt4 = new JTextField(20);
		txt5 = new JTextField(20);
		
		combo=new JComboBox();
		combo.addItem("Action");
		combo.addItem("Adventure");
		combo.addItem("comedy");
		combo.addItem("Crime");
		combo.addItem("Drama");
		combo.addItem("Fiction");
		combo.addItem("Historical");
		

		save = new JButton("Save");
		cancel = new JButton("Cancel");
		exit = new JButton("Exit");
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(6,2));
		
		
		JPanel pnlbtn = new JPanel();
		pnlbtn.add(save);
		pnlbtn.add(cancel);
		pnlbtn.add(exit);

		save.addActionListener(this);
		cancel.addActionListener(this);
		exit.addActionListener(this);
		
		p1.add(lbl1);
		p1.add(txt1);
		p1.add(lbl2);
		p1.add(txt2);
		p1.add(lbl3);
		p1.add(txt3);
		p1.add(lbl4);
		p1.add(txt4);
		p1.add(lbl5);
		p1.add(txt5);
		p1.add(lbl6);
		p1.add(combo);
		
		selectData();	
		
		this.getContentPane().add(p1, BorderLayout.CENTER);
		this.getContentPane().add(pnlbtn,BorderLayout.SOUTH);
		

		
		setVisible(true);
		setResizable(false);		
	}
	
	
	public static void main(String[] args) {

		new assignment_4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		if(e.getSource()== save){
			
			String mid = txt1.getText();
			String mname = txt2.getText();
			String actor = txt3.getText();
			String actress = txt4.getText();
			String director = txt5.getText();				
			String cl=combo.getSelectedItem().toString();
			
			if(mname.equals("") || actor.equals("") || actress.equals("") || director.equals("")){

				JOptionPane.showMessageDialog(null, "Please Fill Data");

			}else{		
				
				int yn=JOptionPane.showConfirmDialog(this,"Are you sure you want to save","Confirmation",1);
				if(yn == 0){// 0=yes, 1=no, 2=cancel
	

						createDB();
						
						try{
	
							sql="insert into movie(mid,mname,actor,actress,director,mtype) values(?, ?, ?, ? , ?, ?)";
							stmt = conn.prepareStatement(sql);
							stmt.setString(1,mid); 
							stmt.setString(2,mname); 
							stmt.setString(3,actor);  
							stmt.setString(4,actress);  
							stmt.setString(5,director);
							stmt.setString(6,cl); 
						}catch(SQLException e1){
							e1.printStackTrace();

						}
						//try
						try{
							int execute = stmt.executeUpdate();
						}catch (SQLException e1){
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(this,"One row has been inserted","Information",1);
						selectData();
		  				this.dispose();
						new assignment_4().setVisible(true);
				}
  
		
			}
		}else if (e.getActionCommand().equals("Cancel")){
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			txt4.setText("");
			txt5.setText("");
			combo.setSelectedIndex(0);


			
		}else{

			System.exit(0);
		}		
		
	}
	
	public void selectData(){
		
		createDB();
		try {
			
			Statement stmt;
			stmt = conn.createStatement();
			String query="select * from movie";

			ResultSet rs = stmt.executeQuery(query);

		    ResultSetMetaData meta = rs.getMetaData();
		    

	        
	        rs.last();
	        int noOfRow=rs.getRow();
	        
	        if (noOfRow == 0 ) {
	        	
	        	idSecond += 1;
				txt1.setText("m-00"+idSecond);
			
	        } else {

	        	String mid = rs.getString(1);
	        	String[] mSid = mid.split("-",2);
	        	idSecond = Integer.parseInt(mSid[1])+1;

				
				if (idSecond < 10) {
					
					idFirst = "m-00";
					
				} else if (idSecond < 100) {
					
					idFirst = "m-0";
					
				} else if (idSecond < 1000) {
					
					idFirst = "m-";
					
				} else {
					
					JOptionPane.showMessageDialog(this, "Movie id is greater than 999 ");
				}
				String id = idFirst+""+idSecond;			
				txt1.setText(id);
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				txt5.setText("");
			}
	        
	        stmt.close();
	        conn.close();
	      
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	static void createDB() {
		// TODO Auto-generated method stub
		try{
			Class.forName  ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			
		}catch(Exception e){
			System.out.println("connection error");
		}
		
	}
}
