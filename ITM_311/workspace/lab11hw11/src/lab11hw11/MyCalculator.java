// This program will take the the input of two numbers, and will do the
// following calculations: add, subtract, multiply, and divide them. Then
// it will display the results.
// Written by Deborah Barndt

package lab11hw11;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyCalculator extends JFrame implements ActionListener
{
	JButton addBtn,		// add button in the dialog box
			subBtn,		// subtract button in the dialog box
			multBtn,	// multiply button in the dialog box
			divBtn;		// divide button in the dialog box
			
	public MyCalculator() 
	{
		super("My Personal Calculator");
		
		// Create layout Container
		Container calc = getContentPane();
		calc.setBackground(Color.cyan);
				
		// Set FlowLayout with horizontal gap 5 and vertical gap 5
		calc.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		// Set boundaries on frame
		setBounds(0, 0, 450, 110);
		
		// Change font in frame
		Font bigFont = new Font("Times New Roman", Font.BOLD, 14);
		
		// Create labels and text fields to frame
		JLabel label1 = new JLabel("Number 1:");
		JTextField num1Field = new JTextField(5);
		JLabel label2 = new JLabel("Number 2:");
		JTextField num2Field = new JTextField(5);
		JLabel resultlabel = new JLabel("Result:");
		JTextField resultField = new JTextField(8);
		
		// Add labels and text fields to frame
		calc.add(label1);
		calc.add(num1Field);
		calc.add(label2);
		calc.add(num2Field);
		calc.add(resultlabel);
		calc.add(resultField);
		
		// Add font to the frame
		label1.setFont(bigFont);
		label2.setFont(bigFont);
		resultlabel.setFont(bigFont);
		
		// Add buttons to the GUI layout
		JButton addBtn = new JButton("Add");
		JButton	subBtn = new JButton("Subtract");
		JButton	multBtn = new JButton("Multiply");
		JButton	divBtn = new JButton("Divide");
		
		// Add buttons to the frame and actions
		calc.add(addBtn);
		addBtn.addActionListener(this);
		calc.add(subBtn);
		subBtn.addActionListener(this);
		calc.add(multBtn);
		multBtn.addActionListener(this);
		calc.add(divBtn);
		divBtn.addActionListener(this);
		
		//@Override
		addBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				float num1,		// number 1 input entered
				  	  num2,		// number 2 input entered
				      result;	// result of the input entered
			
				// Parse the text to a type float
				num1 = Float.parseFloat(num1Field.getText());
				num2 = Float.parseFloat(num2Field.getText());
			
				// Perform the addition
				result = num1 + num2;
			
				// Pass the value to the result field
				resultField.setText(String.valueOf(result));
			}
		});
		
		subBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				float num1,		// number 1 input entered
				  	  num2,		// number 2 input entered
				      result;	// result of the input entered
			
				// Parse the text to a type float
				num1 = Float.parseFloat(num1Field.getText());
				num2 = Float.parseFloat(num2Field.getText());
			
				// Perform the addition
				result = num1 - num2;
			
				// Pass the value to the result field
				resultField.setText(String.valueOf(result));
			}
		});
		
		multBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				float num1,		// number 1 input entered
				  	  num2,		// number 2 input entered
				      result;	// result of the input entered
			
				// Parse the text to a type float
				num1 = Float.parseFloat(num1Field.getText());
				num2 = Float.parseFloat(num2Field.getText());
			
				// Perform the addition
				result = num1 * num2;
			
				// Pass the value to the result field
				resultField.setText(String.valueOf(result));
			}
		});
		
		divBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				float num1,		// number 1 input entered
				  	  num2,		// number 2 input entered
				      result;	// result of the input entered
			
				// Parse the text to a type float
				num1 = Float.parseFloat(num1Field.getText());
				num2 = Float.parseFloat(num2Field.getText());
			
				// Perform the addition
				result = num1 / num2;
			
				// Pass the value to the result field
				resultField.setText(String.valueOf(result));
			}
		});
	}
	
	public static void main(String[] args) throws Exception
	{
		// Constructor for frame objects
		JFrame myframe = new MyCalculator();
		
		// Change image icon in the JFrame
		ImageIcon icon = new ImageIcon("c://users/u2/pictures/calculator.png");
		myframe.setIconImage(icon.getImage());		
		
		// Set frame parameters
		myframe.setLocationRelativeTo(null);
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}

