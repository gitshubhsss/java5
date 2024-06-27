package Programmm;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;   
import java.sql.ResultSet;
import java.sql.SQLException;   
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Login extends JFrame implements ActionListener    
{
	JLabel label1,label2,label3,label4;
	JTextField text1;
	JPasswordField text2;
	JButton btn1,btn2;
	Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
	Font f1=new Font("Times New Roman",Font.BOLD,30);
	Font f2=new Font("Times New Roman",Font.PLAIN,20);
	Connection con;
	Statement stmt;
	String sql;
	String user_name;
	String pass;
	Login()
	{
		setLayout(null);
		setSize(700,700);
		setVisible(true);
		setTitle("Admission Form");
		setLocation(100,10);
		
		label1=new JLabel("ADDMISION FORM ");
		add(label1);
		label1.setBounds(200, 20,400, 50);
		label1.setFont(f1);
		
		
		label2=new JLabel("Username :");
		add(label2);
		label2.setBounds(100, 120,100, 30);
		label2.setFont(f2);
		
		
		label3=new JLabel("Passward:");
		add(label3);
		label3.setBounds(100, 180,120, 30);
		label3.setFont(f2);
		
		text1 =new JTextField();
		add(text1);
		text1.setBounds(250, 120, 150, 30);
		
		text2 =new JPasswordField();
		add(text2);
		text2.setBounds(250, 180, 150, 30);
		
		btn1=new JButton("Login");
		add(btn1);
		btn1.setBounds(220, 250, 70, 30);
		
		btn2=new JButton("Cancel");
		add(btn2);
		btn2.setBounds(360, 250, 80, 30);
		
		btn1.addActionListener(this);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null, "Driver register succesfully");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3325/institute","root","");
			JOptionPane.showMessageDialog(null,"Connection succefully");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
		
		
		
		
	}
	
	public static void main(String[] args) 
	{
		Login l1=new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String user_name = text1.getText();        //get user entered username from the textField1  
        String pass = text2.getText(); 
        if (user_name.equals("SHUBHAM") && pass.equals("RANJANE"))
        {
        	JOptionPane.showMessageDialog(null,"LOGIN SUCCESFULLY");
        	
        }
        else
        {
        	JOptionPane.showMessageDialog(null,"PLEASE TRY LATER");
        }
        if(btn1==e.getSource())
        {
        	try
        	{
        		user_name=text1.getText();
        		pass=text2.getText();
        		
        		
        		
        	}
        	catch(Exception e3)
        	{
        		
        	}
        
        }
        
		
		
	}

}
