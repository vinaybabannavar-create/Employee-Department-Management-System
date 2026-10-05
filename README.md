# Employee-Department-Management-System

## Employee–Department Management System

A Java-based Employee–Department Management System developed using **Plain JPA, Hibernate, MySQL, and Maven**.

The application demonstrates a **bidirectional One-to-Many / Many-to-One relationship** between departments and employees using JPA annotations and provides CRUD and update operations through a console-based menu.

---

## 1. Project Overview

The Employee–Department Management System is a console-based Java application designed to manage departments and employees.

The system allows users to:

- Add departments
- Add employees
- Assign employees to departments
- Display employees with their departments
- Display departments with their employees
- Update an employee's department
- Update employee details
- Merge employee entities
- Delete employees
- Store and retrieve data using MySQL
- Perform database operations using JPA and Hibernate

---

## 2. Technologies Used

| Technology | Purpose |
|------------|---------|
| Java 17 | Application development |
| Maven | Project and dependency management |
| JPA | Persistence API |
| Hibernate | JPA implementation / ORM |
| MySQL | Database |
| Jakarta Persistence | JPA annotations and APIs |
| JPQL | Database query operations |
| VS Code | Development environment |

---

## 3. Project Structure

```text
employee-department-management/
│
├── pom.xml
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── employeedepartment/
│   │   │           ├── App.java
│   │   │           ├── DepartmentDAO.java
│   │   │           ├── EmployeeDAO.java
│   │   │           ├── JPAUtil.java
│   │   │           │
│   │   │           └── entity/
│   │   │               ├── Department.java
│   │   │               └── Employee.java
│   │   │
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── employeedepartment/
│                   └── AppTest.java
│
└── README.md
