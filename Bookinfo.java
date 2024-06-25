package Programmm;
import java.util.*;
import java.sql.*;
public class Bookinfo 
{

	public static void main(String[] args)throws SQLException,ClassNotFoundException
	{
		int bid,price;
		String bname,author;
		Scanner shubham=new Scanner(System.in);
		System.out.println("----Enter the details -----");
		System.out.println("Enter the book id");
		bid=shubham.nextInt();
		System.out.println("Enter the name of the book");
		bname=shubham.next();
		System.out.println("Enter the author name");
		author=shubham.next();
		System.out.println("Enter the price");
		price=shubham.nextInt();
		
		String user="root"; 
		String pass="";
		String url="jdbc:mysql://localhost:3325/book";
		
		//introduction to technology
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver register succesfully");
		
		//introduction to database
		Connection con=DriverManager.getConnection(url,user,pass);//Connection class help to connect with the database
		System.out.println("Connection succesfully");
		
		//introduction to table
		Statement st=con.createStatement();
		String sql="insert into bookinfo values("+bid+",'"+bname+"','"+author+"',"+price+")";
		int i=st.executeUpdate(sql);
		if(i>0)
		{
			System.out.println("Save succefully");
		}
		else
		{
			System.out.println("unsaved");
		}
		//close
		con.close();

	}

}
