package Programmm;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class MainMenu1 extends JFrame 
{
	
	 public JPanel top,lower;
	
	 	JLabel leli;	

		JMenuBar mbr=new JMenuBar();

		JMenu A_form=new JMenu("Admission");
		JMenuItem fresh=new JMenuItem("New Admission");
        JMenuItem fresh1=new JMenuItem("Enquiry");
       // JMenuItem fresh2=new JMenuItem("Cource");
        
        JMenu A_Cource=new JMenu("Course");
        JMenuItem fresh2=new JMenuItem("Course_details");
        
        JMenu A_trainer=new JMenu("Trainer");
        JMenuItem fresh3=new JMenuItem("Traner record");
        
        JMenu A_batch=new JMenu("Batches");
        JMenuItem fresh4=new JMenuItem("batch record");
        
        
        
        
	
		JMenu tea=new JMenu("Trainer");
		
		
		 JMenu cour=new JMenu("Course");
	 
		 
	 
	 	 JMenu batch=new JMenu("Batches");
         JMenu exam=new JMenu("Exam");

         JMenuItem cert=new JMenuItem("Certificate ");
         
         
         JMenu bill=new JMenu("Receipt");
         JMenu Report=new JMenu("Report");
         JMenu exit=new JMenu("Logout");

		
		String temp;
		 
		  
	
 public void LaunchFrame()	
 {
	 	    setSize(1023,735);
	 	    setLayout(null);
	 	    setTitle("DAnce Academy System");
	    	setResizable(false);
	 	    add(mbr);
               
	    	mbr.add(A_form);
	    	A_form.add(fresh);
	    	A_form.add(fresh1);
	    //	A_form.add(fresh2);
	    	
	    	
	    	mbr.add(A_Cource);
	    	A_Cource.add(fresh2);
	    	
	    	mbr.add(A_trainer);
	    	A_trainer.add(fresh3);
	    	
	    	mbr.add(A_batch);
	    	A_batch.add(fresh4);
	    	
	    	

	    	//mbr.add(tea);

     		//mbr.add(cour);
     		mbr.add(batch);
		    mbr.add(exam);
		    mbr.add(cert);
		    mbr.add(bill);
		    mbr.add(Report);
		    setJMenuBar(mbr);
		    setVisible(true);

}
 public void Check_Event()
 {

	 fresh.addActionListener(new ActionListener()
		{
	   
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==fresh)
	   	  	{
	   	  	   Admission f1=new Admission();
	   	  	}
	   	  }	   	  
	   });
	 
	 
	 fresh1.addActionListener(new ActionListener()
		{
	   
	   	  public void actionPerformed(ActionEvent ae)
	   	  {
	   	  	if(ae.getSource()==fresh1)
	   	  	{
	   	  	   AddRecord f2=new AddRecord();
	   	  	}
	   	  }	   	  
	   });
	   
	 fresh2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==fresh2)
			{
				
				AddRecord f3=new AddRecord();
			}
			
		}
	});
	 fresh3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==fresh3)
				{
					
					TrainerRecord f4=new TrainerRecord();
				}
				
			}
		});
	 fresh4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ie)
			{
				if(ie.getSource()==fresh4)
				{
					
					try {
						BatchRecord f4=new BatchRecord();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
	 
	 
	 

	 
 }

		  public static void main(String args[])
		  {
		      MainMenu1 menu1=new MainMenu1();
		      menu1.LaunchFrame();	
		  	  menu1.Check_Event();	
		  	
		  }

 
	 }