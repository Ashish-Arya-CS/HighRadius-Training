package com.highradius.jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class infinitywar {
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost/infinity_war";
		// Database credentials
		static final String USER = "root";
		static final String PASS = "LAZY!@bolt9";
		public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
		//STEP 2: Register JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//STEP 3: Open a connection
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		//STEP 4: Execute a query
		stmt = conn.createStatement();
		String sql;
		int flag = 0;
		// Taking a while loop so that we can fetch and display data until the user wants to exit
		while (flag != 1) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to Fetch And Display Whole Table Data \nEnter 2 to Fetch Alias, Quote Column Data using Serial\n 0 to exit.\n");
		int choice1 = sc.nextInt();
		// Taking Switch-Case for executing menu driven program
		switch(choice1) {
		// Displaying the entire table at once.
		case 1:
			sql = "SELECT * FROM infinity";
			ResultSet rs = stmt.executeQuery(sql);
			//Creating an ArrayList object
			ArrayList<InfinityPOJO> infinityList = new ArrayList<>();
			//STEP 5: Extract data from result set
			while(rs.next()){
			//Retrieve by column name
	     	InfinityPOJO obj = new InfinityPOJO();
			obj.setFirst(rs.getString("First_Name"));
			obj.setLast(rs.getString("Last_Name"));
			obj.setId(rs.getInt("Serial"));
			obj.setAlias(rs.getString("Alias"));
			obj.setQuote(rs.getString("Quote"));
			infinityList.add(obj);
			}
			//Display values
			for (InfinityPOJO obj1 : infinityList) {
				System.out.print("First_Name: "+obj1.getFirst()+", ");
				System.out.print("Last_Name: "+obj1.getLast()+", ");
				System.out.print("Serial: "+obj1.getId()+", ");
				System.out.print("Alias: "+obj1.getAlias()+", ");
				System.out.print("Quote: "+obj1.getQuote()+"\n");			
				System.out.println();
				}
			//STEP 6: Clean-up environment
			rs.close();			
			break;
		// Displaying data according to the Serial number entered by user.	
		case 2:
			System.out.println("The table contains Serial 111, 112, 113 only. Select any one of the Serial Number to display the data belonging to that particular Serial\n");
			int choice2 = sc.nextInt();
			switch (choice2) {
			case 111:
				sql = "SELECT First_Name, Last_Name, Serial, Alias, QUOTE FROM infinity WHERE SERIAL=111";
				ResultSet rs2 = stmt.executeQuery(sql);
				//Creating an ArrayList object
				ArrayList<InfinityPOJO> infinityList2 = new ArrayList<>();
				//STEP 5: Extract data from result set
				while(rs2.next()){
				//Retrieve by column name
		     	InfinityPOJO obj = new InfinityPOJO();
				obj.setFirst(rs2.getString("First_Name"));
				obj.setLast(rs2.getString("Last_Name"));
				obj.setId(rs2.getInt("Serial"));
				obj.setAlias(rs2.getString("Alias"));
				obj.setQuote(rs2.getString("Quote"));
				infinityList2.add(obj);
				}
				//Display values
				for (InfinityPOJO obj1 : infinityList2) {
					System.out.print("First_Name: "+obj1.getFirst()+", ");
					System.out.print("Last_Name: "+obj1.getLast()+", ");
					System.out.print("Serial: "+obj1.getId()+", ");
					System.out.print("Alias: "+obj1.getAlias()+", ");
					System.out.print("Quote: "+obj1.getQuote()+"\n");			
					System.out.println();
					}
				//STEP 6: Clean-up environment
				rs2.close();
				break;
			case 112:
				sql = "SELECT First_Name, Last_Name, Serial, Alias, QUOTE FROM infinity WHERE SERIAL=112";
				ResultSet rs3 = stmt.executeQuery(sql);
				//Creating an ArrayList object
				ArrayList<InfinityPOJO> infinityList3 = new ArrayList<>();
				//STEP 5: Extract data from result set
				while(rs3.next()){
				//Retrieve by column name
		     	InfinityPOJO obj = new InfinityPOJO();
				obj.setFirst(rs3.getString("First_Name"));
				obj.setLast(rs3.getString("Last_Name"));
				obj.setId(rs3.getInt("Serial"));
				obj.setAlias(rs3.getString("Alias"));
				obj.setQuote(rs3.getString("Quote"));
				infinityList3.add(obj);
				}
				//Display values
				for (InfinityPOJO obj1 : infinityList3) {
					System.out.print("First_Name: "+obj1.getFirst()+", ");
					System.out.print("Last_Name: "+obj1.getLast()+", ");
					System.out.print("Serial: "+obj1.getId()+", ");
					System.out.print("Alias: "+obj1.getAlias()+", ");
					System.out.print("Quote: "+obj1.getQuote()+"\n");			
					System.out.println();
					}
				//STEP 6: Clean-up environment
				rs3.close();
				break;	
			case 113:
				sql = "SELECT First_Name, Last_Name, Serial, Alias, QUOTE FROM infinity WHERE SERIAL=113";
				ResultSet rs4 = stmt.executeQuery(sql);
				//Creating an ArrayList object
				ArrayList<InfinityPOJO> infinityList4 = new ArrayList<>();
				//STEP 5: Extract data from result set
				while(rs4.next()){
				//Retrieve by column name
		     	InfinityPOJO obj = new InfinityPOJO();
				obj.setFirst(rs4.getString("First_Name"));
				obj.setLast(rs4.getString("Last_Name"));
				obj.setId(rs4.getInt("Serial"));
				obj.setAlias(rs4.getString("Alias"));
				obj.setQuote(rs4.getString("Quote"));
				infinityList4.add(obj);
				}
				//Display values
				for (InfinityPOJO obj1 : infinityList4) {
					System.out.print("First_Name: "+obj1.getFirst()+", ");
					System.out.print("Last_Name: "+obj1.getLast()+", ");
					System.out.print("Serial: "+obj1.getId()+", ");
					System.out.print("Alias: "+obj1.getAlias()+", ");
					System.out.print("Quote: "+obj1.getQuote()+"\n ");			
					System.out.println();
					}
				//STEP 6: Clean-up environment
				rs4.close();
				break;
			// Displaying Choice Invalid when user enters wrong choice	
			default:
				System.out.println("Choice Invalid\n");
			}
		break;
		case 0:
			flag = 1;
			break;
		default:
			System.out.println("Invalid Choice\n");
		// Whenever user enters a Invalid Choice we execute the following while loop so that user can decide to exit or continue the operation
		while(true) {
			System.out.println("Press 1 if you want to continue fetching and displaying data or 0 if you want to exit the program.\n");	
			int choice3 = sc.nextInt();
			if(choice3 == 1) {
				flag = 0;
				break;
			}	
			else if(choice3 == 0) {
				flag = 1;
				break;
			}	
			else {
				System.out.println("Invalid Choice.\n");
			}
			}
		}
		}
		stmt.close();
		conn.close();
		}catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
		}catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
		}
		finally
		{
		//finally block used to close resources
		try{
		if(stmt!=null)
		stmt.close();
		}catch(SQLException se2){
		}// nothing we can do
		try{
		if(conn!=null)
		conn.close();
		}catch(SQLException se){
		se.printStackTrace();
		}
		}
		System.out.println("Goodbye!");
		}
}
