package Programmm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class BatchRecord extends JFrame implements ActionListener
{
	
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField text1,text2,text3,text4,text5;
	JButton btn1,btn2,btn3,btn4,btn5,btn6;
	JComboBox jcombo1,jcombo2,jcombo3;
	//tabel creation 
	DefaultTableModel jtable = new DefaultTableModel();
    JTable tabGrid = new JTable(jtable);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    
    Connection con;
    int k;
    Statement stmt,stmt1;
    String sql;
    
    int b_id,co_id;
    String co_name,s_date,time,t_name;
    
    
    Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
	Font f1=new Font("Times New Roman",Font.BOLD,35);
	Font f2=new Font("Times New Roman",Font.PLAIN,20);
	public BatchRecord() throws SQLException
	{
	setLayout(null);
	setSize(800,800);
	setVisible(true);
	setTitle("COURSE RECORD");
	setLocation(100,10);
	getContentPane().setBackground(Color.pink);
	label1=new JLabel("STANDARD RECORD");
	add(label1);
	label1.setBounds(230, 30,400, 50);
	label1.setFont(f1);
	
	label2=new JLabel("Batch id:");
	add(label2);
	label2.setBounds(100, 120,100, 30);
	label2.setFont(f2);
	
	
	label3=new JLabel("Start Date:");
	add(label3);
	label3.setBounds(100, 180,120, 30);
	label3.setFont(f2);
	
	label4=new JLabel("Course:");
	add(label4);
	label4.setBounds(350, 120,120, 30);
	label4.setFont(f2);
	
	label5=new JLabel("Batch Time:");
	add(label5);
	label5.setBounds(350, 180,120, 30);
	label5.setFont(f2);
	
	label5=new JLabel("Traner Name:");
	add(label5);
	label5.setBounds(100, 240,120, 30);
	label5.setFont(f2);
	
	text1 =new JTextField();
	add(text1);
	text1.setBounds(200, 120, 100, 30);
	
	text2 =new JTextField();
	add(text2);
	text2.setBounds(200, 180, 100, 30);
	
	
	btn1=new JButton("New");
	add(btn1);
	btn1.setBounds(100,325 , 100, 30);
	
	btn2=new JButton("Save");
	add(btn2);
	btn2.setBounds(280, 325, 100, 30);
	
	btn3=new JButton("Update");
	add(btn3);
	btn3.setBounds(460, 325, 100, 30);
	
	btn4=new JButton("Display");
	add(btn4);
	btn4.setBounds(200, 385, 100, 30);
	
	btn5=new JButton("Delete");
	add(btn5);
	btn5.setBounds(380, 385, 100, 30);
	
	
	
	jcombo1=new JComboBox();
	add(jcombo1);
	jcombo1.setBounds(480,120,120,30);
	
	String time[] = {"7 to 8" ," 8 to 9","9 to 10 ","10 to 11","11 to 12","12 to 1","1 to 2","4 to 5","5 to 6","6 to 7"};
	jcombo2=new JComboBox(time);
	add(jcombo2);
	jcombo2.setBounds(480,180,120,30);
	
	
	jcombo3=new JComboBox();
	add(jcombo3);
	jcombo3.setBounds(240,240,120,30);
	
	//table setBounds
	scrlPane.setBounds(50,480,630,200);
    add(scrlPane);
    tabGrid.setFont(new Font ("Verdana",0,13));
    
    jtable.addColumn("B_ID");
    jtable.addColumn("C_NAME");
    jtable.addColumn("S_DATE");
    jtable.addColumn("B_TIME");
    jtable.addColumn("T_NAME");
    
    jcombo1.addActionListener(this);
    jcombo2.addActionListener(this);
    jcombo3.addActionListener(this);
    
    btn1.addActionListener(this);
    btn2.addActionListener(this);
    
    btn3.addActionListener(this);
    btn4.addActionListener(this);
    btn5.addActionListener(this);
    
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
	//get the course name from the course table 
	
   // String sql;
    //sql="select *from course";
    try
    {
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("Select co_name from course");
        while(rs.next())
        {
        	String name=rs.getString("co_name");
        	jcombo1.addItem(name);
        }
       // con.close();
        
    }
   
    catch(Exception e7)
    {
    	JOptionPane.showMessageDialog(null,""+e7);
    	
    }
   //get a data from the trainer tabel 
    //String   sql1="select *from trainer";
    try
    {
        Statement stmt1=con.createStatement();
        ResultSet rs=stmt1.executeQuery("Select t_name from trainer");
        while(rs.next())
        {
        	String name=rs.getString("t_name");
        	jcombo3.addItem(name);
        }
       // con.close();
        
    }
    catch(Exception e8)
    {
    	JOptionPane.showMessageDialog(null,""+e8);
    }
	
	}

	public static void main(String[] args) throws SQLException
	{
		
		BatchRecord a=new BatchRecord();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(btn1==e.getSource())
		{
			try
			{
				stmt=con.createStatement();
				
			ResultSet rs=stmt.executeQuery("select b_id from batch");
				int i=0;
				
				while(rs.next())
				{
					i=Integer.parseInt(rs.getString("b_id"));
				}
				i++;
				text1.setText(""+i);
				text2.setText("");
				
				//con.close();
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
				b_id=Integer.parseInt(text1.getText());
				co_name=jcombo1.getSelectedItem().toString();
				s_date=text2.getText();
				time=jcombo2.getSelectedItem().toString();
				t_name=jcombo3.getSelectedItem().toString();
				sql= "Insert into batch values("+b_id+",'"+co_name+"','"+s_date+"','"+time+"','"+t_name+"')";
				stmt=con.createStatement();
				int k=stmt.executeUpdate(sql);
				if(k>0)
				{
				JOptionPane.showMessageDialog(null, "Save successfully");
				}
				else
				{
				JOptionPane.showMessageDialog(null,"Check cid");
				}
				text1.setText("");
				jcombo1.setToolTipText("");
				text2.setText("");
				
			}
			catch(Exception e5)
			{
				JOptionPane.showMessageDialog(null, e5);
			}
		}
		if(btn3==e.getSource())
		{
			try
			{

				b_id=Integer.parseInt(text1.getText());
				co_name=jcombo1.getSelectedItem().toString();
				s_date=text2.getText();
				time=jcombo2.getSelectedItem().toString();
				t_name=jcombo3.getSelectedItem().toString();
				sql="Update batch set co_name='"+co_name+"',s_date='"+s_date+"',time='"+time+"',t_name='"+t_name+" 'where b_id="+b_id+"";
				stmt=con.createStatement();
				int k=stmt.executeUpdate(sql);
				if(k>0)
				{
				JOptionPane.showMessageDialog(null, "Update  successfully");
				}
				else
				{
				JOptionPane.showMessageDialog(null,"Check cid");
				}
				text1.setText("");
				jcombo1.setToolTipText("");
				text2.setText("");
			}
			catch(Exception e6)
			{
				JOptionPane.showMessageDialog(null, e6);
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
            ResultSet rs = stmt.executeQuery("SELECT * from batch" );			
            while(rs.next())
            {
            	jtable.insertRow(r++, new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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
				b_id=Integer.parseInt(text1.getText());
				sql="delete from batch where b_id="+b_id+" ";
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
		
		
	}

}