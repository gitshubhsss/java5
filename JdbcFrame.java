package Programmm;
import java.awt.*;
import java.awt.event.*;//1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;



import javax.swing.*;
public class JdbcFrame extends JFrame implements ActionListener//2

{

   JLabel lblno1;
   JTextField txtno1;
   JLabel lblno2;
   JTextField txtno2;
   JLabel lblno3;
   JTextField txtno3;
   JLabel lblno4;
   JTextField txtno4;
   JLabel lblno5;
   JTextField txtno5;

 JButton b,b1,b2,b3;
 Statement stmt;
 Connection cn;
int id,salary,k;
String name,sql,desig,add;
  public JdbcFrame()

{
	  getContentPane().setBackground(Color.pink);
	setSize(1000,1000);
	setTitle("This is our basic AWT example");
	setLayout(null);
	lblno1=new JLabel("ID");
	add(lblno1);

	lblno2=new JLabel("Name");
	add(lblno2);
	
	lblno3=new JLabel("Salary");
	add(lblno3);

	lblno4=new JLabel("Designation");
	add(lblno4);

	lblno5=new JLabel("Address");
	add(lblno5);

	txtno1=new JTextField();
	add(txtno1);

	txtno2=new JTextField();
	add(txtno2);

	txtno3=new JTextField();
	add(txtno3);

	txtno4=new JTextField();
	add(txtno4);

	txtno5=new JTextField();
	add(txtno5);

	b=new JButton("add");
	add(b);

	b1=new JButton("update");
	add(b1);

	b2=new JButton("delete");
	add(b2);

	b3=new JButton("Reset");
	add(b3);

	lblno1.setBounds(100,100,100,20);
	txtno1.setBounds(220,100,100,20);

	lblno2.setBounds(100,150,100,20);
	txtno2.setBounds(220,150,100,20);

	lblno3.setBounds(100,200,100,20);
	txtno3.setBounds(220,200,100,20);

	lblno4.setBounds(100,250,100,20);
	txtno4.setBounds(220,250,100,20);

	lblno5.setBounds(100,300,100,20);
	txtno5.setBounds(220,300,100,20);

	b.setBounds(150,350,80,30);
	b1.setBounds(250,350,80,30);
	b2.setBounds(350,350,80,30);
	b3.setBounds(450,350,80,30);

		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null,"Driver Reg");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3325/office","root","");
			JOptionPane.showMessageDialog(null,"Conn Sucess");
			
		}

		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,""+e1);
			
		}
			b.addActionListener(this);//3
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			setVisible(true);

}
    
	public static void main(String[] args)

	{
		new JdbcFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e3)
	{
		if(b==e3.getSource())//5

			try
			{
				id=Integer.parseInt(txtno1.getText());
				name=txtno2.getText();
				salary=Integer.parseInt(txtno3.getText());
				desig=txtno4.getText();
				add=txtno5.getText();
				sql="Insert into emp values("+id+",'"+name+"',"+salary+",'"+desig+"','"+add+"')";
				stmt=cn.createStatement();
				k=stmt.executeUpdate(sql);
					if(k>0)
				JOptionPane.showMessageDialog(null,"Save Successfully");
					else
				JOptionPane.showMessageDialog(null,"Error");
					stmt.close();
					txtno1.setText("");
					txtno2.setText("");
					txtno3.setText("");
					txtno4.setText("");
					txtno5.setText("");
			}

			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,""+e1);
			}
	


		if(b1==e3.getSource())
		{

			try
			{
				id=Integer.parseInt(txtno1.getText());
				sql="delete from emp where eid="+id+" ";
				stmt=cn.createStatement();
				k=stmt.executeUpdate(sql);

				if(k>0)
				JOptionPane.showMessageDialog(null,"Delete Successfully");
				else
				JOptionPane.showMessageDialog(null,"Error");
					stmt.close();
					txtno1.setText("");
			}

				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,""+e1);
				}
		}

if(b2==e3.getSource())

{
  try
	{
		id=Integer.parseInt(txtno1.getText());
		name=txtno2.getText();
		salary=Integer.parseInt(txtno3.getText());
        sql="update emp name='"+name+"',salary="+salary+",desig='"+desig+"',add='"+add+"' where id="+id;
		stmt=cn.createStatement();
 		k=stmt.executeUpdate(sql);
			if(k>0)
		JOptionPane.showMessageDialog(null,"Updated Successfully");	
	            else
		JOptionPane.showMessageDialog(null,"Error");
			stmt.close();
	}
   catch(Exception e1)
	{
		JOptionPane.showMessageDialog(null,""+e1);
	}

}
}
}

