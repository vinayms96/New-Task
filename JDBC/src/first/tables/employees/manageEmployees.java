package first.tables.employees;

import java.util.Scanner;

public class manageEmployees {
    public static void main(String[] args){
        employee emp = new employee();
        empDAO empdao = new empDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("Save Employee Data to DB");
        System.out.println("Enter the following details:\n");

        System.out.println("Enter the FirstName: "); emp.firstName = sc.next();
        System.out.println("\nEnter the LastName: ");emp.lastName = sc.next();
        System.out.println("\nEnter the Email Id: ");emp.email = sc.next();
        System.out.println("\nEnter the Department: ");emp.dept = sc.next();
        System.out.println("\nEnter the Salary: ");emp.salary = sc.nextInt();

        empdao.dataBase(emp);
    }
}
