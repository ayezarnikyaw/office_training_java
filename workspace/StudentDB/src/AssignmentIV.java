

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableModel;

public class AssignmentIV extends JFrame implements ActionListener{
	
	JLabel lblId, lblName, lblActor, lblActress, lblDirector, lblType;
	JTextField txtId, txtName, txtActor, txtActress, txtDirector;
	JComboBox< String> cbType = new JComboBox<>();	
	JButton btnSave, btnCancel, btnExit;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	String URL = "jdbc:mysql://localhost:3306/mystudent";
	String USERNAME = "root";
	String PASSWORD = "";
	Connection conn;
	private String idFirst = "m-";
	private int idSecond = 0;

	public AssignmentIV() {
		super("Movie");
		setResizable(false); 
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screen.width,screen.height);
		lblId = new JLabel("Movie Id");
		lblName = new JLabel("Movie Name");
		lblActor = new JLabel("Actor");
		lblActress = new JLabel("Actress");
		lblDirector = new JLabel( "Director");
		lblType = new JLabel("Type");
		
		txtId = new JTextField("jjjj");
		txtName = new JTextField();
		txtActor = new JTextField();
		txtActress = new JTextField();
		txtDirector = new JTextField();
		
		txtId.setEditable(false);
		cbType.addItem("Action");
		cbType.addItem("Adventure");
		cbType.addItem("Cemedy");
		cbType.addItem("Crime");
		cbType.addItem("Drama");
		cbType.addItem("Fantasy");
		cbType.addItem("Fiction");
		cbType.addItem("Historical");

		btnCancel = new JButton("Cancel");
		btnExit = new JButton("Exit");
		btnSave = new JButton("Save");
		
		p1.setLayout(new GridLayout(6, 2));
		p1.add(lblId);
		p1.add(txtId);
		p1.add(lblName);
		p1.add(txtName);
		p1.add(lblActor);
		p1.add(txtActor);
		p1.add(lblActress);
		p1.add(txtActress);
		p1.add(lblDirector);
		p1.add(txtDirector);
		p1.add(lblType);
		p1.add(cbType);
		
		p2.add(btnSave);
		p2.add(btnCancel);
		p2.add(btnExit);
		
		this.add(p1, BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);

		selectData();
		
		setVisible(true);
		
		btnCancel.addActionListener(this);
		btnExit.addActionListener(this);
		btnSave.addActionListener(this);
	}
	
	public static void main(String[] args){
		
		new AssignmentIV();
	}
	
	public void createDB(){
		try{		
			Class.forName ("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection (URL, USERNAME, PASSWORD);
		}
		catch(Exception e)
		{	System.out.println("connection error");
		}
		
	}
	
	public void insertData(){
		 
		createDB();
		
		try {
			
			PreparedStatement stmt = null;
			String query="insert into movie values(?,?,?,?,?,?)";
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, txtId.getText());
	        stmt.setString(2, txtName.getText());
	        stmt.setString(3, txtActor.getText());
	        stmt.setString(4, txtActress.getText());
	        stmt.setString(5, txtDirector.getText());
	        stmt.setString(6, cbType.getSelectedItem().toString());

	        int rs = stmt.executeUpdate();
	        	        
	        if (rs >= 0){
	        	
	        	JOptionPane.showMessageDialog(this, "Insert Successfully!");
	        	
	        } else {
	        	
	        	JOptionPane.showMessageDialog(this, "Insert Failed!");
	        	
	        }
	        conn.close();
	        stmt.close();

		} catch (Exception e) {
			// TODO: handle exception
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
				txtId.setText("m-00"+idSecond);
			
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
				txtId.setText(id);
				txtName.setText("");
				txtActor.setText("");
				txtActress.setText("");
				txtDirector.setText("");
			}
	        
	        stmt.close();
	        conn.close();
	      
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object v = e.getSource();
		if (v == btnExit) {
			
			System.exit(1);
		
		} else if (v == btnSave ) {
			
			if (txtName.getText().isEmpty()){
				
				JOptionPane.showMessageDialog(this, "Please enter movie name!");
			} else {
				int res = JOptionPane.showConfirmDialog(this, "Are you sure you want to save?");
				if (res == 0){
					insertData();
					selectData();
				}
			}
			
		}
		else {
			
			selectData();
			
			
		}
	}

}
