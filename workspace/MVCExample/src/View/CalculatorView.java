package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame{
	private JTextField txtNum1;
	private JLabel lblAdd;
	private JTextField txtNum2;
	private JButton btnCal;
	private JTextField txtSum;
	
	public CalculatorView(){
		super("MVC Test");
		setSize(1400,1500);
		
      	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//		int x=(int)((d.getWidth()-this.getWidth()))/2;
//		int y=(int)((d.getHeight()-this.getHeight()))/2;
      	setLocation(0,0);//Set Position on the screen	      
//		setLocation(x,y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtNum1 = new JTextField(10);
		lblAdd = new JLabel("+");
		txtNum2 = new JTextField(10);
		btnCal = new JButton("Calculate");
		txtSum = new JTextField(10);
		
		JPanel calcPanel = new JPanel();
		
		calcPanel.add(txtNum1);
		calcPanel.add(lblAdd);
		calcPanel.add(txtNum2);
		calcPanel.add(btnCal);
		calcPanel.add(txtSum);		
		this.add(calcPanel);

	}
	

	public int getFirstNumber(){
		return Integer.parseInt(txtNum1.getText());		
	}
	
	public int getSecondNumber(){
		return Integer.parseInt(txtNum2.getText());
	}
	public void setCalcSolution(int solution){
		txtSum.setText(Integer.toString(solution));
	}
	
	public void addCalculateListener(ActionListener listenForCalcButton){	
		btnCal.addActionListener(listenForCalcButton);	
	}	
	public void displayErrorMessage(String errorMessage){	
		JOptionPane.showMessageDialog(this, errorMessage);
	}

		       


}
