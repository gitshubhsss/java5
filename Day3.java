package Programmm;
import java.sql.*;
import java.util.*;
public class Day3 
{

	public static void main(String[] args) throws SQLException,ClassNotFoundException
	{
		int bid,price;
		int ch,k;
		String bname,author;
		Scanner shubham=new Scanner(System.in);
		String user="root"; 
		String pass="";
		String url="jdbc:mysql://localhost:3325/book";//here we have set the path 
		//indroduction to technology
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver register succesfully");
		//connect with database
		Connection con=DriverManager.getConnection(url,user,pass);//Connection class help to connect with the database
		System.out.println("Connection succesfully");
		Statement st=con.createStatement();
		do
		{
			System.out.println("\n1:Insert\n2:update\n3:delete\n4:display\n5:search\n6:exit");
			System.out.println("Enter your choise");
			ch=shubham.nextInt();
			switch(ch)
			{
			case 1:st=con.createStatement();
				   System.out.println("Enter the book id");
				   bid=shubham.nextInt();
				   System.out.println("Enter the book name");
				   bname=shubham.next();
				   System.out.println("enter the author name");
				   author=shubham.next();
				   System.out.println("Enter the price");
				   price=shubham.nextInt();
				   
				   String sql="insert into bookinfo values ("+bid+",'"+bname+"','"+author+"',"+price+")";
				   k=st.executeUpdate(sql);
				   if(k>0)
				   {
					   System.out.println("Save succesfully");
				   }
				   else
				   {
					   System.out.println("Unsaved");
					   
				   }
				   break;
			case 2:st=con.createStatement();
			   	   System.out.println("Enter the book id");
			   	   bid=shubham.nextInt();
			   	   System.out.println("Enter the book name");
			   	   bname=shubham.next();
			   	   System.out.println("enter the author name");
			   	   author=shubham.next();
			   	   System.out.println("Enter the price");
			   	   price=shubham.nextInt();
			   	   sql="update bookinfo set bname='"+bname+"',author='"+author+"',price="+price+" where bid="+bid+" "; 
				   k=st.executeUpdate(sql);
				   if(k>0)
				   {
					   System.out.println("Update succesfully");
				   }
				   else
				   {
					   System.out.println("error");
				   }
				   st.close();
				   break;
			case 3:st=con.createStatement();
					System.out.println("Enter the book id");
					bid=shubham.nextInt();
					
					sql="delete from bookinfo where bid="+bid+" ";
					k=st.executeUpdate(sql);
					if(k>0)
					{
						System.out.println("Delete succesfully");
					}
					else
					{
						System.out.println("Error");
					}
					st.close();
					break;
					
			case 4:st=con.createStatement();
				   sql="select * from bookinfo ";
				   ResultSet res=st.executeQuery(sql);
				   while(res.next())
				   {
					   System.out.println(res.getInt("bid")+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getInt(4));
				   }
				   break;
				   
			case 5:int flag=0;
			st=con.createStatement();
			System.out.println("Enter the book id");
			bid=shubham.nextInt();
			sql="select * from bookinfo where bid="+bid+"";
			ResultSet res1=st.executeQuery(sql);
			while(res1.next())
			{
				flag=1;
				System.out.println(res1.getInt(1)+"\t"+res1.getString(2)+"\t"+res1.getString(3)+"\t"+res1.getInt(4));
				
			}
			if(flag==0)
			{
				System.out.println("Record not found");
				
			}
			break;
			
			case 6:System.exit(0);
			      default:System.out.println("Invalid choise entered ");
				   
			}
			
		}while(ch<=7);
		
		

	}

}
