package Programmm;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;                 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TrainerRecord extends JFrame implements ActionListener
{
	JLabel label1,label2,label3,label4,label5,label6,label7;
	JTextField text1,text2,text3,text4,text5,text6;
	JButton btn1,btn2,btn3,btn4,btn5;
	JRadioButton rbtn1,rbtn2,rbtn3;
	//tabel creation 
	DefaultTableModel jtable = new DefaultTableModel();
    JTable tabGrid = new JTable(jtable);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    int k;
   ;
    Statement stmt;
    ResultSet rs;
    
    Connection con;
    
    int t_id,t_phno;
    String t_name,t_add,Email_id,t_gender;
    String sql;
	public TrainerRecord()
	{
		
	    
	    Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
		Font f1=new Font("Times New Roman",Font.BOLD,35);
		Font f2=new Font("Times New Roman",Font.PLAIN,20);
	
		setLayout(null);
		setSize(800,800);
		setVisible(true);
		setTitle("COURSE RECORD");
		setLocation(100,10);
		
		label1=new JLabel("TRAINER RECORD");
		add(label1);
		label1.setBounds(270, 20,400, 50);
		label1.setFont(f1);
		
		label2=new JLabel("Trainer id:");
		add(label2);
		label2.setBounds(100, 120,100, 30);
		label2.setFont(f2);
		
		
		label3=new JLabel("Trainer Name:");
		add(label3);
		label3.setBounds(100, 180,120, 30);
		label3.setFont(f2);
		
		label4=new JLabel("Address:");
		add(label4);
		label4.setBounds(100, 240,120, 30);
		label4.setFont(f2);
		
		label5=new JLabel("Email Id:");
		add(label5);
		label5.setBounds(100, 300,120, 30);
		label5.setFont(f2);
		
		label6=new JLabel("Mobile No:");
		add(label6);
		label6.setBounds(100, 360,150, 30);
		label6.setFont(f2);
		
		label7=new JLabel("Gender:");
		add(label7);
		label7.setBounds(100, 420,150, 30);
		label7.setFont(f2);
		
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
		
		//text6=new JTextField();
		//add(text6);
		//text6.setBounds(270, 420, 150, 30);
		
		rbtn1=new JRadioButton("Male");
		add(rbtn1);
		rbtn1.setBounds(270, 420, 70, 30);
		
		rbtn2=new JRadioButton("Female");
		add(rbtn2);
		rbtn2.setBounds(350, 420, 70, 30);
		
		rbtn3=new JRadioButton("Other");
		add(rbtn3);
		rbtn3.setBounds(420, 420, 70, 30);
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(rbtn1);
		bg.add(rbtn2);
		bg.add(rbtn3);
		
		btn1=new JButton("New");
		add(btn1);
		btn1.setBounds(80, 480, 70, 30);
		
		btn2=new JButton("Save");
		add(btn2);
		btn2.setBounds(200, 480, 70, 30);
		
		btn3=new JButton("Delete");
		add(btn3);
		btn3.setBounds(320, 480, 80, 	30);
		
		btn4=new JButton("Display");
		add(btn4);
		btn4.setBounds(440, 480, 80, 30);
		
		btn5=new JButton("Update");
		add(btn5);
		btn5.setBounds(560, 480, 80, 30);
		
		scrlPane.setBounds(50,550,645,200);
	    add(scrlPane);
	    tabGrid.setFont(new Font ("Verdana",0,13));
	    
	    jtable.addColumn("T_ID");
	    jtable.addColumn("T_NAME");
	    jtable.addColumn("ADDRESS");
	    jtable.addColumn("E_ID");
	    jtable.addColumn("M_NO");
	    jtable.addColumn("GENDER");
	    
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
	}
	public static void main(String[] args)
	{
		new TrainerRecord();
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(btn1==e.getSource())
		{
			try
			{
				stmt=con.createStatement();
				
				rs=stmt.executeQuery("select t_id from trainer");
				int i=0;
				
				while(rs.next())
				{
					i=Integer.parseInt(rs.getString("t_id"));
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
				
				t_id=Integer.parseInt(text1.getText());
				t_name=text2.getText();
				t_add=text3.getText();
				Email_id=text4.getText();
				t_phno=Integer.parseInt(text5.getText());
				String gender;
				if(rbtn1.isSelected())
				{
					gender="Male";
				}
				else if(rbtn2.isSelected())
				{
					gender="Female";
				}
				else if(rbtn3.isSelected())
				{
					gender="Other";
				}
				else
				{
					gender="null";
				}
				t_gender=gender;
				sql= "Insert into trainer values("+t_id+",'"+t_name+"','"+t_add+"','"+Email_id+"',"+t_phno+",'"+t_gender+"')";
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
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);
			}
		}
		if(btn3==e.getSource())
		{
			try
			{
				t_id=Integer.parseInt(text1.getText());
				sql="Delete from trainer where t_id="+t_id+"";
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
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null, e3);
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
            ResultSet rs = stmt.executeQuery("SELECT * from trainer" );			
            while(rs.next())
            {
            	jtable.insertRow(r++, new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)});
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
				t_id=Integer.parseInt(text1.getText());
				t_name=text2.getText();
				t_add=text3.getText();
				Email_id=(text4.getText());
				t_phno=Integer.parseInt(text5.getText());
				String gender;
				if(rbtn1.isSelected())
				{
					gender="Male";
				}
				else if(rbtn2.isSelected())
				{
					gender="Female";
				}
				else if(rbtn3.isSelected())
				{
					gender="Other";
				}
				else
				{
					gender="null";
				}
				t_gender=gender;
				
				
				sql="Update trainer set t_name='"+t_name+"',t_add='"+t_add+"',Email_id='"+Email_id+"',t_phno="+t_phno+",t_gender='"+t_gender+"' where t_id="+t_id+"";
				try {
					stmt=con.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					k=stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "Update   successfully");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Error found");	
				}
				
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				
				
				
			}
			catch(Exception e6)
			{
				JOptionPane.showMessageDialog(null, e6);
			}
		}
		
	}

}