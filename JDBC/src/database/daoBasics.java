package database;
import java.sql.*;

public class daoBasics {
    public static void main(String[] args) {
        StudentDAO s = new StudentDAO();
        Student stu = s.getStudent(4);
        if(stu.sname!=null && !stu.sname.equals("")) {
            System.out.println("Student having Rollno = " + stu.rollno + " is " + stu.sname);
        }
        else {
            System.out.println("Student not available with Rollno= " + stu.rollno);
        }
    }
}

class StudentDAO{
    public Student getStudent(int rollno){
        String query = "SELECT  sname FROM student WHERE rollno="+rollno;
        Student st = new Student();
        st.rollno = rollno;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","acernsrc");
            Statement stat = connect.createStatement();
            ResultSet rs = stat.executeQuery(query);
            rs.next();
            if(rs.getString(1)!=null)
                st.sname = rs.getString(1);
            else
                st.sname = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}

class Student{
    int rollno;
    String sname;
}
