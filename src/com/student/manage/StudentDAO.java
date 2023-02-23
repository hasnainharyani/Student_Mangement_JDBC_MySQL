package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    public static Boolean insertStudentToDB(Student s){
        Boolean f=false;

        try{

            Connection con =CP.createC();

            String q="insert into students(sname,sphone,scity) values(?,?,?)";
            //PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(q);
            //set the values of parameters
            pstmt.setString(1, s.getStudentName());
            pstmt.setString(2, s.getStudentPhone());
            pstmt.setString(3, s.getStudentCity());

            //execute
            pstmt.execute();
            f=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static Boolean deleteStudent(int userId){
        Boolean f=false;

        try{

            Connection con =CP.createC();

            String q="delete from students where sid=?";
            //PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(q);
            //set the values of parameters
            pstmt.setInt(1,userId );
            //execute
            pstmt.execute();
            f=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudents() {

        try{

            Connection con =CP.createC();

            String q="select * from students";
            //PreparedStatement
            Statement stmt=con.createStatement();
            //execute
            ResultSet set=stmt.executeQuery(q);

            while(set.next()){
                int id =set.getInt(1);
                String name=set.getString(2);
                String phone=set.getString(3);
                String city=set.getString("scity");

                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Phone : "+phone);
                System.out.println("City : "+city);
                System.out.println("--------------------");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
