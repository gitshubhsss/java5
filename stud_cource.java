package Programmm;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class stud_cource extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	Font f3=new Font("Algerian",Font.CENTER_BASELINE,15);
	Font f1=new Font("Arial",Font.BOLD,15);
	Connection con;
	JComboBox combo;
	Statement state1,state2,state3;
	int k;
	String sql,sql1,sql2;
	int cid,sid;
	String cname,sname,instructor;

	
	//table creation
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    
	stud_cource()
	{
		
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setSize(800,800);
		setLocation(100,10);
		setLayout(null);
		
		
		
		l1=new JLabel("cource id : ");
		add(l1);
		l1.setFont(f1);
		l1.setBounds(90, 100,100, 30);
		
		t1=new JTextField();
		add(t1);
		t1.setBounds(220, 100, 200, 30);
		
		l1=new JLabel("cource id : ");
		add(l1);
		l1.setFont(f1);
		l1.setBounds(90, 100,100, 30);
		
		l2=new JLabel("co name : ");
		add(l2);
		l2.setFont(f1);
		l2.setBounds(90, 160,100, 30);
		
		t2=new JTextField();
		add(t2);
		t2.setBounds(220, 160, 200, 30);
		
		
		l3=new JLabel("instructor: ");
		add(l3);
		l3.setFont(f1);
		l3.setBounds(90, 220,100, 30);
		
		t3=new JTextField();
		add(t3);
		t3.setBounds(220, 220, 200, 30);
		
		l4=new JLabel("stud_id: ");
		add(l4);
		l4.setFont(f1);
		l4.setBounds(90, 280,100, 30);
		
		t4=new JTextField();
		add(t4);
		t4.setBounds(220, 280, 200, 30);
		
		l5=new JLabel("stud_name: ");
		add(l5);
		l5.setFont(f1);
		l5.setBounds(90, 340,100, 30);
		
		t5=new JTextField();
		add(t5);
		t5.setBounds(220, 340, 200, 30);
		
		b1=new JButton("add");
		add(b1);
		b1.setBounds(130, 440, 90, 30);
		
		b2=new JButton("Delete");
		add(b2);
		b2.setBounds(240, 440, 90, 30);
		
		b3=new JButton("Update");
		add(b3);
		b3.setBounds(340, 440, 90, 30);
		
		//String[] Cource= {"java","python","html","php"};
		JComboBox combo=new JComboBox();
		add(combo);
		combo.setBounds(500, 100, 100, 30);	
		
		scrlPane.setBounds(20,500,627,200);
        add(scrlPane);
        tabGrid.setFont(new Font ("Verdana",0,13));
        
        model.addColumn("stud id");
        model.addColumn("name");
        model.addColumn("Cource");
        
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this); 
		combo.addActionListener(this);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(null, "Driver register succesfully");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3325/admission","root","");
			JOptionPane.showMessageDialog(null,"Connection succefully");
		
		try
		{
			sql="select cname from cource";
			state1=con.createStatement();
			ResultSet res=state1.executeQuery(sql);
			while(res.next())
			{
				String s1=res.getString(1);
				combo.addItem(s1);
			}
		}
		catch(Exception e4)
		{
			JOptionPane.showMessageDialog(null,""+e4);
		}
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,""+ e1);
		}
	}
	
	public static void main(String[] args)
	{
		stud_cource c1=new stud_cource();

	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(b1==e.getSource())
		{
			try
			{
				cid=Integer.parseInt(t1.getText());
				cname=t2.getText();
				instructor=t3.getText();
				sid=Integer.parseInt(t4.getText());
				sname=t5.getText();
				sql= "Insert into cource values("+cid+",'"+cname+"','"+instructor+"')";
				sql1="Insert into student values("+sid+",'"+sname+"')";
				sql2="Insert into stud_cource values("+cid+","+sid+")";
				state1=con.createStatement();
				state2=con.createStatement();
				state3=con.createStatement();
				k=state1.executeUpdate(sql);
				k=state2.executeUpdate(sql1); 
				k=state3.executeUpdate(sql2);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "Insert successfully");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Error found");	
				}
				state1.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");

			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, e2);

			}
			
		}
		if(b2==e.getSource())
		{
			try
			{
				cid=Integer.parseInt(t1.getText());
				sid=Integer.parseInt(t4.getText());
				sql="Delete from cource where cid="+cid+"";
				sql1="Delete from student where sid="+sid+"";
				sql2="Delete from stud_cource where cid="+cid+"";
				state1=con.createStatement();
				state2=con.createStatement();
				state3=con.createStatement();
				k=state1.executeUpdate(sql);
				k=state2.executeUpdate(sql1); 
				k=state3.executeUpdate(sql2);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "Delete successfully");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Error found");	
				}
				state1.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, ""+e2);
			}
		}
		if(b3==e.getSource())
		{
			try
			{
				cid=Integer.parseInt(t1.getText());
				cname=t2.getText();
				instructor=t3.getText();
				sid=Integer.parseInt(t4.getText());
				sname=t5.getText();
				sql="Update cource set cname='"+cname+"',instructor='"+instructor+"' where cid="+cid+"";
				sql1="Update student set sname='"+sname+"' where sid="+sid+" ";
				sql2="Update stud_cource set sid="+sid+" where cid="+cid+"";
				state1=con.createStatement();
				state2=con.createStatement();
				state3=con.createStatement();
				k=state1.executeUpdate(sql);
				k=state2.executeUpdate(sql1); 
				k=state3.executeUpdate(sql2);
				if(k>0)
				{
					JOptionPane.showMessageDialog(null, "update successfully");
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Error found");	
				}
				state1.close();
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				
				
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null,""+e2);
			}
		}
		if(combo==e.getSource())
		{
			int r=0;
			model.setRowCount(0);
			try
			{
				state1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				sql = "Select sname , cname,sid from cource , student , stud_cource where student.sid=stud_cource.sid and cource.cid=stud_cource.cid and cname='"+cname+"' ";
				cname=(String) combo.getSelectedItem();
				ResultSet res = state1.executeQuery(sql);
				while(res.next())
				{
				     model.insertRow(r++,new Object[] {res.getString(1),res.getString(2)});
				}
			}
				
				
			
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null,""+e2);
			}
		}
		
	}

}
