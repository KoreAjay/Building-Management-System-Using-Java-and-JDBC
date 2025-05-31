# Building-Management-System-Using-Java-and-JDBC
Building Management System
# Building Management Made Easy and Smart Resident & Rent Tracker

# 🏢 Building Management System – Java Console Application

## 🔷 Description

The **Building Management System** is a Java-based console application that allows you to manage flats, tenants, rent, and maintenance records. It connects to a MySQL database using JDBC and provides a user-friendly text interface for various operations.

---

## 🛠️ Technologies Used

* Java (Core + JDBC)
* MySQL Database
* Eclipse IDE / IntelliJ
* Git & GitHub

---

## ✅ Key Features

1. **Add Flat** – Input flat number, floor number, block, type, and status.
2. **Add Tenant** – Register a new tenant with a corresponding flat ID.
3. **Rent Management** – Add, update, and delete rent records.
4. **Maintenance Management** – Add monthly maintenance details.
5. **View Tenant Details** – Display all tenants.
6. **View Rent Details** – List all rent records.
7. **View Maintenance Details** – Show maintenance records.
8. **Flat Status Viewer** – Display the availability and occupancy status.
9. **Update Functions** – Modify tenant name, rent details, flat status.
10. **Delete Functions** – Remove rent or tenant records.
11. **Tenant Login & Password Management**

    * Secure tenant login
    * Lock for 2 minutes after 3 incorrect attempts
    * Password reset options
12. **Interactive Console Menu** – Easy-to-navigate options for admins.

---

## 📂 Project Structure

---

## 🔑 Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/building-management-system.git
   cd building-management-system
   ```

2. **Set Up MySQL Database**

   * Create a database named `buildingdb`
   * Run the script in `SQL/database_schema.sql` to create required tables

3. **Configure DB Credentials**

   * In each Java file with a DB connection, update:

     ```java
     String url = "jdbc:mysql://localhost:3306/buildingdb";
     String username = "root";
     String password = "yourpassword";
     ```

4. **Run the Application**


## 📸 Screenshots




Feel free to fork, improve, and contribute to the project. Pull requests are welcome!

