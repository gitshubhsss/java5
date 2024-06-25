package Programmm;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JdbcData extends JFrame implements ActionListener 
{
	
	int eid,k;
	String ename,address,degi,sql;
	float sallary;
	Statement stmt;
	Connection con;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JTextArea jt1;
	JButton b1,b2,b3,b4;
	Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
	Font f1=new Font("Arial",Font.BOLD,15);
	public JdbcData()
	{
getContentPane().setBackground(Color.pink);
		

		
		JLabel l1=new JLabel("Employee id :");
		add(l1);
		l1.setBounds(100, 100, 110, 30);
		l1.setFont(f1);
		
		JTextField t1=new JTextField();
		add(t1);
		t1.setBounds(210, 100, 180, 30);
		
		JLabel l2=new JLabel("Name :");
		add(l2);
		l2.setBounds(100, 170, 110, 30);
		l2.setFont(f1);
		
		JTextField t2=new JTextField();
		add(t2);
		t2.setBounds(210, 170, 180, 30);
		
		JLabel l3=new JLabel("Address :");
		add(l3);
		l3.setBounds(100, 240, 110, 30);
		l3.setFont(f1);
		
		JTextArea jt1=new JTextArea();
		add(jt1);
		jt1.setBounds(210, 240, 180, 90);
		
		
		JLabel l4=new JLabel("Designation:");
		add(l4);
		l4.setBounds(100, 355, 110, 30);
		l4.setFont(f1);
		
		JTextField t4=new JTextField();
		add(t4);
		t4.setBounds(210, 355, 180, 30);
		
		JLabel l5=new JLabel("Sallary :");
		add(l5);
		l5.setBounds(100, 420, 110, 30);
		l5.setFont(f1);
		
		JTextField t5=new JTextField();
		add(t5);
		t5.setBounds(210, 420, 180, 30);
		
		JButton b1=new JButton("Save");
		add(b1);
		b1.setForeground(Color.green);
		b1.setBackground(Color.black);
		b1.setFont(f1);
		b1.setBounds(120, 500, 100, 30);
		
		JButton b2=new JButton("Update");
		add(b2);
		b2.setForeground(Color.orange);
		b2.setBackground(Color.black);
		b2.setFont(f1);
		b2.setBounds(250, 500, 100, 30);
		
		JButton b3=new JButton("Delete");
		add(b3);
		b3.setForeground(Color.red);
		b3.setBackground(Color.black);
		b3.setFont(f1);
		b3.setBounds(380, 500, 100, 30);
		
		JButton b4=new JButton("Reset");
		add(b4);
		b4.setForeground(Color.YELLOW);
		b4.setBackground(Color.black);
		b4.setFont(f1);
		b4.setBounds(520, 500, 100, 30);
		
		setLayout(null);
		setSize(800,800);
		setLocation(80,70);
		
		try
		{
			
			
		}
		catch(Exception e)
		{
			
		}
	}

	public static void main(String[] args)
	{
		
				
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		
	}

}
