
import java.util.ArrayList;
import java.util.List;

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

public class EmployeeCRUD {
    private List<Employee> employees = new ArrayList<>();

    // Create
    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added: " + emp);
    }

    // Read
    public void listEmployees() {
        System.out.println("Employee List:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println();
    }

    // Update
    public void updateEmployee(int id, String newName, String newDept) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(newName);
                emp.setDepartment(newDept);
                System.out.println("Employee updated: " + emp);
                return;
            }
        }
        System.out.println("Employee not found with ID: " + id);
    }

    // Delete
    public void deleteEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee removed: " + emp);
                return;
            }
        }
        System.out.println("Employee not found with ID: " + id);
    }

    // Main method to test
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Create
        crud.addEmployee(new Employee(1, "Omkar", "IT"));
        crud.addEmployee(new Employee(2, "John", "HR"));

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
