package com.employeedepartment;

import com.employeedepartment.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeDAO {

    // Add employee
    public void addEmployee(Employee employee) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();

            System.out.println("Employee added successfully.");
        } finally {
            em.close();
        }
    }

    // Find employee by ID
    public Employee findEmployee(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }
    }

    // Display all employees with their departments
    public void displayEmployees() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Employee> query = em.createQuery(
                    "SELECT e FROM Employee e JOIN FETCH e.department",
                    Employee.class
            );

            List<Employee> employees = query.getResultList();

            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } finally {
            em.close();
        }
    }

    // Update employee department
    public void updateEmployeeDepartment(Long employeeId, Long departmentId) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Employee employee = em.find(Employee.class, employeeId);

            if (employee != null) {
                var department = em.find(
                        com.employeedepartment.entity.Department.class,
                        departmentId
                );

                if (department != null) {
                    employee.setDepartment(department);
                    System.out.println("Employee department updated.");
                } else {
                    System.out.println("Department not found.");
                }
            } else {
                System.out.println("Employee not found.");
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Update employee details
    public void updateEmployee(Long id, String name, double salary) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Employee employee = em.find(Employee.class, id);

            if (employee != null) {
                employee.setName(name);
                employee.setSalary(salary);
                System.out.println("Employee details updated.");
            } else {
                System.out.println("Employee not found.");
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Employee employee = em.find(Employee.class, id);

            if (employee != null) {
                em.remove(employee);
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found.");
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    // Merge employee
public void mergeEmployee(Employee employee) {
    EntityManager em = JPAUtil.getEntityManager();

    try {
        em.getTransaction().begin();

        em.merge(employee);

        em.getTransaction().commit();

        System.out.println("Employee merged successfully.");
    } finally {
        em.close();
    }
}

}

