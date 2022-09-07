package Emp_main;

import com.dao.EmploieeDao;
import com.dao.EmploieeDaoInterface;
import com.module.Emploiee;

import java.util.Scanner;

public class Client 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);

        EmploieeDaoInterface dao =new EmploieeDao();
        System.out.println("Welcome to Emploiee Management application");
        while(true)
        {
            System.out.println("\n1.Add Emploiee" +
                    "\n2.Show All Emploiee+" +
                    "\n3.Get Emploiee based on roll number+" +
                    "\n4.Delete Emploiee"+
                    "\n5.Update Emploiee" +
                    "\n6.Exit");
            System.out.println("Enter choice");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Add Emploiee");
                    System.out.println("Enter Emploiee Name");
                    String name = sc.next();
                    System.out.println("Enter Emploiee Designation");
                    String designation = sc.next();
                    System.out.println("Enter city");
                    String city = sc.next();
                    System.out.println("Enter Salary");
                    double salary = sc.nextDouble();
                    Emploiee ep = new Emploiee(name,designation,city,salary);
                    boolean ans = dao.insertEmploiee(ep);
                    if(ans)
                    {
                        System.out.println("Record inserted Successfully!!!");
                    }
                    else
                    {
                        System.out.println("something went wrong, please try again");
                    }

                    break;
                case 2:
                    System.out.println("Show all emploiee ");
                    dao.showAllEmploiee();

                    break;
                case 3:
                    System.out.println("Get student based on rollnumber");
                    System.out.println("enter emp_id");
                    int emp_id = sc.nextInt();
                  boolean f =  dao.showEmploieeById(emp_id);
                  if(!f)
                  {
                      System.out.println("Emploiee with this id is not founf");
                  }

                    break;
                case 4:
                    System.out.println("Delete Emploiee");
                    System.out.println("enter emp_id to delete");
                    int id = sc.nextInt();
                    boolean ff = dao.delete(id);
                    if(ff)
                    {
                        System.out.println("Record deleted successfully...");
                    }
                    else
                    {
                        System.out.println("Something went wrong");
                    }
                    break;
                case 5:
                    System.out.println("Update the emploiee");
                    System.out.println("\n1.Update name\n2.Update designation");
                    System.out.println("enter your choice");
                    int choice = sc.nextInt();
                    if(choice == 1)
                    {
                        System.out.println("enter emp_id");
                        int idn = sc.nextInt();
                        System.out.println("Enter new name");
                        String ename = sc.next();
                        Emploiee emp = new Emploiee();
                        emp.setName(ename);
                      boolean flag =dao.update(idn,ename,choice,emp);
                      if(flag)
                      {
                          System.out.println("Name updated successfully");
                      }
                      else
                      {
                          System.out.println("Something went wrong...");
                      }
 }
                    break;
                case 6:
                    System.out.println("Thank You fro using Emploiee management application!!!");
                    System.exit(0);
                default:
                    System.out.println("Please enter valid choice..");
            }
        }
    }
}
