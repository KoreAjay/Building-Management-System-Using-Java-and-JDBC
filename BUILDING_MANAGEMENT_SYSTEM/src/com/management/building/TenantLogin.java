package com.management.building;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TenantLogin {

    static final String url = "jdbc:mysql://localhost:3306/building_db";
    static final String username = "root";
    static final String password = "Ajay@123";

    int tenantId; 

    public void loginTenant() {
        Scanner input = new Scanner(System.in);

        System.out.println("╭──────────────────────────────────────────────╮");
        System.out.println("│            BMS MANAGEMENT SYSTEM             │");
        System.out.println("├──────────────────────────────────────────────┤");
        System.out.println("│         Tenant Login                         │");
        System.out.println("│----------------------------------------------│");
        System.out.println("│         Please Login to Your Account         │");
        System.out.println("╰──────────────────────────────────────────────╯");
        System.out.println();

        System.out.print("Enter TenantID: ");
        int uname = input.nextInt();
        input.nextLine();
        System.out.print("Enter ContactNumber: ");
        String upass = input.nextLine();

        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT TenantID, ContactNumber FROM tenant WHERE TenantID = ? AND ContactNumber = ?"
            )
        ) {
            pstmt.setInt(1, uname);
            pstmt.setString(2, upass);
            ResultSet rest = pstmt.executeQuery();

            if (rest.next()) {
                tenantId = rest.getInt("TenantID");
                System.out.println("✅ Login Successful!\n");
                menu();
            } else {
                System.out.println("❌ Invalid TenantID or ContactNumber. Please try again.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n╭─────────────── Menu ────────────────────────── ╮");
            System.out.println("│ 1. Check my Rent Record             │");
            System.out.println("│ 2. Check my Profile                 │");
            System.out.println("│ 3. Logout                           │");
            System.out.println("╰────────────────────────────────────╯");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    checkmyRentDetails();
                    break;
                case 2:
                    checkmyProfile();
                    break;
                case 3:
                    System.out.println("🔒 Logged out successfully.");
                    return;
                default:
                    System.out.println("❌ Invalid Choice. Please try again.");
            }
        }
    }

    public void checkmyRentDetails() {
        System.out.println("\n📄 Fetching rent details...\n");

        String query = "SELECT TenantID, FlatID, RentAmount, LightBill, PaymentDate, PaymentMode, TransactionId, TotalBill FROM rentpayment WHERE TenantID = ?";
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setInt(1, tenantId);
            ResultSet rest = pstmt.executeQuery();

            System.out.println("+----------+--------+------------+------------+--------------+-------------+------------------------+--------------+");
            System.out.println("| TenantID | FlatID | RentAmount | LightBill  | PaymentDate  | PaymentMode | TransactionId          | TotalBill    |");
            System.out.println("+----------+--------+------------+------------+--------------+-------------+------------------------+--------------+");

            boolean hasRecords = false;
            while (rest.next()) {
                hasRecords = true;
                int tId = rest.getInt("TenantID");
                int flatId = rest.getInt("FlatID");
                double rent = rest.getDouble("RentAmount");
                double lightbill = rest.getDouble("LightBill");
                String date = rest.getString("PaymentDate");
                String paymentmode = rest.getString("PaymentMode");
                String transactionid = rest.getString("TransactionId");
                double totalbill = rest.getDouble("TotalBill");

                System.out.printf("| %-8d | %-6d | %-10.2f | %-10.2f | %-12s | %-11s | %-20s | %-12.2f |\n",
                    tId, flatId, rent, lightbill, date, paymentmode, transactionid, totalbill);
            }

            if (!hasRecords) {
                System.out.println("|                           No rent records found.                           |");
            }

            System.out.println("+----------+--------+------------+------------+--------------+-------------+------------------------+--------------+");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void checkmyProfile() {
        System.out.println("\n📄 Fetching profile...\n");

        String query = "SELECT * FROM tenant WHERE TenantID = ?";
        try (
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            pstmt.setInt(1, tenantId);
            ResultSet rest = pstmt.executeQuery();

            if (rest.next()) {
                System.out.println("╭──────────────────────────────╮");
                System.out.println("│         Tenant Profile       │");
                System.out.println("├──────────────────────────────┤");
                System.out.println(" Tenant ID     : " + rest.getInt("TenantID"));
                System.out.println(" Name          : " + rest.getString("Name"));
                System.out.println(" Contact Number: " + rest.getString("ContactNumber"));
                System.out.println(" Email         : " + rest.getString("Email"));
                System.out.println(" Rent          : " + rest.getDouble("Rent"));
                System.out.println(" Deposit       : " + rest.getDouble("Deposit"));
                System.out.println(" Booked Date   : " + rest.getString("JoinDate"));
                System.out.println("╰──────────────────────────────╯");
            } else {
                System.out.println("❌ No profile found.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
