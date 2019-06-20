package demo.tables.employees;

import demo.connectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class empDAO{
    public void dataBase(employee emp){
        String query = "INSERT INTO employees (last_name,first_name,email,department,salary) VALUES (?,?,?,?,?)";
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
            System.out.println("\n Employee Data saved to Database.\n\n");

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);
            while(rs.next()){
                String res = rs.getInt(1)+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getString(4)+" , "+rs.getString(5)+" , "+rs.getInt(6);
                System.out.println(res);
            }
            rs.close();connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

