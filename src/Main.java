import com.student.manage.Student;
import com.student.manage.StudentDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        System.out.println("Welcome to Student Management System");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("Press 1 to ADD");
            System.out.println("Press 2 to Delete");
            System.out.println("Press 3 to Display Students");
            System.out.println("Press 4 to Exit");

            int c=Integer.parseInt(br.readLine());

            if(c==1){
                //add student
                System.out.println("Enter user name :");
                String name =br.readLine();
                System.out.println("Enter user phone :");
                String phone=br.readLine();
                System.out.println("Enter user city:");
                String city=br.readLine();

                //create student object to store student
                Student s =new Student(name,phone,city);
                boolean answer=StudentDAO.insertStudentToDB(s);
                if(answer){
                    System.out.println("Student added successfully");
                }
                else{
                    System.out.println("Something went wrong try again");
                }

            }
            else if(c==2){
                //delete Student
                System.out.println("Enter student id to delete :");
                int userID =Integer.parseInt(br.readLine());
                Boolean answer=StudentDAO.deleteStudent(userID);
                if(answer){
                    System.out.println("Deleted Successfully");
                }
                else{
                    System.out.println("Something Went Wrong");
                }


            }
            else if(c==3){
                //display students
                StudentDAO.showAllStudents();
            }
            else if(c==4){
                break;
            }else{
                System.out.println("Invalid input");
            }
        }
        System.out.println("Thank You for using my Application Bye Bye");
    }
}