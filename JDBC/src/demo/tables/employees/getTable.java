package demo.tables.employees;

import java.sql.*;

public class getTable {
    public static void main(String[] args) {
        String query = "SELECT * FROM employees";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","acernsrc");
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                String res = rs.getInt(1)+" , "+rs.getString(2) + " , " + rs.getString(3) + " , " + rs.getString(4) + " , " + rs.getString(5) + " , " + rs.getInt(6);
                System.out.println(res);
            }
            rs.close();connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
