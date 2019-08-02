import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

public class Student extends JFrame implements ActionListener{
	
	JLabel lblName,lblGender,lblHobby,lblBDay,lblClass;
	JTextField txtName;
	JRadioButton rdoMale,rdoFemale;
	JCheckBox chkSwim,chkTennis,chkSoccer,chkMusic;
	JSpinner spinner;
	JComboBox cboClass;
	JButton btnCancel,btnSave,btnExit;
	
	static Connection conn;
	static String url = "jdbc:mysql://localhost:3306/mystudent";
	static String username = "root";
	static String password = "";
	static String sql;
	static PreparedStatement stmt=null;
	
	Student(){
		super("Student Registration");
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
      	setSize((int)d.getWidth(),(int)d.getHeight());
      	setLocationRelativeTo(null);
      	int x=(int)((d.getWidth()-this.getWidth()))/2;
		int y=(int)((d.getHeight()-this.getHeight()))/2;
		setLocation(x,y);//Set Position on the screen	       
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblName=new JLabel("名前:");
		lblBDay=new JLabel("誕生日:");
		lblClass=new JLabel("Level:");
		lblGender=new JLabel("性別:");
		lblHobby=new JLabel("趣味:");
		
		txtName = new JTextField(20);
		Calendar now = Calendar.getInstance();
		Calendar earliest = (Calendar)now.clone();
		earliest.add( Calendar.YEAR, -100 );
		Calendar latest = (Calendar)now.clone();
		latest.add( Calendar.YEAR, 20);
		SpinnerModel model = new SpinnerDateModel(now.getTime(), earliest.getTime(), latest.getTime(),Calendar.DATE);
		spinner = new JSpinner(model);// Disable the built-in date editor        
		spinner.setEditor(new JSpinner.DefaultEditor(spinner) );
		
		cboClass=new JComboBox();
		cboClass.addItem("1st Year");
		cboClass.addItem("2nd Year");
		cboClass.addItem("3rd Year");
		cboClass.addItem("4th Year");
		cboClass.addItem("Final Year");
		
		rdoMale=new JRadioButton("Male",true);
		rdoFemale=new JRadioButton("Female");
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdoFemale);
		bg.add(rdoMale);
		JPanel pnlRadio=new JPanel();
		pnlRadio.add(rdoMale);
		pnlRadio.add(rdoFemale);
		
		chkMusic=new JCheckBox("Music");
		chkSwim=new JCheckBox("Swimming");
		chkTennis=new JCheckBox("Tennis");
		chkSoccer=new JCheckBox("Soccer");

		JPanel pnlChk = new JPanel();
		pnlChk.add(chkMusic);
		pnlChk.add(chkSwim);
		pnlChk.add(chkTennis);
		pnlChk.add(chkSoccer);

		btnCancel=new JButton("Cancel");
		btnExit=new JButton("Exit");
		btnSave=new JButton("Save");
		
		JPanel pnlButton=new JPanel();
		pnlButton.add(btnSave);
		pnlButton.add(btnCancel);
		pnlButton.add(btnExit);
		
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		btnExit.addActionListener(this);
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(5,2));
		
		p1.add(lblName);
		p1.add(txtName);
		p1.add(lblGender);
		p1.add(pnlRadio);
		p1.add(lblBDay);
		p1.add(spinner);
		p1.add(lblClass);
		p1.add(cboClass);
		p1.add(lblHobby);
		p1.add(pnlChk);

		this.getContentPane().add(p1, BorderLayout.CENTER);
		this.getContentPane().add(pnlButton,BorderLayout.SOUTH);
		setVisible(true);
		setResizable(false);

	}
	public static void main(String[] args) {
		new Student();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnSave){
			int yn=JOptionPane.showConfirmDialog(this,"Are you sure you want to save","Confirmation",1);
			if(yn==0) // 0=yes, 1=no, 2=cancel
			{
				String st="";
				String name=txtName.getText();
				String gender="";
				if(rdoMale.isSelected())
				{
					gender="M";
				}
				else
				{
					gender="F";
				}
				String hobby="";
				if(chkMusic.isSelected())
					hobby+="Music ";
				if(chkSoccer.isSelected())
					hobby+="Soccer ";
				if(chkTennis.isSelected())
					hobby+="Tennis ";
				if(chkSwim.isSelected())
					hobby+="Swimming ";
				String cl=cboClass.getSelectedItem().toString();
				
				Date d=(Date)spinner.getValue();
				java.sql.Date sqlDate = new java.sql.Date(d.getTime());
				//db begin
				createDB();
				try{
					sql="insert into student(name,gender,hobby,class,dateofbirth) values(?,?,?,?,?)";
					stmt = conn.prepareStatement(sql);
					stmt.setString(1,name); 
					stmt.setString(2,gender); 
					stmt.setString(3,hobby);  
					stmt.setString(4,cl);  
					stmt.setDate(5,sqlDate); 
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
			}
		}else if (e.getActionCommand().equals("Cancel")){
			txtName.setText("");
			rdoMale.setSelected(true);
			rdoFemale.setSelected(false);
			cboClass.setSelectedIndex(0);
			chkMusic.setSelected(false);
			chkSoccer.setSelected(false);
			chkSwim.setSelected(false);
			chkTennis.setSelected(false);

			
		}else{

			System.exit(0);
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
