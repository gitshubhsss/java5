package Programmm;
import java.sql.*;
import java.util.*;
public class DayTwo 
{

	public static void main(String[] args)throws SQLException,ClassNotFoundException
	{
		int ch,roll,marks,k;
		String name;  
		int flag=0;
		Statement stmt;
		Class.forName("com.mysql.jdbc.Driver"); 
		String user="root"; 
		String pass="";
		String url="jdbc:mysql://localhost:3325/school";
		System.out.println("Driver register succesfully");
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connection succesfully");
	    Scanner shubham=new Scanner(System.in);
	    do
	    { 
	    	System.out.println("Menu");
	    	System.out.println("\n1:insert\n2:Update\n3:Delete\n4:Display\n5:search\n6:Exit");
	    	System.out.println("Enter your choise");
	    	ch=shubham.nextInt();
	    	switch(ch)
	    	{
	    	case 1:	stmt=con.createStatement();
	    			System.out.println("Enter the roll number");
	    			roll=shubham.nextInt();
	    			System.out.println("Enter the name");
	    			name=shubham.next();
	    			System.out.println("Enter marks");
	    			marks=shubham.nextInt();
	    			String sql="insert into classinfo  values("+roll+",'"+name+"','"+marks+"')";
	    			k=stmt.executeUpdate(sql);
	    			if(k>0)
	    			{
	    				System.out.println("Save succefully");
	    			}
	    			else
	    			{
	    				System.out.println("unsaved");
	    			}
	    			break;
	    	case 2: stmt=con.createStatement();
					System.out.println("Enter the roll number");
					roll=shubham.nextInt();
					System.out.println("Enter the name");
					name=shubham.next();
					System.out.println("Enter marks");
					marks=shubham.nextInt();
					sql="update classinfo set name='"+name+"',marks="+marks+" where roll="+roll+" ";
					k=stmt.executeUpdate(sql);
	    			if(k>0)
	    			{
	    				System.out.println("record updated");
	    			}
	    			else
	    			{
	    				System.out.println("nothing has happned");
	    			}
	    			stmt.close();
	    			break;
	    			
	    	case 3: stmt=con.createStatement();
					System.out.println("Enter the roll number");
					roll=shubham.nextInt();
					System.out.println("Enter the name");
					name=shubham.next();
					System.out.println("Enter marks");
					marks=shubham.nextInt();
					sql="delete from classinfo where roll="+roll+" ";
					k=stmt.executeUpdate(sql);
					if(k>0)
	    			{
	    				System.out.println("record updated");
	    			}
	    			else
	    			{
	    				System.out.println("nothing has happned");
	    			}
					stmt.close();
	    			break;
	    			
	    	case 4:stmt=con.createStatement();
	    		   sql="select * from classinfo ";
	    		   ResultSet res=stmt.executeQuery(sql);
	    		   while(res.next())
	    		   {
	    			   System.out.println(res.getInt("roll")+"\t"+res.getString(2)+"\t"+res.getInt(3));
	    		   }
	    			break;
	    			
	    	case 5: flag=0;
	    			stmt=con.createStatement();
	    			System.out.println("Enter the roll number");
					roll=shubham.nextInt();
					sql="select * from classinfo where roll="+roll+"";
					ResultSet res1=stmt.executeQuery(sql);
					while(res1.next())
					{
						flag=1;
						System.out.println(res1.getInt(1)+"\t"+res1.getString(2)+"\t"+res1.getInt(3));
						
					}
					if(flag==0)
					{
						System.out.println("Record not found");
						
					}
					break;
					
	    	case 6:System.exit(0);
	    			default:System.out.println("Invalid choise entered ");
		    	    
					
	    			
	    	}
	    	
	    }
	    while(ch>=6);

	}

}
