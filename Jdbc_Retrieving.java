package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_Retrieving {
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");	//loading driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/daku" ,"root" ,"root");	//getting connection 
			Statement stmt = conn.createStatement();	//creating statement
			ResultSet rs = stmt.executeQuery("select * from emp_trainee");	
			
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));	//printing all data from database
			}
			conn.close();			//closing connection
		} catch (Exception e) 
		{		
			System.out.println(e);
		}
	}
}
