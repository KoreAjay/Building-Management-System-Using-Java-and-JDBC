# 🏢 Building Management System –Using-Java-and-JDBC
# Building Management Made Easy and Smart Resident & Rent Tracker

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

 create database building_db;
  use building_db;
  
  CREATE TABLE Admin(
    -> ID INT AUTO_INCREMENT PRIMARY KEY,
    -> USERNAME VARCHAR(20),
    -> PASSWORD VARCHAR(10)
    -> );
	
	CREATE TABLE Flat(
    -> FlatID INT AUTO_INCREMENT PRIMARY KEY,
    -> FlatNumber VARCHAR(10) NOT NULL,
    -> FloorNumber INT,
    -> Block VARCHAR(10),
    -> Type VARCHAR(50),
    -> Status VARCHAR(20)
    -> );
	
	CREATE TABLE Tenant (
    TenantID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    ContactNumber VARCHAR(15) NOT NULL,
    Email VARCHAR(100),
    IdProofType VARCHAR(20),
    IdNumber VARCHAR(30),
    Rent INT NOT NULL,
    Deposit INT DEFAULT 0,
    FlatID INT NOT NULL,
    JoinDate DATE,
    
    FOREIGN KEY (FlatID) REFERENCES Flat(FlatID)
);

CREATE TABLE RentPayment (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT,
    TenantID INT,
    FlatID INT,
    RentAmount DECIMAL(10, 2),
    LightBill DECIMAL(10, 2),
    PaymentDate DATE,
    PaymentMode VARCHAR(50),
    TransactionId VARCHAR(50),
    TotalBill DECIMAL(10, 2),
    Remarks VARCHAR(200),

    FOREIGN KEY (TenantID) REFERENCES Tenant(TenantID),
    FOREIGN KEY (FlatID) REFERENCES Flat(FlatID)
);

CREATE TABLE Maintenance (
    MaintenanceID INT PRIMARY KEY AUTO_INCREMENT,
    Date VARCHAR(20), 
    Description VARCHAR(200),
    Amount DECIMAL(10, 2),
    PaymentMode VARCHAR(20),
    TransactionId VARCHAR(50),
    Status VARCHAR(15)
);




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

