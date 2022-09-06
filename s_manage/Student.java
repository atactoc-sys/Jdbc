package com.s_manage;

public class Student 
{     // parent class
	// taking variables
	private int student_Id;
	private String student_Name;
	private String student_Address;
	private long student_Number;
	
	public int getStudent_Id() 
	{
		return student_Id;
	}
	
	public void setStudent_Id(int student_Id) 
	{
		this.student_Id = student_Id;
	}
	
	public String getStudent_Name() 
	{
		return student_Name;
	}
	
	public void setStudent_Name(String student_Name) 
	{
		this.student_Name = student_Name;
	}
	
	public String getStudent_Address() 
	{
		return student_Address;
	}
	
	public void setStudent_Address(String student_Address) 
	{
		this.student_Address = student_Address;
	}
	
	public long getStudent_Number() 
	{
		return student_Number;
	}
	
	public void setStudent_Number(long student_Number) 
	{
		this.student_Number = student_Number;
	}
	
}