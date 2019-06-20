package database;

import java.sql.*;
public class db {
    /*
    * 1. Import
    * 2. Load and Register -->  mysql driver(com.mysql.jdbc.Driver)
    * 3. Create Connection
    * 4. Create a Statement
    * 5. Execute the Query
    * 6. Process the Results
    * 7. Close
    * */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/first";
        String user = "root";
        String pwd = "acernsrc";
        String query = "SELECT * FROM student";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url,user,pwd);
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                String Userdata = rs.getInt(1) + "," + rs.getString(2)+","+rs.getInt(3)+","+rs.getString(4);
                System.out.println(Userdata);
            }
            st.close();connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
