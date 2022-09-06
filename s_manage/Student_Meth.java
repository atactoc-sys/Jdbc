package com.s_manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student_Meth 
{
	// METHOD FOR CONNRCTION
		public Connection getConnect() 
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver()");
				// CONNECTS DETABASE
				Connection connectionobj = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","anit@1998*07");
				
				return connectionobj;
			
			} catch (Exception e) 
			{
				System.out.println(e);
			}
			return null;
		}
		
		//  INSERT METHOD
		public void insertData() 
		{
			
			Scanner scannerobj1 = new Scanner(System.in);
			Scanner scannerobj2 = new Scanner(System.in);
			Scanner scannerobj3 = new Scanner(System.in);
			Scanner scannerobj4 = new Scanner(System.in);
			
			Student studentobj = new Student();
			
			System.out.print("ENTER STUDENT ID");
			studentobj.setStudent_Id(scannerobj1.nextInt());
			
			System.out.print("ENTER STUDENT NAME");
			studentobj.setStudent_Name(scannerobj2.nextLine());
			
			System.out.print("ENTER STUDENT ADDERSS");
			studentobj.setStudent_Address(scannerobj3.nextLine());
			
			System.out.print("ENTER CONTACT NUMBER");
			studentobj.setStudent_Number(scannerobj4.nextLong());
			
			
			try 
			{
				//  CCONNECTION
				Connection connectionobj = getConnect();
				
				//  SQL STATEMENT
				PreparedStatement preparedStatementobj = connectionobj.prepareStatement("insert into student values(?,?,?,?)");
				
				//  INSERT DETA
				preparedStatementobj.setInt(1, studentobj.getStudent_Id());
				preparedStatementobj.setString(2, studentobj.getStudent_Name());
				preparedStatementobj.setString(3, studentobj.getStudent_Address());
				preparedStatementobj.setLong(4, studentobj.getStudent_Number());
				
				//  EXECUTE
				preparedStatementobj.execute();
				System.out.println("DETA SAVED");
				
				preparedStatementobj.close();
				connectionobj.close();
			
			} catch (Exception e) 
			{
				System.out.println("ALREADY EXISTS!"+e);
			}
			scannerobj1.close();
			scannerobj2.close();
			scannerobj3.close();
			scannerobj4.close();
			
		}

		//  TO DISPLAY THE DETA
		public void displayData() 
		{
			try 
			{
				Connection connectionobj = getConnect();
				PreparedStatement preparedStatementobj = connectionobj.prepareStatement("select * from student");
				ResultSet rs = preparedStatementobj.executeQuery();
				System.out.println("--------------------------");
				
				//  ITARATING TABLE
				while (rs.next()) 
				{
					
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getLong(4));
				}
				
				System.out.println("--------------------------");
				rs.close();
				preparedStatementobj.close();
				connectionobj.close();
			} catch (Exception e) 
			{
				System.out.println(e);
			}
			
		}
		//  DELETE METHOD
		public void deleteData() 
		{
			try 
			{
				Scanner scannerobuj1 = new Scanner(System.in);
				int id;
				System.out.print("ENTER ID TO DELETE");
				id = scannerobuj1.nextInt();
				Connection connectionobj = getConnect();
				PreparedStatement preparedStatementobj = connectionobj.prepareStatement("delete from student where stdId = ?");
				preparedStatementobj.setInt(1, id);
				int x = preparedStatementobj.executeUpdate();
				if(x==1) 
				{ 
					System.out.println("DELETED SUCCESSFULLY");
				}
				else {
					System.out.println("ERRROR.. NO MATCH FOUND");
				}
				scannerobuj1.close();
				preparedStatementobj.close();
				connectionobj.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		//  UPDATE METHOD
		public void updateData() {
			Scanner scannerobuj11 = new Scanner(System.in);
			Scanner scannerobuj12 = new Scanner(System.in);
			Scanner scannerobuj13 = new Scanner(System.in);
			Scanner scannerobuj14 = new Scanner(System.in);
			
			Student studentobj = new Student();
			
			System.out.print("ENTER ID");
			int id = scannerobuj11.nextInt();
			studentobj.setStudent_Id(id);
			
			System.out.print("ENTER NAME");
			String name = scannerobuj12.nextLine();
			studentobj.setStudent_Name(name);
			
			System.out.print("ENTER ADDRESS");
			String address = scannerobuj13.nextLine();
			studentobj.setStudent_Address(address);
			
			System.out.print("ENTER NUMBER");
			long num = scannerobuj14.nextLong();
			studentobj.setStudent_Number(num);
			
			try 
			{
				Connection connectionobj = getConnect();
				
				String str = "update student set stdName = ?, stdAddress = ?, stdNumber = ? where stdId = ?";
				
				PreparedStatement preparedStatementobj = connectionobj.prepareStatement(str);
				
				preparedStatementobj.setString(1, studentobj.getStudent_Name());
				preparedStatementobj.setNString(2, studentobj.getStudent_Address());
				preparedStatementobj.setLong(3, studentobj.getStudent_Number());
				preparedStatementobj.setInt(4, studentobj.getStudent_Id());
				
				int x = preparedStatementobj.executeUpdate();
				
				preparedStatementobj.close();
				connectionobj.close();
				
				if(x==1) 
				{
					System.out.println("UPDATED SUCCESSFULLY");
				}
				else {
					System.out.println("ERROR... NO MATCH FOUND ");
				}

			} catch (Exception e) 
			{
				System.out.println(e);
			}
			scannerobuj11.close();
			scannerobuj12.close();
			scannerobuj13.close();
			scannerobuj14.close();
			
		}
}
