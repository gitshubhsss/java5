package Programmm;
import java.awt.*; 
import java.awt.event.*;//1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
public class JdbcSwingEx  extends JFrame implements ActionListener
{

	int eid,k;
	String ename,address,degi,sql;
	float salary;
	Statement stmt;
	Connection con;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JTextArea jt1;
	JButton b1,b2,b4,b5;
	Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
	Font f1=new Font("Arial",Font.BOLD,15);
	
	public JdbcSwingEx ()
	{
		getContentPane().setBackground(Color.pink);
		l1=new JLabel("Employee id :");
		add(l1);
		l1.setBounds(100, 100, 110, 30);
		l1.setFont(f1);
		
		t1=new JTextField();
		add(t1);
		t1.setBounds(210, 100, 180, 30);
		
		l2=new JLabel("Name :");
		add(l2);
		l2.setBounds(100, 170, 110, 30);
		l2.setFont(f1);
		
		t2=new JTextField();
		add(t2);
		t2.setBounds(210, 170, 180, 30);
		
		l3=new JLabel("Address :");
		add(l3);
		l3.setBounds(100, 240, 110, 30);
		l3.setFont(f1);
		
		jt1=new JTextArea();
		add(jt1);
		jt1.setBounds(210, 240, 180, 90);
		
		
		l4=new JLabel("Designation:");
		add(l4);
		l4.setBounds(100, 355, 110, 30);
		l4.setFont(f1);
		
		t4=new JTextField();
		add(t4);
		t4.setBounds(210, 355, 180, 30);
		
		l5=new JLabel("Salary :");
		add(l5);
		l5.setBounds(100, 420, 110, 30);
		l5.setFont(f1);
		
		t5=new JTextField();
		add(t5);
		t5.setBounds(210, 420, 180, 30);
		
		b1=new JButton("Save");
		add(b1);
		b1.setForeground(Color.green);
		b1.setBackground(Color.black);
		b1.setFont(f1);
		b1.setBounds(120, 500, 100, 30);
		
		b2=new JButton("Update");
		add(b2);
		b2.setForeground(Color.orange);
		b2.setBackground(Color.black);
		b2.setFont(f1);
		b2.setBounds(250, 500, 100, 30);
		
		b4=new JButton("Delete");
		add(b4);
		b4.setForeground(Color.red);
		b4.setBackground(Color.black);
		b4.setFont(f1);
		b4.setBounds(380, 500, 100, 30);
		
		b5=new JButton("Reset");
		add(b5);
		b5.setForeground(Color.YELLOW);
		b5.setBackground(Color.black);
		b5.setFont(f1);
		b5.setBounds(520, 500, 100, 30);
		
		setLayout(null);
		setSize(800,800);
		setLocation(80,70);
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null, "Driver register succesfully");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3325/employee","root","");
			JOptionPane.showMessageDialog(null,"Connection succefully");
			
		}
		catch (Exception e1)
		{
			JOptionPane.showMessageDialog(null, ""+e1);
		}
		b1.addActionListener(this);
		b2.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		setVisible(true);
		
		
		
	}
	public static void main(String[] args)
	{
		new JdbcSwingEx();

	}

	@Override
	public void actionPerformed(ActionEvent e3) 
	{
		if(b1==e3.getSource())
		
			try
			{
				eid=Integer.parseInt(t1.getText());
				ename=t2.getText();
				address=jt1.getText();
				degi=t4.getText();
				salary=Float.parseFloat(t5.getText());
				sql="Insert into emp values("+eid+",'"+ename+"','"+address+"','"+degi+"',"+salary+")";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
					JOptionPane.showMessageDialog(null, "save successfully");
				else
					JOptionPane.showMessageDialog(null, "Error");
					stmt.close();
					t1.setText("");
					t2.setText("");
					jt1.setText("");
					t4.setText("");
					t5.setText("");
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, ""+e1);
			}
			if(b2==e3.getSource())
			{
				try
				{
					//System.out.println("Enter the eid,ename,address,desg,salary");
					eid=Integer.parseInt(t1.getText());
					ename=t2.getText();
					address=jt1.getText();
					degi=t4.getText();
					salary=Float.parseFloat(t5.getText());
					
					sql="update emp set ename='"+ename+"',address='"+address+"',degi='"+degi+"',salary='"+salary+"' where eid="+eid+" ";
					stmt=con.createStatement();
					k=stmt.executeUpdate(sql);
					if(k>0)
						JOptionPane.showMessageDialog(null, "upadate successfully");
					else
					
						JOptionPane.showMessageDialog(null, "Error");
						stmt.close();
						//t1.setText("");//Eid
					//	t2.setText("");//Ename
					//	jt1.setText("");//adderess
						//t4.setText("");//designation
					//	t5.setText("");//sallary
						
					}
					
					
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, ""+e1);
				}
			}
			if(b4==e3.getSource());
			{
				try
				{
					//System.out.println("Enter the eid,ename,address,desg,salary");
					eid=Integer.parseInt(t1.getText());
					sql="delete from emp where eid="+eid+"";
					stmt=con.createStatement();
					k=stmt.executeUpdate(sql);
					if(k>0)
					
						JOptionPane.showMessageDialog(null, "delete successfully");
					
					else
					
						JOptionPane.showMessageDialog(null, "Error");
						stmt.close();
					/*	t1.setText("");
						t2.setText("");
						
						t4.setText("");
						t5.setText("");
						jt1.setText("");*/
					
					
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, ""+e1);
				}
			}
			if(b5==e3.getSource())
			{
				try
				{
					System.out.println("Enter Employee id");
					eid=Integer.parseInt(t1.getText());
					sql="Select * from emp where eid="+eid+"";
					stmt=con.createStatement();
					ResultSet res=stmt.executeQuery(sql);
					while(res.next())
					{
					t1.setText(Integer.toString(res.getInt("eid")));
					t2.setText(res.getString("ename"));
					jt1.setText(res.getString("address"));
					t4.setText(res.getString("degi"));
					t5.setText(Float.toString(res.getFloat("salary")));
					}
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, ""+e1);
				}
			}
		}
}