package com.management.building;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BMS extends TenantLogin {
	
	public void Login()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("╭──────────────────────────────────────────────╮");
		System.out.println("│            BMS MANAGEMENT SYSTEM             │");
		System.out.println("├──────────────────────────────────────────────┤");
		System.out.println("│         Please Login to Your Account         │");
		System.out.println("╰──────────────────────────────────────────────╯");
		System.out.println();
		System.out.println("__________________________________________");
		System.out.println("| 1.Admin Login                           |");                        
		System.out.println("|                                         |");
		System.out.println("| 2.Tenant Login                          |");
		System.out.println("|_________________________________________|");

		System.out.println();
		System.out.println("Enter Your Choice ");
		int choice=input.nextInt();
		 
		if(choice==1)
		{
			AdminLogin admin=new AdminLogin();
			admin.checkpassword() ;
		}
		else if(choice==2)
		{
            TenantLogin tenant = new TenantLogin();
            tenant.loginTenant();
		}
	}

}

	

		


