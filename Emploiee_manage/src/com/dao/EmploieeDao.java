package com.dao;

import com.db.DBConnection;
import com.module.Emploiee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmploieeDao implements EmploieeDaoInterface{

    @Override
    public boolean insertEmploiee(Emploiee e) {
        boolean flag=false;
        try{
            Connection con= DBConnection.createConnection();
            String query="insert into student_details(sname,clgname,city,percentage) value(?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,e.getName());
            pst.setString(2,e.getDesignation());
            pst.setString(3,e.getCity());
            pst.setDouble(4,e.getSalary());
            pst.executeUpdate();
            flag=true;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int emp_id) {
        boolean flag=false;
        try{
            Connection con=DBConnection.createConnection();
            String query="delete from emploiee_details where rollnum="+emp_id;
            PreparedStatement pst=con.prepareStatement(query);
            pst.executeUpdate();
            flag=true;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int emp_id, String update, int ch, Emploiee e) {
        int choice=ch;
        boolean flag=false;
        try{
            if(choice==1){
                Connection con=DBConnection.createConnection();
                String query="update emploiee_details set sname=? where Id=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,update);
                ps.setInt(2,emp_id);
                ps.executeUpdate();
                flag=true;

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllEmploiee() {
        try{
            Connection con=DBConnection.createConnection();
            String query="select * from emploiee_details";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("Id: "+rs.getInt(1)+"\n" +
                        "Name: "+rs.getString(2)+"\n" +
                        "Designation: "+rs.getString(3)+"\n" +
                        "City: "+rs.getString(4)+"\n" +
                        "Salary: "+rs.getDouble(5));
                System.out.println("----------------------------------");

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public boolean showEmploieeById(int emp_id) {
        boolean flag=false;
        try{

            Connection con=DBConnection.createConnection();
            String query="select * from emploiee_details where rollnum="+emp_id;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("id: "+rs.getInt(1)+"\n" +
                        "Name: "+rs.getString(2)+"\n" +
                        "Desi8gnation: "+rs.getString(3)+"\n" +
                        "City: "+rs.getString(4)+"\n" +
                        "Salary:+"+rs.getDouble(5));
                //System.out.println("----------------------------------");
                flag=true;

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return flag;
    }
}