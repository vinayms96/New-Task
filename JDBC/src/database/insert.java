package database;

import java.sql.*;

public class insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/first";
        String user = "root";
        String pwd = "acernsrc";
        String user_name = "Kumar";
        int marks = 90;
        int age = 20;
        String query = "INSERT INTO student (sname,marks,age) VALUES (?,?,?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url,user,pwd);
//            Statement st = connect.createStatement();
            PreparedStatement pst = connect.prepareStatement(query);
            pst.setString(1,user_name);
            pst.setInt(2,marks);
            pst.setInt(3,age);
            int affectedRows = pst.executeUpdate();
            System.out.println(affectedRows+" row(s) affected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
