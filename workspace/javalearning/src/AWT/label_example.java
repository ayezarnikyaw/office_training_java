package AWT;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class label_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("Image Label Test");
		JLabel label1 = new JLabel("Penguin");
        JLabel label2 = new JLabel("Bear", SwingConstants.LEFT);
        
        JLabel label3 = new JLabel();
        label3.setText("and Owl");
        label3.setHorizontalAlignment(SwingConstants.RIGHT);

        Icon icon = new ImageIcon("images1.jfif");
		JLabel label4 = new JLabel(icon);
		
		Icon icon2 = new ImageIcon("images2.jfif");
		JLabel label5 = new JLabel(icon2);
		Icon icon3 = new ImageIcon("images3.jfif");
		JLabel label6 = new JLabel(icon3);
		Icon icon4 = new ImageIcon("images4.jfif");
		JLabel label7 = new JLabel(icon4);
		
		JLabel label8 = new JLabel("Mouse");
		frame.getContentPane().setLayout(new GridLayout(4,2));
		frame.getContentPane().add(label1);
		frame.getContentPane().add(label5);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(label6);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(label7);
		frame.getContentPane().add(label4);
		frame.getContentPane().add(label8);
		
		frame.setSize(400,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();


	}

}
