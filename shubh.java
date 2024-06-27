package Programmm;
import java.util.*;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
public class shubh 
{

	public static void main(String[] args)throws SQLException,ClassNotFoundException
	{
		int id,sallary;
		int mo;
		String name,specification;
		Scanner shubham=new Scanner(System.in);
		System.out.println("----Enter the details -----");
		System.out.println("Enter the doctors id");
		id=shubham.nextInt();
		System.out.println("Enter the name");
		name=shubham.next();
		System.out.println("Enter the specification");
		specification=shubham.next();
		System.out.println("Enter the mobile number");
		mo=shubham.nextInt();
		System.out.println("Enter the sallary");
		sallary=shubham.nextInt();
		String user="root";
		String pass="";
		String url="jdbc:mysql://localhost:3325/doc";
		//introduction to technology
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver register succesfully");
		
		//introduction to database
		Connection con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connection succesfully");
		
		//introduction to table
		Statement st=con.createStatement();
		String sql="insert into doctor_details values("+id+",'"+name+"','"+specification+"',"+mo+","+sallary+")";
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
		ResultSet rs=st.executeQuery("Select * from doctor_details where id=1");
		rs.next();
		id=rs.getInt("id");
		name=rs.getString("name");
	    specification=rs.getString("specification");
	    mo=rs.getInt(mo);
	    sallary=rs.getInt(sallary);
		 
		 System.out.println(id+""+name+""+specification+""+mo+""+sallary);
		
		con.close();

	}

}
