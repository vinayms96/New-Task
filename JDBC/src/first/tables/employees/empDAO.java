package first.tables.employees;

import first.connectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class empDAO{
    public void dataBase(employee emp){
        String query = "INSERT INTO employees (lastname,firstname,email,department,salary) VALUES (?,?,?,?,?)";
        String selectQuery = "SELECT * FROM employees";
        Connection connect = connectDB.getConnect();
        try {
            PreparedStatement pst = connect.prepareStatement(query);
            pst.setString(1,emp.lastName);
            pst.setString(2,emp.firstName);
            pst.setString(3,emp.email);
            pst.setString(4,emp.dept);
            pst.setInt(5,emp.salary);
            pst.executeUpdate();

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);
            rs.next();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

