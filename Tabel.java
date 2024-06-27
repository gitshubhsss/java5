package Programmm;
import java.awt.*;
import java.awt.event.*;//1
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Tabel extends JFrame implements ActionListener,MouseListener//2
{
	 /**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
	 JLabel lblno1;
	 JTextField txtno1;
	 JLabel lblno2;
	 JTextField txtno2;
	 JLabel lblno3;
	 JTextField txtno3;
	 JButton b,b1,b3,b4;	
	 Statement stmt ;
	 Connection cn;
	 int roll,k,marks;
	 String name,sql;
	
	
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
	
	
	public Tabel() 
	{
		  setSize(1500,1500);  		  	     
	      setTitle("This is our basic AWT example");   
	      setLayout(null);   	      
	      lblno1=new JLabel("Rollno");
	      add(lblno1);
	      lblno2=new JLabel("Name");
	      add(lblno2);
	      lblno3=new JLabel("Marks");
	      add(lblno3);
		  txtno1=new JTextField();
		  add(txtno1);
		  txtno2=new JTextField();
		  add(txtno2);
		  txtno3=new JTextField();
		  add(txtno3);
		  b = new JButton("add");   	   
          add(b); 
          b1 = new JButton("delete");   	         
          add(b1);  
          b3 = new JButton("Update");   	         
          add(b3); 
          b4 = new JButton("Display All");   	         
          add(b4);
          lblno1.setBounds(100, 100, 100,20);txtno1.setBounds(220, 100, 100, 20);
          lblno2.setBounds(100, 150, 100,20);txtno2.setBounds(220, 150, 100, 20);
          lblno3.setBounds(100, 200, 100,20);txtno3.setBounds(220, 200, 100, 20);          
          b.setBounds(150,250,80,30); //x,y,w,h   
          b1.setBounds(250,250,80,30); //x,y,w,h  
          b3.setBounds(350,250,80,30); //x,y,w,h 
          b4.setBounds(450,250,80,30); //x,y,w,h  
          try
	      {
	      Class.forName("com.mysql.jdbc.Driver");
          JOptionPane.showMessageDialog(null, "Driver Reg");  
	      cn=DriverManager.getConnection("jdbc:mysql://localhost:3325/batch3","root","");
	      JOptionPane.showMessageDialog(null, "Conn success"); 
	      }
	      catch(Exception e1)
			{
				 JOptionPane.showMessageDialog(null, ""+e1);  
			}
          
          scrlPane.setBounds(0,330,627,200);
          add(scrlPane);
           tabGrid.setFont(new Font ("Verdana",0,13));
           
           model.addColumn("Rollno");
        
           model.addColumn("Name");
           model.addColumn("Percenatge");
           b.addActionListener(this);//3
           b1.addActionListener(this);
           b3.addActionListener(this);
           b4.addActionListener(this);
	      setVisible(true);  
	      tabGrid.addMouseListener(this);
	     
	    	}
	      
	      
	      
	      
	  		
	public static void main(String[] args) 
	{
		new Tabel();

	}
	@Override
	public void actionPerformed(ActionEvent e3) 
	{
		if(b==e3.getSource())//5
		{
			try
			{
				
			roll=Integer.parseInt(txtno1.getText());
			name=txtno2.getText();
			marks=Integer.parseInt(txtno3.getText());	 
			sql="Insert into student values("+roll+", '" +name +"'," +marks+")";
			stmt=cn.createStatement();
	        k=stmt.executeUpdate(sql);
	         	if(k>0)
			JOptionPane.showMessageDialog(null, "Save successfully");  			
		else
			JOptionPane.showMessageDialog(null, "Error");  
		        stmt.close();
		        txtno1.setText("");
				txtno2.setText("");
				txtno3.setText("");
			}
			catch(Exception e1)
			{
				 JOptionPane.showMessageDialog(null, ""+e1);  
			}
		}
		if(b1==e3.getSource())
		{
			try
			{
				
			roll=Integer.parseInt(txtno1.getText());
		
			sql="delete from  student where roll="+roll+" ";
			stmt=cn.createStatement();
	         k=stmt.executeUpdate(sql);
	         	if(k>0)
			JOptionPane.showMessageDialog(null, "Delete successfully");  			
		else
			 JOptionPane.showMessageDialog(null, "Error");  
		       stmt.close();
		       txtno1.setText("");
				txtno2.setText("");
				txtno3.setText("");
			}
			catch(Exception e1)
			{
				 JOptionPane.showMessageDialog(null, ""+e1);  
			}
			
			
		}
		if(b3==e3.getSource())
		{
			try
			{
				
			roll=Integer.parseInt(txtno1.getText());
			name=txtno2.getText();
			float marks=Float.parseFloat(txtno3.getText());	 
            sql="update student set name='" +name+"', marks="+marks+" where roll="+roll+"";
			stmt=cn.createStatement();
	         k=stmt.executeUpdate(sql);
	         	if(k>0)
			JOptionPane.showMessageDialog(null, "update successfully");  			
		else
			 JOptionPane.showMessageDialog(null, "Error");  
		       stmt.close();
		       txtno1.setText("");
				txtno2.setText("");
				txtno3.setText("");
			}
			catch(Exception e1)
			{
				 JOptionPane.showMessageDialog(null, ""+e1);  
			}
			
			
		}
		
		
		if(b4==e3.getSource())
		{
			int r=0;
			Statement stmt;
			model.setRowCount(0);
			try 
			{
			stmt = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
            ResultSet rs = stmt.executeQuery("SELECT * from student" );			
            while(rs.next())
            {
            	model.insertRow(r++, new Object[]{rs.getInt(1),rs.getString(2),rs.getFloat(3) });
            }
            
			} 
			catch (SQLException e) 
			{				
				e.printStackTrace();
			}
		}
	}
			  public void mouseClicked(MouseEvent e)
			 {                                     
		    	   
			 }





			@Override
			public void mousePressed(MouseEvent e)
			{
				 DefaultTableModel dtm = (DefaultTableModel) tabGrid.getModel(); //create a model
		    	    int selectedRowIndex = tabGrid.getSelectedRow(); //get selected row
		    	    int id = (Integer) dtm.getValueAt(selectedRowIndex, 0); //get the primary key to fetch data.
		    	    try {
		    	    	Statement stmt = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);			
		                
		    	        ResultSet rs = stmt.executeQuery("SELECT * from student where roll="+id+"" );
		    	        while(rs.next()){    //u can use normal query
		    	        	txtno1.setText(""+rs.getInt(1));  //these are my textfields
		    	        	txtno2.setText(rs.getString(2));
		    	        	txtno3.setText(""+rs.getFloat(3));
		    	            
		    	        }
		    	    } catch (Exception ex) {
		    	    	System.out.println(ex);
		    	          
		}
				
			}





			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}





			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}





			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

}