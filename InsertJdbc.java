package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJdbc 
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://daku","rppt","root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into customer values (7,'dita',Agar)");
			System.out.println("inserted succfessfully");
			conn.close();
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
