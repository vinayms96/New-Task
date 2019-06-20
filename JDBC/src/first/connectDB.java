package first;
import java.sql.*;

public class connectDB {
    public  static Connection connect;
    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","acernsrc");
            System.out.println("Connected to Database!");
//            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
    return connect;
    }
}
