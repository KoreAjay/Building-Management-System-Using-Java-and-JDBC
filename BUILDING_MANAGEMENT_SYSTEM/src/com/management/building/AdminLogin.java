package com.management.building;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLogin extends BMS{
	
	private static final String url="jdbc:mysql://127.0.0.1:3306/building_db";
	private static final String username="root";
	private static final String password="Ajay@123";
	
	public void checkpassword() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection(url,username,password);
		 
		 Statement stmt=connection.createStatement();
		 
		 String query="SELECT * FROM Admin";
		 
		 ResultSet Rest=stmt.executeQuery(query);
		 
		 while(Rest.next())
		 {
			Scanner input=new Scanner(System.in); 
			System.out.println("╭──────────────────────────────────────────────╮");
			System.out.println("│            BMS MANAGEMENT SYSTEM             │");
			System.out.println("├──────────────────────────────────────────────┤");
			System.out.println("│         Please Login to Your Account         │");
			System.out.println("╰──────────────────────────────────────────────╯");
			
	   
			System.out.print("Enter Username : ");
			String user = input.next();

			System.out.print("Enter Password : ");
			String pass = input.next();

			 
			String username=Rest.getString("USERNAME");
			String password=Rest.getString("PASSWORD");
			 
			 
			 if(user.equals(username)&& pass.equals(password))
			 {
				 System.out.print("loading..");
				 for(int i=1;i<=4;i++)
				 {
					 Thread.sleep(500);
					 System.out.print(".");
				 }
				 System.out.print("WELCOME TO BMS MANAGEMENT SYSTEM ");

				 System.out.println();
				 
	           	 menu();

			 }
			 else
			 {
				 System.out.println("Pls Enter Correct Password..");
			 }
	      
		}
		 
		}
		catch(Exception e)
		{
			System.out.println("❌ Error: "+e.getMessage());
		}
		
		 
		}	
		
		public  void menu()
		{

			Scanner input=new Scanner(System.in);
			
		while(true) {
			System.out.println("╭──────────────────────────────────────────────╮");
			System.out.println("│              BUILDING MANAGEMENT SYSTEM      │");
			System.out.println("├──────────────────────────────────────────────┤");
			System.out.println("│ 1. Add Flat                                  │");
			System.out.println("│ 2. Add New Tenant                            │");
			System.out.println("│ 3. Add Rent Payment Details                  │");
			System.out.println("│ 4. Add Maintenance Details                   │");
			System.out.println("│ 5. View Tenant Details                       │");
			System.out.println("│ 6. View Rent Details                         │");
			System.out.println("│ 7. View Maintenance Details                  │");
			System.out.println("│ 8. View Flat Status                          │");
			System.out.println("│ 9. Update Rent Details                       │");
			System.out.println("│ 10.Delete Rent Details                       │");
			System.out.println("│ 12.Logout                                    │");
			System.out.println("╰──────────────────────────────────────────────╯");
			System.out.print("Enter your choice: ");

			int choice=input.nextInt();
			

			
			switch(choice) {
			
			case 1:
				addFlat();
				break;
			case 2:
				addNewTenent();
				break;
			case 3:
				addRentPaymentDetails();
				break;
			case 4:
				addMaintenanceDetails();
				break;
			case 5:
				viewTenetDetails();
				break;
			case 6:
				viewRentDetails();
				break;
			case 7:
				viewMaintainance(); 
				break;
			case 8:
				viewFlatStatus(); 
				break;
			case 9:
				UpdateRecords();
				break;
			case 10:
				DeleteRecords(); 
				break;
			case 11:
			

			case 12:	
				System.out.println("");
				try
				{
	                System.out.println("🔒 Logged out successfully.");
			      String greet[]={"Thank","you" ,"for","using" ,"BMS..."};
				for(int i=0;i<greet.length;i++)
				{
					Thread.sleep(200);
					System.out.print(greet[i] +" ");
				}}
				catch(Exception e) {e.printStackTrace();}			
				return;
				
			default:
				System.out.println("Plese Enter Valid Choice :");
				break;
		
			}	
			
		}
			

		}
		
		public void addFlat()
		{
			Scanner input=new Scanner(System.in);
			
			System.out.println();
			System.out.println("Enter a FlatNumber : ");
			int flatnum=input.nextInt();
			
			System.out.println("Enter a FloorNumber : ");
			int floornum=input.nextInt();
			
			System.out.println("Enter a FlatBlock : ");
			String flatblock=input.next();
			
			input.nextLine();
			
			System.out.println("Enter a FlatType : ");
			String flattype=input.nextLine();
			
			System.out.println("Enter a FlatStatus : ");
			String flatstatus=input.next();
			
			String query="INSERT INTO Flat(FlatNumber,FloorNumber,Block,Type,Status)VALUES(?,?,?,?,?)";
			try
			{
			Connection connection=DriverManager.getConnection(url,username,password);
					
			PreparedStatement pstmt=connection.prepareStatement(query);
			
			pstmt.setInt(1,flatnum);
			pstmt.setInt(2, floornum);
			pstmt.setString(3, flatblock);
			pstmt.setString(4, flattype);
			pstmt.setString(5, flatstatus);
			
			int rowsInserted=pstmt.executeUpdate();
			
			if(rowsInserted>0)
			{
				System.out.println("Flat added successfully ");
			}		
			
			}
			catch(Exception e)
			{
				System.out.println("❌ Error: "+e.getMessage());
			}
			
		}
		
		public void addNewTenent()
		{
			
			Scanner input=new Scanner(System.in);
			
			System.out.println();
			
			System.out.println("Enter Name");
			String name=input.nextLine();
			
			System.out.println("Enter ContactNumber");
			String contactnumber=input.next();
			
			System.out.println("Enter a Email ID : ");
			String email=input.nextLine();
			
			input.nextLine();
			
			System.out.println("Enter a IdProofType : ");
			String IdProofType=input.nextLine();
			
			System.out.println("Enter IdNumber :");
			String IdNumber=input.nextLine();
			
			System.out.println("Enter Rent : ");
			int rent=input.nextInt();
			
			input.nextLine();
			
			System.out.println("Enter Deposit : ");
			int deposit=input.nextInt();
			
			System.out.println("Enter Flat ID : ");
			int flatId=input.nextInt();
			
			input.nextLine();
			
			System.out.println();
			try
			{
			 String query="INSERT INTO Tenant(Name,ContactNumber,Email,IdProofType,IdNumber,Rent,Deposit,FlatID,JoinDate)VALUES(?,?,?,?,?,?,?,?,CURDATE())";

			Connection conn=DriverManager.getConnection(url,username,password);
			
			PreparedStatement pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setString(2,contactnumber);
			pstmt.setString(3,email);
			pstmt.setString(4, IdProofType);
			pstmt.setString(5, IdNumber);
			pstmt.setInt(6, rent);
			pstmt.setInt(7, deposit);
			pstmt.setInt(8, flatId);
			
			int rowsInserted=pstmt.executeUpdate();
			
			if(rowsInserted>0)
			{
				System.out.println("Tenant Record Added Successfully ");
			}
			
			}
			catch(SQLException e)
			{
				System.out.println("❌ Error: "+e.getMessage());
			}
			
			
			
		}
		public void addRentPaymentDetails()
		{
			Scanner input=new Scanner(System.in);
			System.out.println();
			
			System.out.println("Enter Tenent ID : ");
			int tenantId=input.nextInt();
			
			System.out.println("Enter Flat ID : ");
			int flatId=input.nextInt();
			
			System.out.println("Enter Rent Amount :");
			double rentamount=input.nextDouble();
			
			System.out.println("Enter Light Bill : ");
			double lightBill=input.nextDouble();
			input.nextLine();
			
			System.out.println("Enter Payment Mode : ");
			String paymentMode=input.nextLine();
			
			System.out.println("Enter TransactionId : ");
			String transactionId=input.nextLine();
			
			double totalBill=lightBill+rentamount;
			
			System.out.println("Enter Remark : ");
			String remark=input.nextLine();
			try
			{
			String query="INSERT INTO RentPayment(TenantID,FlatID,RentAmount,LightBill,PaymentDate,PaymentMode,TransactionId,TotalBill,Remark)VALUES(?,?,?,?,CURDATE(),?,?,?,?)";
			Connection conn=DriverManager.getConnection(url,username,password);
			
			PreparedStatement pstmt=conn.prepareStatement(query);
			
			pstmt.setInt(1, tenantId);
			pstmt.setInt(2, flatId);
			pstmt.setDouble(3,rentamount);
			pstmt.setDouble(4, lightBill);
			pstmt.setString(5, paymentMode);
			pstmt.setString(6, transactionId);
			pstmt.setDouble(7, totalBill);
			pstmt.setString(8, remark);
			
			int rowsInserted=pstmt.executeUpdate();
			
			if(rowsInserted>0)
			{
				System.out.println("Payment details added successfull !!");
			}


			}
			catch(SQLException e)
			{
				System.out.println("❌ Error: "+e.getMessage());
			}
		}
		
		public void addMaintenanceDetails() {
		    Scanner input = new Scanner(System.in);
		    System.out.println("\n------ Add Maintenance Details ------");
		    System.out.println();
		    
		    System.out.print("Enter Date (dd-MM-yyyy): ");
		    String date = input.nextLine();
		    

		    System.out.print("Enter Transaction Description: ");
		    String transactionDesc = input.nextLine();

		    System.out.print("Enter Amount: ");
		    double amount = input.nextDouble();
		    input.nextLine(); 

		    System.out.print("Enter Payment Mode: ");
		    String paymentMode = input.nextLine();
		    
		    System.out.print("Enter Transaction ID: ");
		    String transactionId = input.nextLine();

		    System.out.print("Enter Payment Status: ");
		    String status = input.nextLine();

		    try {
		        String query = "INSERT INTO Maintenance (Date, Description, Amount, PaymentMode,TransactionId,Status) VALUES (?, ?, ?, ?, ?, ?)";
		        Connection connection = DriverManager.getConnection(url, username, password);
		        PreparedStatement pstmt = connection.prepareStatement(query);

		        pstmt.setString(1, date);
		        pstmt.setString(2, transactionDesc);
		        pstmt.setDouble(3, amount);
		        pstmt.setString(4, paymentMode);
		        pstmt.setString(5, transactionId);
		        pstmt.setString(6, status);

		        int rowsInserted = pstmt.executeUpdate();

		        if (rowsInserted > 0) {
		            System.out.println("✔ Maintenance record added successfully!");
		        }
		    } catch (SQLException e) {
		        System.out.println("❌ Error: " + e.getMessage());
		    }
		}
		
		public void viewTenetDetails()
		{
			
			String query="SELECT * FROM Tenant ";
			try
			{
			Connection conn=DriverManager.getConnection(url,username,password);
			PreparedStatement pstmt=conn.prepareStatement(query);
			ResultSet resultset=pstmt.executeQuery();
			System.out.println("Tenant Details : ");
			System.out.println();
			System.out.println("+----------+----------------------+---------------------+---------------------------+--------------+----------------------+--------+---------+--------+------------+");
			System.out.println("| TenantID | Name                 | ContactNumber       | Email                     | IdProofType  | IdNumber             | Rent   | Deposit | FlatID | JoinDate   |");
			System.out.println("+----------+----------------------+---------------------+---------------------------+--------------+----------------------+--------+---------+--------+------------+");

			while(resultset.next()) {
			    int tenantId = resultset.getInt("TenantID");
			    String name = resultset.getString("Name");
			    String number = resultset.getString("ContactNumber");
			    String email = resultset.getString("Email");
			    String idproofType = resultset.getString("IdProofType");
			    String idNumber = resultset.getString("IdNumber");
			    int rent = resultset.getInt("Rent");
			    int deposit = resultset.getInt("Deposit");
			    int flatId = resultset.getInt("FlatID");
			    String joinDate = resultset.getString("JoinDate");

			    System.out.printf("| %-8d | %-20s | %-19s | %-25s | %-12s | %-20s | %-6d | %-7d | %-6d | %-10s |\n",
			        tenantId, name, number, email, idproofType, idNumber, rent, deposit, flatId, joinDate);
			}

			System.out.println("+----------+----------------------+---------------------+---------------------------+--------------+----------------------+--------+---------+--------+------------+");
			
			}
			catch(SQLException e)
			{
				System.out.println("❌ Error : "+e.getMessage());
			}
		}
		
		public void viewRentDetails()
		{
			
			String query = "SELECT * FROM rentpayment";
			try {
			    Connection conn = DriverManager.getConnection(url, username, password);
			    PreparedStatement psmt = conn.prepareStatement(query);
			    ResultSet rest = psmt.executeQuery();
				System.out.println("RentPayment Details : ");


			    System.out.println();
			    System.out.println("+-----------+----------+--------+------------+-----------+-------------+-------------+-------------------------+-----------+-----------------------------------------------+");
			    System.out.println("| PaymentID | TenantID | FlatID | RentAmount | LightBill | PaymentDate | PaymentMode | TransactionId           | TotalBill | Remark                                        |");
			    System.out.println("+-----------+----------+--------+------------+-----------+-------------+-------------+-------------------------+-----------+-----------------------------------------------+");

			    while (rest.next()) {
			        int paymentId = rest.getInt("PaymentID");
			        int tenantId = rest.getInt("TenantID");
			        int flatId = rest.getInt("FlatID");
			        double rentamount = rest.getDouble("RentAmount");
			        double lightbill = rest.getDouble("LightBill");
			        String paymentdate = rest.getString("PaymentDate");
			        String paymentmode = rest.getString("PaymentMode");
			        String transactionId = rest.getString("TransactionId");
			        double totalbill = rest.getDouble("TotalBill");
			        String remark = rest.getString("Remark");

			        System.out.printf("| %-9d | %-8d | %-6d | %-10.2f | %-9.2f | %-11s | %-11s | %-23s | %-9.2f | %-45s |\n",
			            paymentId, tenantId, flatId, rentamount, lightbill, paymentdate, paymentmode, transactionId, totalbill, remark);
			    }

			    System.out.println("+-----------+----------+--------+------------+-----------+-------------+-------------+-------------------------+-----------+-----------------------------------------------+");
			


			
			}
			catch(SQLException e)
			{
				System.out.println(" ❌ Error : "+e.getMessage());
				

			}
			
			
		}

		public void viewMaintainance()
		{
			
			String query = "SELECT * FROM maintenance";
			try {
			    Connection conn = DriverManager.getConnection(url, username, password);
			    PreparedStatement prped = conn.prepareStatement(query);
			    ResultSet result = prped.executeQuery();
				System.out.println("Maintenance Details : ");


			    System.out.println();
			    System.out.println("+---------------+------------+---------------------------------------------------------+---------+-------------+------------------+--------+");
			    System.out.println("| MaintenanceID | Date       | Description                                             | Amount  | PaymentMode | TransactionId    | Status |");
			    System.out.println("+---------------+------------+---------------------------------------------------------+---------+-------------+------------------+--------+");

			    while (result.next()) {
			        int maintenanceId = result.getInt("MaintenanceID");
			        String date = result.getString("Date");
			        String description = result.getString("Description");
			        double amount = result.getDouble("Amount");
			        String paymentMode = result.getString("PaymentMode");
			        String transactionId = result.getString("TransactionId");
			        String status = result.getString("Status");

			        System.out.printf("| %-13d | %-10s | %-55s | %-7.2f | %-11s | %-16s | %-6s |\n",
			                maintenanceId, date, description, amount, paymentMode, transactionId, status);
			    }

			    System.out.println("+---------------+------------+---------------------------------------------------------+---------+-------------+------------------+--------+");
		
			}
			catch(SQLException e)
			{
				System.out.println(" ❌ Error :"+e.getMessage());
			}
					
		}
		public void viewFlatStatus() {
		    String query = "SELECT * FROM Flat";
		    try {
		        Connection conn = DriverManager.getConnection(url, username, password);
		        PreparedStatement prsmt = conn.prepareStatement(query);
		        ResultSet result = prsmt.executeQuery();

		        System.out.println("Flat Details\n");

		        System.out.println("+--------+------------+-------------+-------+--------+----------+");
		        System.out.println("| FlatID | FlatNumber | FloorNumber | Block | Type   | Status   |");
		        System.out.println("+--------+------------+-------------+-------+--------+----------+");

		        while (result.next()) {
		            int flatId = result.getInt("FlatID");
		            int flatNumber = result.getInt("FlatNumber");
		            int floorNumber = result.getInt("FloorNumber");
		            String block = result.getString("Block");
		            String type = result.getString("Type");
		            String status = result.getString("Status");

		            System.out.printf("| %-6d | %-10d | %-11d | %-5s | %-6s | %-8s |\n",
		                    flatId, flatNumber, floorNumber, block, type, status);
		        }

		        System.out.println("+--------+------------+-------------+-------+--------+----------+");
		    } catch (SQLException e) {
		        System.out.println("Error: " + e.getMessage());
		    }
		}

		public void UpdateRecords()
		{
			Scanner input = new Scanner(System.in);
			System.out.println("_____________________________");
			System.out.println("|1. Update Tenant name       |");
			System.out.println("|                            |");
			System.out.println("|2. Update Flat Status       |");
			System.out.println("|____________________________|");
			System.out.println();
			System.out.println("Enter your choice:");

			int choice = input.nextInt();
			input.nextLine(); // consume newline

			if (choice == 1) {
			    try {
			        System.out.print("Enter new name: ");
			        String newname = input.nextLine();

			        System.out.print("Enter Tenant ID to update: ");
			        int tenantId = input.nextInt();

			        String query = "UPDATE Tenant SET name = ? WHERE TenantID = ?";

			        Connection conn = DriverManager.getConnection(url, username, password);
			        PreparedStatement psmt = conn.prepareStatement(query);
			        psmt.setString(1, newname);
			        psmt.setInt(2, tenantId);

			        int rowsUpdated = psmt.executeUpdate();
			        if (rowsUpdated > 0) {
			            System.out.println("✅ Tenant name updated successfully!");
			        } else {
			            System.out.println("⚠️ No tenant found with that ID.");
			        }
			        conn.close();
			    } catch (Exception e) {
			        System.out.println("❌ Error: " + e.getMessage());
			    }

			} else if (choice == 2) {
			    try {
			        System.out.print("Enter new status: ");
			        String newstatus = input.nextLine();

			        System.out.print("Enter Flat ID to update: ");
			        int flatId = input.nextInt();

			        String query = "UPDATE Flat SET Status = ? WHERE FlatID = ?";

			        Connection conn = DriverManager.getConnection(url, username, password);
			        PreparedStatement psmt = conn.prepareStatement(query);
			        psmt.setString(1, newstatus);
			        psmt.setInt(2, flatId);

			        int rowsUpdated = psmt.executeUpdate();
			        if (rowsUpdated > 0) {
			            System.out.println("✅ Flat status updated successfully!");
			        } else {
			            System.out.println("⚠️ No flat found with that ID.");
			        }
			        conn.close();
			    } catch (Exception e) {
			        System.out.println("❌ Error: " + e.getMessage());
			    }
			    

			}
			else if (choice == 3) {
			    try {
			        System.out.print("Enter new status: ");
			        String newstatus = input.nextLine();

			        System.out.print("Enter Maintenance ID to update: ");
			        int maintenanceID = input.nextInt();

			        String query = "UPDATE maintenance SET Status = ? WHERE MaintenanceID = ?";

			        Connection conn = DriverManager.getConnection(url, username, password);
			        PreparedStatement psmt = conn.prepareStatement(query);
			        psmt.setString(1, newstatus);
			        psmt.setInt(2, maintenanceID);

			        int rowsUpdated = psmt.executeUpdate();
			        if (rowsUpdated > 0) {
			            System.out.println("✅ Flat status updated successfully!");
			        } else {
			            System.out.println("⚠️ No flat found with that ID.");
			        }
			        conn.close();
			    } catch (Exception e) {
			        System.out.println("❌ Error: " + e.getMessage());
			    }
			}
			else if (choice == 4) {
			    try {
			        System.out.print("Update RentPayment Remark: ");
			        String newremark = input.nextLine();

			        System.out.print("Enter Maintenance ID to update: ");
			        int flatId = input.nextInt();

			        String query = "UPDATE rentpayment SET Remark = ? WHERE FlatID = ?";

			        Connection conn = DriverManager.getConnection(url, username, password);
			        PreparedStatement psmt = conn.prepareStatement(query);
			        psmt.setString(1, newremark);
			        psmt.setInt(2, flatId);

			        int rowsUpdated = psmt.executeUpdate();
			        if (rowsUpdated > 0) {
			            System.out.println("✅ Flat status updated successfully!");
			        } else {
			            System.out.println("⚠️ No flat found with that ID.");
			        }
			        conn.close();
			    } catch (Exception e) {
			        System.out.println("❌ Error: " + e.getMessage());
			    }
			}
			else {
			    System.out.println("❗ Invalid choice.");
			}
			
		}
		
		public void DeleteRecords()
		{
			Scanner input=new Scanner(System.in);
			System.out.println("|-----------------------------------|");
			System.out.println("|1.Delete Flat Record :             |");
			System.out.println("|2.Delete Tenant Record :           |");
			System.out.println("|3.Delete Maintenance Record :      |");
			System.out.println("|4.Delete RentPayment Record :      |");
			System.out.println("|-----------------------------------|");
			System.out.println();
			System.out.println("|___________________________________|");
			System.out.println("|Enter your Choice   :              |");
			
			int choice=input.nextInt();

			if(choice==1)
			{
				try
				{
					System.out.println("Enter flat Id to Delete");
					int flatid=input.nextInt();
					
					String query="DELETE FROM Flat where FlatId=?";
					
					Connection conn=DriverManager.getConnection(url,username,password);
					PreparedStatement pstmt=conn.prepareStatement(query);
					pstmt.setInt(1,flatid);
					int rowsDeleted=pstmt.executeUpdate();
					
					if(rowsDeleted>0)
					{
						System.out.println("Flat Deleted Successfully !!");
					}
					else {
						System.out.println("This flat Id Does' not exist !!");
					}
					
				}
			catch(Exception e)
				{
				System.out.println("❌ Error :"+e.getMessage());
				}
				
			}
			else if(choice==2)
			{
				try {
				    System.out.println("Enter Tenant Id to Delete:");
				    int tenantId = input.nextInt();

				    String query = "DELETE FROM Tenant WHERE TenantID = ?";

				    Connection conn = DriverManager.getConnection(url, username, password);
				    PreparedStatement pstmt = conn.prepareStatement(query);
				    pstmt.setInt(1, tenantId);

				    int rowsDeleted = pstmt.executeUpdate();

				    if (rowsDeleted > 0) {
				        System.out.println("✅ Tenant Record Deleted Successfully!");
				    } else {
				        System.out.println("⚠️ This Tenant ID does not exist.");
				    }

				} catch (SQLException e) {
				    System.out.println("❌ Error: " + e.getMessage());
				}

			}
			else if(choice==3)
			{
				try {
				    System.out.println("Enter Maintenance Id to Delete:");
				    int maintenanceId = input.nextInt();

				    String query = "DELETE FROM maintenance WHERE MaintenanceID = ?";

				    Connection conn = DriverManager.getConnection(url, username, password);
				    PreparedStatement pstmt = conn.prepareStatement(query);
				    pstmt.setInt(1, maintenanceId);

				    int rowsDeleted = pstmt.executeUpdate();

				    if (rowsDeleted > 0) {
				        System.out.println("✅ Maintenance Record Deleted Successfully!");
				    } else {
				        System.out.println("⚠️ This Maintenance ID does not exist.");
				    }

				} catch (SQLException e) {
				    System.out.println("❌ Error: " + e.getMessage());
				}	
			}
			else if(choice==4)
			{
				try {
				    System.out.println("Enter Rentpayment Id to Delete:");
				    int tenantId = input.nextInt();

				    String query = "DELETE FROM rentpayment WHERE TenantID = ?";

				    Connection conn = DriverManager.getConnection(url, username, password);
				    PreparedStatement pstmt = conn.prepareStatement(query);
				    pstmt.setInt(1, tenantId);

				    int rowsDeleted = pstmt.executeUpdate();

				    if (rowsDeleted > 0) {
				        System.out.println("✅ Rentpayment Record Deleted Successfully!");
				    } else {
				        System.out.println("⚠️ This TenantID ID does not exist.");
				    }

				} catch (SQLException e) {
				    System.out.println("❌ Error: " + e.getMessage());
				}
			}
			else	
			{
				System.out.println("❗ Invalid choice.");
			}
			
			
		}

	

}
