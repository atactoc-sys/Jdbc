package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Scannerjdbc {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter first name");
		String Fname = scan.next();
		System.out.println("enter last name");
		String Lname = scan.next();
		System.out.println("enter cpstomer id");
		String cust_id = scan.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/daku","root","root");
			PreparedStatement stm;
			String sql = "insert into CUSTOMER values(8,?,?)";
			stm = conn.prepareStatement(sql)
			stm.setString(2,Fname);
			stm.setString(3,Lname);
			stm.setString(1,cust_id);
			stm.execute()
			System.out.println("inserted successfully");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
