# Employee–Department Management System

A console-based Java application for managing employees and departments using **JPA, Hibernate, MySQL, and Maven**.

## 🛠️ Technologies Used

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate)
![JPA](https://img.shields.io/badge/JPA-Jakarta%20Persistence-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven)
![VS Code](https://img.shields.io/badge/VS%20Code-Editor-007ACC?style=for-the-badge&logo=visualstudiocode)

## ✨ Features

- Add departments
- Add employees
- Assign employees to departments
- Display employees with departments
- Display departments with employees
- Update employee department
- Update employee details
- Merge employee
- Delete employee
- MySQL database integration

## 🔗 JPA Relationship

The project uses a **bidirectional One-to-Many / Many-to-One relationship**.

```text
Department
    │
    │ One-to-Many
    ▼
Employee
    │
    │ Many-to-One
    ▼
Department

Department
@OneToMany(mappedBy = "department")
private List<Employee> employees;

Employee
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;

📂 Project Structure
src/
├── main/
│   ├── java/
│   │   └── com/employeedepartment/
│   │       ├── App.java
│   │       ├── DepartmentDAO.java
│   │       ├── EmployeeDAO.java
│   │       ├── JPAUtil.java
│   │       └── entity/
│   │           ├── Department.java
│   │           └── Employee.java
│   │
│   └── resources/
│       └── META-INF/
│           └── persistence.xml
│
└── test/
    └── java/
        └── com/employeedepartment/
            └── AppTest.java

pom.xml
README.md

🗄️ Database
Database:
EMPLOYEE_DB

Tables:
departments
employees

The employees.department_id column is the foreign key connecting employees with departments.
▶️ Run the Project
1. Clone Repository
git clone https://github.com/vinaybabannavar-create/Employee-Department-Management-System.git

2. Open Project
cd Employee-Department-Management-System

3. Compile
mvn clean compile

4. Run
mvn exec:java "-Dexec.mainClass=com.employeedepartment.App"

📋 Application Menu
1. Add Department
2. Add Employee
3. Display Employees with Department
4. Display Departments with Employees
5. Update Employee Department
6. Update Employee Details
7. Delete Employee
8. Exit

🔧 JPA Operations Used
- persist() – Insert data
- find() – Retrieve data
- merge() – Update/merge entity state
- remove() – Delete data
- createQuery() – Execute JPQL queries
👨‍💻 Author
VINAY BABANNAVAR
AF ID: AF04997689
Batch Code: ANP-D6741
🔗 GitHub
Employee–Department Management System
