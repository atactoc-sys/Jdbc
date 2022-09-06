package com.menu_drivem;

import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu_Src 
{
	Scanner scannerobj = new Scanner(System.in);
	int Id,Age,Salary;
	String Name,City;
	//  SAVING EMPLOIEE DETAILS IN DETABASE
	public void saveMenuDriven() throws SQLException
	{
		System.out.println("ENTER EMPLOIEE ID");
		Id = scannerobj.nextInt();
		System.out.println("ENTER EMPLOIEE NAME");
		Name = scannerobj.nextLine();
		System.out.println("ENTER EMPLOIEE AGE");
		Age = scannerobj.nextInt();
		System.out.println("ENTER EMPLOIEE CITY");
		City = scannerobj.nextLine();
		System.out.println("ENTER EMPLOIEE SALARY");
		Salary = scannerobj.nextInt();
		Connection connectionobj = Helper.con();
		PreparedStatement s1 = connectionobj.prepareStatement("insert into Menudriven values(?,?,?,?,?)");
		s1.setInt(1,Id);
		s1.setString(2,Name);
		s1.setInt(3,Age);
		s1.setString(2,City);
		s1.setInt(1,Salary);
		s1.executeUpdate();
		connectionobj.close();
	}
	//  FACHING EMPLOIEE DETAILS IN DETABASE
	public void fetchMenudriven() throws SQLException
	{
		Connection connectionobj = Helper.con();
		Statement statementobj = connectionobj.createStatement();
		ResultSet rSet = statementobj.executeQuery("select * from Menudriven");
		
		while (rSet.next())
		{
			System.out.println(rSet.getInt(1)+" "+rSet.getString(2)+" "+rSet.getInt(3)+" "+rSet.getString(4)+" "+rSet.getInt(5));
		}
		connectionobj.close();
		statementobj.close();
	}
	//   updating employee in the deta base
	public void updateMenuedriven() throws SQLException
	{
		Connection connectionobj = Helper.con();
		Statement statementobj = connectionobj.createStatement();
		System.out.println("ENTER EMPLLOIEE CITY");
		City = scannerobj.nextLine();
		statementobj.executeUpdate("update  menudriven set City = '" + City +"'+whereId = "+Id);
		connectionobj.close();
		statementobj.cancel();
	}
	//  DELETING EMPLOIEE DETAILS IN DETA BASE
	public void deleteMenuDriven() throws SQLException
	{
		Connection connectionobj = Helper.con();
		Statement statementobl = connectionobj.createStatement();
		System.out.println("ENTER EMPLOIEE ID");
		Id = scannerobj.nextInt();
		statementobl.executeUpdate("delete from Menuedriven where id ="+Id);
	}
}
