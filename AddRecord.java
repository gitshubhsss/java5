package Programmm;
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
public class AddRecord extends JFrame implements ActionListener    
{
	
	
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField text1,text2,text3,text4,text5;
	JButton btn1,btn2,btn3,btn4,btn5;
	//tabel creation 
	DefaultTableModel jtable = new DefaultTableModel();
    JTable tabGrid = new JTable(jtable);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    DefaultTableModel model;
    Connection con=null;
    
     
    int co_id,co_fee1,co_fee,k;
    String co_name,co_duration;
    String sql;
    Statement stmt;
    
    ResultSet rs;
    
    Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
	Font f1=new Font("Times New Roman",Font.BOLD,35);
	Font f2=new Font("Times New Roman",Font.PLAIN,20);
	public AddRecord()
	{
	setLayout(null);
	setSize(800,800);
	setVisible(true);
	setTitle("COURSE RECORD");
	setLocation(100,10);
	getContentPane().setBackground(Color.pink);
	label1=new JLabel("ADD RECORD");
	add(label1);
	label1.setBounds(280, 20,400, 50);
	label1.setFont(f1);
	
	label2=new JLabel("Cource id:");
	add(label2);
	label2.setBounds(100, 120,100, 30);
	label2.setFont(f2);
	
	
	label3=new JLabel("Cource Name:");
	add(label3);
	label3.setBounds(100, 180,120, 30);
	label3.setFont(f2);
	
	label4=new JLabel("Cource Period:");
	add(label4);
	label4.setBounds(100, 240,120, 30);
	label4.setFont(f2);
	
	label5=new JLabel("Onetime Fees:");
	add(label5);
	label5.setBounds(100, 300,120, 30);
	label5.setFont(f2);
	
	label6=new JLabel("Installment Fees :");
	add(label6);
	label6.setBounds(100, 360,150, 30);
	label6.setFont(f2);
	
	text1 =new JTextField();
	add(text1);
	text1.setBounds(270, 120, 150, 30);
	
	text2 =new JTextField();
	add(text2);
	text2.setBounds(270, 180, 150, 30);
	
	text3 =new JTextField();
	add(text3);
	text3.setBounds(270, 240, 150, 30);
	
	text4 =new JTextField();
	add(text4);
	text4.setBounds(270, 300, 150, 30);
	
	text5=new JTextField();
	add(text5);
	text5.setBounds(270, 360, 150, 30);
	
	btn1=new JButton("New");
	add(btn1);
	btn1.setBounds(80, 430, 70, 30);
	
	btn2=new JButton("Save");
	add(btn2);
	btn2.setBounds(200, 430, 70, 30);
	
	btn3=new JButton("Delete");
	add(btn3);
	btn3.setBounds(320, 430, 80, 	30);
	
	btn4=new JButton("Display");
	add(btn4);
	btn4.setBounds(440, 430, 80, 30);
	
	btn5=new JButton("Update");
	add(btn5);
	btn5.setBounds(560, 430, 80, 30);
	
	scrlPane.setBounds(50,500,500,200);
    add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));
    
    jtable.addColumn("C_ID");
    jtable.addColumn("C_NAME");
    jtable.addColumn("C_PERIOD");
    jtable.addColumn("O_FEE");
    jtable.addColumn("I_FEE");
    
    
    
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    btn3.addActionListener(this);
    btn4.addActionListener(this);
    btn5.addActionListener(this);
    
    
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		JOptionPane.showMessageDialog(null, "Driver register succesfully");
		System.out.println("connection succesfullu");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3325/institute","root","");
		JOptionPane.showMessageDialog(null,"Connection succefully");
		//System.out.println("Conection successfull");
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,""+e);
	}
	
	}

	public static void main(String[] args)
	{
		
		AddRecord a=new AddRecord();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(btn1==e.getSource()) 
		{
			try
			{
				stmt=con.createStatement();
				
				rs=stmt.executeQuery("select co_id from course");
				int i=1;
				
				while(rs.next())
				{
					i=Integer.parseInt(rs.getString("co_id"));
				}
				i++;
				text1.setText(""+i);
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				
			}
			catch(Exception e4)
			{
				
				JOptionPane.showMessageDialog(null, e4);
			}
		}
		
		
		
		
		
		if(btn2==e.getSource())
		{
			try
			{
				
				co_id=Integer.parseInt(text1.getText());
				co_name=text2.getText();
				co_duration=text3.getText();
				co_fee1=Integer.parseInt(text4.getText());
				co_fee=Integer.parseInt(text5.getText());
				sql= "Insert into course values("+co_id+",'"+co_name+"','"+co_duration+"',"+co_fee1+","+co_fee+")";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "Save  successfully");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Error found");	
				}
				stmt.close();
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				
				
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		}
		
		if(btn3==e.getSource())
		{
			try
			{
				co_id=Integer.parseInt(text1.getText());
				sql="Delete from course where co_id="+co_id+"";
				stmt=con.createStatement();
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "Delete  successfully");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Error found");	
				}
				stmt.close();
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
			}
		}
		//display all 
		if(btn4==e.getSource())
		{
			int r=0;
			Statement stmt;
			jtable.setRowCount(0);
			try 
			{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
            ResultSet rs = stmt.executeQuery("SELECT * from course" );			
            while(rs.next())
            {
            	jtable.insertRow(r++, new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)});
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
				co_id=Integer.parseInt(text1.getText());
				co_name=text2.getText();
				co_duration=text3.getText();
				co_fee1=Integer.parseInt(text4.getText());
				co_fee=Integer.parseInt(text5.getText());
				
				sql="Update course set co_name='"+co_name+"',co_duration='"+co_duration+"',co_fee1="+co_fee1+",co_fee="+co_fee+" where co_id="+co_id+"";
				stmt=con.createStatement();
				k=stmt.executeUpdate(sql);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "Update   successfully");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Error found");	
				}
				
				stmt.close();
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null, e3);
			}
		}
		
	}
	public void mouseClicked(MouseEvent e)
	 {                                     
   	   
	 }
	public void mousePressed(MouseEvent e)
	{
		 DefaultTableModel jtable = (DefaultTableModel) tabGrid.getModel(); //create a model
    	    int selectedRowIndex = tabGrid.getSelectedRow(); //get selected row
    	    int co_id = (Integer) jtable.getValueAt(selectedRowIndex, 0); //get the primary key to fetch data.
    	    try {
    	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
                
    	        ResultSet rs = stmt.executeQuery("SELECT * from course where co_id="+co_id+"" );
    	        while(rs.next()){    //u can use normal query
    	        	text1.setText(""+rs.getInt(1));  //these are my textfields
    	        	text2.setText(rs.getString(2));
    	        	text3.setText(""+rs.getString(3));
    	        	text4.setText(""+rs.getInt(4));
    	        	text5.setText(""+rs.getInt(5));
    	            
    	        }
    	    } 
    	    catch (Exception ex) 
    	    {
    	    	
    	    	System.out.println(ex);
    	          
            }
		
	}

}