import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AssignmentI extends JFrame implements ActionListener{
	
	JLabel lblName = new JLabel("Enter Name");
	JLabel lblGender = new JLabel("Choose Gender");
	JTextField Name;
	JRadioButton Male,Female;
	JButton Show,Cancel;
	
	public AssignmentI() {
		super("Greeting");
		
		Name = new JTextField(20);
		
		Male = new JRadioButton("Male",true);
		Female = new JRadioButton("Female");
		ButtonGroup bg = new ButtonGroup();
		bg.add(Male);
		bg.add(Female);
		JPanel rdopnl = new JPanel();
		rdopnl.add(Male);
		rdopnl.add(Female);
		
		Show = new JButton("Show");
		Cancel = new JButton("Cancel");
		JPanel btnpnl = new JPanel();
		btnpnl.add(Show);
		btnpnl.add(Cancel);
		
		Show.addActionListener(this);
		Cancel.addActionListener(this);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		panel.add(lblName);
		panel.add(Name);
		panel.add(lblGender);
		panel.add(rdopnl);
				
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.getContentPane().add(btnpnl, BorderLayout.SOUTH);
		setVisible(true);
		setSize(290,200);
		setLocation(200,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new AssignmentI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Cancel"){
			Name.setText("");
		}
		
		if(e.getSource() == Show){
			String strName = Name.getText();
			String value;
			if(Male.isSelected()){
				value = "Mr." + strName;
			}else{
				value ="Mrs." + strName;
			}
			JOptionPane.showMessageDialog(this,value,"Greeting",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
