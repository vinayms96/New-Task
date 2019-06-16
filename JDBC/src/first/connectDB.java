package first;
import java.sql.*;

public class connectDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","acernsrc");
            System.out.println("Connected to Database!");
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
