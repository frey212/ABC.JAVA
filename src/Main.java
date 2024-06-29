import java.util.*;

class Employee {
    private int employeeId;
    private String name;
    private String gender;
    private int phoneNumber;

    public Employee(int employeeId, String name, String gender, int phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public void setEmployeeId(int newID) {
        this.employeeId = newID;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPhoneNumber(int newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Gender: " + gender + ", Phone: " + phoneNumber;
    }
}

class EmployeeScheduler {
    private Map<Integer, Employee> employees;

    public EmployeeScheduler() {
        this.employees = new HashMap<>();
    }

    public void addEmployee(int employeeId, String name, int phoneNumber) {
        System.out.print("please enter gender (Male/Female): ");
        Scanner scanner = new Scanner(System.in);
        String gender = scanner.next();
        Employee employee = new Employee(employeeId, name, gender, phoneNumber);
        employees.put(employeeId, employee);
    }

    public Employee getEmployee(int employeeId) {
        return employees.get(employeeId);
    }

    public void displayAllEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);
        }
    }

    public void updateEmployee(int employeeId, int newID, String newName, String newGender, int newPhoneNumber) {
        Employee employee = getEmployee(employeeId);
        if (employee != null) {
            employee.setEmployeeId(newID);
            employee.setName(newName);
            employee.setPhoneNumber(newPhoneNumber);
            employee.setGender(newGender);
            System.out.println("successfully updated.");
        } else {
            System.out.println("Can't found this employee.");
        }
    }

    public void deleteEmployee(int employeeId) {
        Employee employee = getEmployee(employeeId);
        if (employee != null) {
            employees.remove(employeeId);
            System.out.println("successfully removed.");
        } else {
            System.out.println("Can't not found this employee");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeScheduler scheduler = new EmployeeScheduler();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add new Employee");
            System.out.println("2. Show All Employe");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.print("Please enter the number: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Add other employee
                    System.out.println("Please enter employee details: ");
                    System.out.print("Employee_ID:");
                    int employee_Id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Employee_Name:");
                    String name = scanner.nextLine();
                    System.out.print("Employee_Phone:");
                    int phoneNumber = scanner.nextInt();
                    scheduler.addEmployee(employee_Id, name, phoneNumber);
                    break;

                case 2:
                    // Show all employees
                    scheduler.displayAllEmployees();
                    break;

                case 3:
                    // Update employee
                    System.out.print("Please enter employee ID to update: ");
                    int update_Emp_Id = scanner.nextInt();
                    System.out.print("please enter new id: ");
                    int update_Emp_ID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Please enter employee new name: ");
                    String update_Emp_Name = scanner.nextLine();
                    System.out.print("please enter employee new gender: ");
                    String update_Emp_Gen = scanner.next();
                    System.out.print("please enter employee new phone number: ");
                    int update_Emp_Phone = scanner.nextInt();
                    scheduler.updateEmployee(update_Emp_Id, update_Emp_ID, update_Emp_Name , update_Emp_Gen, update_Emp_Phone);
                    break;

                case 4:
                    // Delete employee
                    System.out.print("please enter employee ID to delete: ");
                    int delete_Emp_Id = scanner.nextInt();
                    scheduler.deleteEmployee(delete_Emp_Id);
                    break;
                default:
                    System.out.println(" Please try again.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }
}
