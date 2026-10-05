package com.employeedepartment;

import com.employeedepartment.entity.Department;
import com.employeedepartment.entity.Employee;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDAO departmentDAO = new DepartmentDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" EMPLOYEE-DEPARTMENT MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Add Department");
            System.out.println("2. Add Employee");
            System.out.println("3. Display Employees with Department");
            System.out.println("4. Display Departments with Employees");
            System.out.println("5. Update Employee Department");
            System.out.println("6. Update Employee Details");
            System.out.println("7. Delete Employee");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter department name: ");
                    String departmentName = sc.nextLine();

                    Department department = new Department(departmentName);
                    departmentDAO.addDepartment(department);
                    break;

                case 2:
                    sc.nextLine();

                    System.out.print("Enter employee name: ");
                    String employeeName = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("Enter department ID: ");
                    long departmentId = sc.nextLong();

                    Department empDepartment =
                            departmentDAO.findDepartment(departmentId);

                    if (empDepartment != null) {
                        Employee employee =
                                new Employee(employeeName, salary);

                        employee.setDepartment(empDepartment);

                        employeeDAO.addEmployee(employee);
                    } else {
                        System.out.println("Department not found.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Employees with Departments ---");
                    employeeDAO.displayEmployees();
                    break;

                case 4:
                    System.out.println("\n--- Departments with Employees ---");
                    departmentDAO.displayDepartments();
                    break;

                case 5:
                    System.out.print("Enter employee ID: ");
                    long employeeId = sc.nextLong();

                    System.out.print("Enter new department ID: ");
                    long newDepartmentId = sc.nextLong();

                    employeeDAO.updateEmployeeDepartment(
                            employeeId,
                            newDepartmentId
                    );
                    break;

                case 6:
                    sc.nextLine();

                    System.out.print("Enter employee ID: ");
                    long updateId = sc.nextLong();

                    sc.nextLine();

                    System.out.print("Enter new employee name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();

                    employeeDAO.updateEmployee(
                            updateId,
                            newName,
                            newSalary
                    );
                    break;

                case 7:
                    System.out.print("Enter employee ID to delete: ");
                    long deleteId = sc.nextLong();

                    employeeDAO.deleteEmployee(deleteId);
                    break;

                case 8:
                    System.out.println("Exiting application...");
                    JPAUtil.close();
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}