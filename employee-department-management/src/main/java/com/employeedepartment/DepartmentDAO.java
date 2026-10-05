package com.employeedepartment;

import com.employeedepartment.entity.Department;
import com.employeedepartment.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DepartmentDAO {

    // Add department
    public void addDepartment(Department department) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(department);
            em.getTransaction().commit();

            System.out.println("Department added successfully.");
        } finally {
            em.close();
        }
    }

    // Find department by ID
    public Department findDepartment(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Department.class, id);
        } finally {
            em.close();
        }
    }

    // Display departments with their employees using JPQL
    public void displayDepartments() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Department> query = em.createQuery(
                    "SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees",
                    Department.class
            );

            List<Department> departments = query.getResultList();

            for (Department department : departments) {
                System.out.println("Department: " + department.getName());

                for (Employee employee : department.getEmployees()) {
                    System.out.println("  Employee: " +
                            employee.getName() +
                            " | Salary: " +
                            employee.getSalary());
                }
            }
        } finally {
            em.close();
        }
    }
}