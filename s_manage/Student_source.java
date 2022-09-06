package com.s_manage;

import java.util.Scanner;

public class Student_source 
{
	public static void main(String[] args) 
	{    
		Student_source stusrcobj = new Student_source();
		Student_Meth student_Methobj = new Student_Meth();
		Scanner scan = new Scanner(System.in);
		
		int choice;
		// to select what operation to be done from user
		do {
			System.out.println("MENU__________-");
			System.out.println(" 1.INSERT\n 2.DISPLAY\n 3.DELETE\n 4.UPDATE\n 5.EXIT");
			System.out.print("ENTER YOUR CHOICE");
			
			choice = scan.nextInt();
			
			
			switch(choice) {
			
			case 1: 
				
				student_Methobj.insertData();
				
				break;
			
			case 2:
				
				student_Methobj.displayData();
				
				break;
				
			case 3:
				
				student_Methobj.deleteData();
				
				break;
			
			case 4:
				
				student_Methobj.updateData();
				
				break;
			
			case 5:
				System.out.println("HAVE A GOOD DAY....");
				
			default:
				break;
			}
		
		} while (choice != 5);
	}
	
	
}

