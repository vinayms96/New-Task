package database;

import java.sql.*;

public class getUser {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/first";
        String user = "root";
        String pwd = "acernsrc";
        String query = "SELECT sname FROM student WHERE rollno=1";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url,user,pwd);
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String username = rs.getString("sname");
            System.out.println(username);
            st.close();rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
