package Programmm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddtionSwingActionListener extends JFrame implements ActionListener  
{

	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton add;
	AddtionSwingActionListener()
	{
		setLayout(null);
		JLabel l1=new JLabel("first number :");
		add(l1);
		l1.setBounds(100, 100, 110, 30);
		
		JTextField t1=new JTextField();
		add(t1);
		t1.setBounds(210, 100, 180, 30);
		
		JLabel l2=new JLabel("second number:");
		add(l2);
		l2.setBounds(100, 170, 110, 30);
		
		JTextField t2=new JTextField();
		add(t2);
		t2.setBounds(210, 170, 180, 30);
		
		JButton add=new JButton("Add");
		add(add);
		add.setBounds(200,240,100,30 );
		
		JLabel l3=new JLabel("Addition :");
		add(l3);
		l3.setBounds(100, 310, 110, 30);
		
		JTextField t3=new JTextField();
		add(t3);
		t3.setBounds(210, 310, 180, 30);
		
		
		add.addActionListener(this);
		
		setLocation(400,200);
		setSize(500,500);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		AddtionSwingActionListener a1=new AddtionSwingActionListener();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(add==e.getSource())
		{
			int num1=Integer.parseInt(t1.getText());
			int num2=Integer.parseInt(t2.getText());
			int value =num1+num2;
			
			t3.setText(IntegerToString(value));
			
		}
		
	}
	private String IntegerToString(int value) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
