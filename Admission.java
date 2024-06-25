package Programmm;
import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Admission  extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JDateChooser dateChooser;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
	JTextField text1,text2,text3,text5,text6,text7;
	JTextArea text4;
	JButton btn1,btn2,btn3,btn4,btn5;
	JRadioButton rbtn1,rbtn2,rbtn3;
	JComboBox jcombo1,jcombo2,jcombo3,jcombo4;
	 Connection con;
	java.sql.Statement stmt;
	ResultSet res;
	int add_id,stud_id,phone_no,k;
	String address,email,gender,c_name,b_time,f_type,f_mode,sql;
	Date s_date;
	
	DefaultTableModel jtable = new DefaultTableModel();
    JTable tabGrid = new JTable(jtable);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    DefaultTableModel model;
	
	Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
	Font f1=new Font("Times New Roman",Font.BOLD,35);
	Font f2=new Font("Times New Roman",Font.PLAIN,20);
	
	public Admission()
	{
		setLayout(null);
		
		//getContentPane().setBackground(Color.pink);
		label1=new JLabel("Admission Form ");
		add(label1);
		label1.setBounds(350, 20,400, 50);
		label1.setFont(f1);
		
		label2=new JLabel("Admission id:");
		add(label2);
		label2.setBounds(100, 120,120, 30);
		label2.setFont(f2);
		
		label3=new JLabel("Start Date:");
		add(label3);
		label3.setBounds(530, 120,120, 30);
		label3.setFont(f2);
		
		label4=new JLabel("Student id:");
		add(label4);
		label4.setBounds(100, 200,120, 30);
		label4.setFont(f2);
		
		label5=new JLabel("Address :");
		add(label5);
		label5.setBounds(100, 280,120, 30);
		label5.setFont(f2);
		
		label6=new JLabel("phone no:");
		add(label6);
		label6.setBounds(100, 390,150, 30);
		label6.setFont(f2);
		
		label6=new JLabel("Email id:");
		add(label6);
		label6.setBounds(100, 460,150, 30);
		label6.setFont(f2);
		
		label7=new JLabel("Gender:");
		add(label7);
		label7.setBounds(100, 530,150, 30);
		label7.setFont(f2);
		
		label8=new JLabel("Course name :");
		add(label8);
		label8.setBounds(530, 200,150, 30);
		label8.setFont(f2);
		
		label9=new JLabel("Bachtime:");
		add(label9);
		label9.setBounds(530, 300,150, 30);
		label9.setFont(f2);
		

		label10=new JLabel("Fee/type :");
		add(label10);
		label10.setBounds(530, 390,150, 30);
		label10.setFont(f2);
		
		label11=new JLabel("Fee/Mode :");
		add(label11);
		label11.setBounds(530, 490, 150, 30);
		label11.setFont(f2);
		
		text1 =new JTextField();
		add(text1);
		text1.setBounds(270, 120, 150, 30);
		
		text2 =new JTextField();
		add(text2);
		text2.setBounds(270, 200, 150, 30);
		
	/*	text3 =new JTextField();
		add(text3);
		text3.setBounds(660, 120, 150, 30);*/
		
	
		text4 =new JTextArea();
		add(text4);
		text4.setBounds(270, 280, 150, 70);
		
		text5 =new JTextField();
		add(text5);
		text5.setBounds(270, 390, 150, 30);
		
		
		text6 =new JTextField();
		add(text6);
		text6.setBounds(270, 460, 150, 30);
		
		rbtn1=new JRadioButton("Male");
		add(rbtn1);
		rbtn1.setBounds(270, 530, 70, 30);
		
		rbtn2=new JRadioButton("Female");
		add(rbtn2);
		rbtn2.setBounds(350, 530, 70, 30);
		
		rbtn3=new JRadioButton("Other");
		add(rbtn3);
		rbtn3.setBounds(430, 530, 70, 30);
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(rbtn1);
		bg.add(rbtn2);
		bg.add(rbtn3);
		
		jcombo1=new JComboBox();
		add(jcombo1);
		jcombo1.setBounds(660,200,150,30);
		
		String time[]={"7 to 8","8 to 9","9 to 10","10 to 11","11 to 12","12 to 1","1 to 2","2 to 3","3 to 4","4 to 5","5 to 6","6 to 7"};
		jcombo2=new JComboBox(time);
		add(jcombo2);
		jcombo2.setBounds(660,300,150,30);
		
		String type[]= {"One time","installment"};
		jcombo3=new JComboBox(type);
		add(jcombo3);
		jcombo3.setBounds(660,390,150,30);
		
		
		String mode[]= {"Cash","Debit","Credit","Online"};
		jcombo4=new JComboBox(mode);
		add(jcombo4);
		jcombo4.setBounds(660,490,150,30);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(660, 120, 150, 30);
		add(dateChooser);
		
		btn1=new JButton("New");
		add(btn1);
		btn1.setBounds(150,630 ,100, 30);
		
		btn2=new JButton("Save");
		add(btn2);
		btn2.setBounds(310, 630, 100, 30);
		
		btn3=new JButton("Delete");
		add(btn3);
		btn3.setBounds(460, 630, 100, 30);
		
		btn4=new JButton("Display");
		add(btn4);
		btn4.setBounds(600, 630, 100, 30);
		
		btn5=new JButton("Update");
		add(btn5);
		btn5.setBounds(750, 630, 100, 30);
		
		scrlPane.setBounds(35,700,910,300);
	    add(scrlPane);
	    tabGrid.setFont(new Font ("Verdana",0,13));
	    
	    btn1.addActionListener(this);
	    btn2.addActionListener(this);
	    btn3.addActionListener(this);
	    btn4.addActionListener(this);
	    btn5.addActionListener(this);
	    
	    jtable.addColumn("Add id");
	    jtable.addColumn("Stud_id");
	    jtable.addColumn("Address");
	    jtable.addColumn("phone no");
	    jtable.addColumn("Email_id");
	    jtable.addColumn("gender");
	    jtable.addColumn("S_date");
	    jtable.addColumn("C_name");
	    jtable.addColumn("B_TIME");
	    jtable.addColumn("F_TYPE");
	    jtable.addColumn("f_MODE");
	    
	    
		
		 setSize(1000,900);
		 setVisible(true);
		 setLocation(100,0);
		 setTitle("Admission Form ");
		 setDefaultCloseOperation(2);

	
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
		 
		 try
			{
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select co_name from course");
				while(rs.next())
				{
					String name=rs.getString("co_name");
					jcombo1.addItem(name);
				}
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null,""+e3);
			}
	}
	
	public static void main(String[] args)
	{
		Admission a1=new Admission();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(btn1==e.getSource())
		{
			try
			{
				stmt=con.createStatement();
				
				res=stmt.executeQuery("select add_id from admission");
				int i=1;
				
				while(res.next())
				{
					i=Integer.parseInt(res.getString("add_id"));
				}
				i++;
				text1.setText(""+i);
				text2.setText("");
				//text3.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
			}
			catch(Exception e4)
			{
				JOptionPane.showMessageDialog(null,""+e4);
			}
		}
		if(btn2==e.getSource())
		{
			try
			{
				add_id=Integer.parseInt(text1.getText());
				stud_id=Integer.parseInt(text2.getText());
				address=text4.getText();
				phone_no=Integer.parseInt(text5.getText());
				email=text6.getText();
				String gender1;
				if(rbtn1.isSelected())
				{
					gender1="Male";
				}
				else if(rbtn2.isSelected())
				{
					gender1="Female";
				}
				else if(rbtn3.isSelected())
				{
					gender1="other";
				}
				else
				{
					gender1="null";
				}
				
				gender=gender1;
				//gender=text2.getText();
				s_date=dateChooser.getDate();
				c_name=jcombo1.getSelectedItem().toString();
				//email=text6.getText();
				b_time=jcombo2.getSelectedItem().toString();
				f_type=jcombo3.getSelectedItem().toString();
				f_mode=jcombo4.getSelectedItem().toString();
				sql="insert into admission values("+add_id+",'"+stud_id+"','"+address+"',"+phone_no+",'"+email+"','"+gender+"','"+s_date+"','"+c_name+"','"+b_time+"','"+f_type+"','"+f_mode+"')";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"save successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Error");
				}
				stmt.close();
				text1.setText("");
				text2.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,""+e1);
			}	
		}
		
		if(btn3==e.getSource())
		{
			try
			{
				add_id=Integer.parseInt(text1.getText());
				sql="delete from admission where add_id="+add_id+" ";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"Delete successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Error");
				}
				stmt.close();
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null,""+e2);
			}
		}
		if(btn4==e.getSource())
		{
			int r=0;
			Statement stmt;
			jtable.setRowCount(0);
			try 
			{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
            ResultSet rs = stmt.executeQuery("SELECT * from admission" );			
            while(rs.next())
            {
            	jtable.insertRow(r++, new Object[]{rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
            }
            
			} 
			catch (SQLException e5) 
			{				
				e5.printStackTrace();
			}
		}
		if(btn5==e.getSource())
		{
			try
			{
				/*co_id=Integer.parseInt(text1.getText());
				co_name=text2.getText();
				co_duration=text3.getText();
				co_fee1=Integer.parseInt(text4.getText());
				co_fee=Integer.parseInt(text5.getText());*/
				
				add_id=Integer.parseInt(text1.getText());
				stud_id=Integer.parseInt(text2.getText());
				address=text4.getText();
				phone_no=Integer.parseInt(text5.getText());
				email=text6.getText();
				String gender1;
				if(rbtn1.isSelected())
				{
					gender1="Male";
				}
				else if(rbtn2.isSelected())
				{
					gender1="Female";
				}
				else if(rbtn3.isSelected())
				{
					gender1="other";
				}
				else
				{
					gender1="null";
				}
				
				gender=gender1;
				//gender=text2.getText();
				s_date=dateChooser.getDate();
				c_name=jcombo1.getSelectedItem().toString();
				//email=text6.getText();
				b_time=jcombo2.getSelectedItem().toString();
				f_type=jcombo3.getSelectedItem().toString();
				f_mode=jcombo4.getSelectedItem().toString();
				
				sql="Update admission set stud_id="+stud_id+",address='"+address+"',phone_no="+phone_no+",email='"+email+"',gender='"+gender+"',s_date='"+s_date+"',c_name='"+c_name+"',b_time='"+b_time+"',f_type='"+f_type+"',f_mode='"+f_mode+"' where add_id="+add_id+"";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null,"update successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Error");
				}
				stmt.close();
				text1.setText("");
				text2.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null,""+e3);
			}
			
		}
	}
}