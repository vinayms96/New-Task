package database;
import java.sql.*;

public class addStudent {
    public static void main(String[] args) {
        studentDAO sd = new studentDAO();
        StudentDetails stu = new StudentDetails();
        stu.sname="Satish";
        stu.marks=79;
        stu.age=22;
        sd.addStud(stu);
    }
}

class studentDAO{
    public void addStud(StudentDetails stu){
        try {
            String query = "INSERT INTO student (sname,marks,age) VALUES (?,?,?)";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","acernsrc");
            PreparedStatement pst = connect.prepareStatement(query);
            pst.setString(1,stu.sname);
            pst.setInt(2,stu.marks);
            pst.setInt(3,stu.age);
            int rs = pst.executeUpdate();
            System.out.println(rs+" Row(s) Affected");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class StudentDetails{
    int marks;
    int age;
    String sname;
}
