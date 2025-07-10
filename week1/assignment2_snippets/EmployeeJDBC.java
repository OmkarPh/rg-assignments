
import java.sql.*;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String toString() {
        return "Employee { id=" + id + ", name='" + name + "', department='" + department + "' }";
    }
}

public class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/tmpcompany";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    // Create (Insert)
    public void addEmployee(int id, String name, String department) {
        String query = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            System.out.println("Employee added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Select)
    public void listEmployees() {
        String query = "SELECT * FROM employees";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Employee List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Department: " + rs.getString("department"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update
    public void updateEmployee(int id, String newName, String newDepartment) {
        String query = "UPDATE employees SET name = ?, department = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newName);
            pstmt.setString(2, newDepartment);
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        EmployeeJDBC crud = new EmployeeJDBC();

        // Create
        crud.addEmployee(1, "Omkar", "IT");
        crud.addEmployee(2, "John", "HR");

        // Read
        crud.listEmployees();

        // Update
        crud.updateEmployee(1, "Omkar Phansopkar", "Engineering");
        crud.listEmployees();

        // Delete
        crud.deleteEmployee(2);
        crud.listEmployees();
    }
}
