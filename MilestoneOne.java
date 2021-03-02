package com.highradius.milestoneONE;

import java.sql.*;
import java.math.*;
import java.util.*;
import java.io.*;


public class MilestoneOne {
	// JDBC driver name and database URL
			static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			static final String DB_URL = "jdbc:mysql://localhost/h2h_internship";
			// Database credentials
			static final String USER = "root";
			static final String PASS = "root";
	
	// Defining an array list. 		
	public static ArrayList<MilestoneOnePOJO> csvReader() {
		ArrayList<MilestoneOnePOJO> invoiceList=new ArrayList<>();
		String line = "";  
		String splitBy = ",";  
		try {  
			//reading the CSV file using BufferedReader   
			BufferedReader br = new BufferedReader(new FileReader("1828232.csv")); 
			line = br.readLine();  // to remove column names
			long count=0; // to count number of records read
			while ((line = br.readLine()) != null) {   //returns a Boolean value
			    MilestoneOnePOJO invoiceRecord=new MilestoneOnePOJO();
				String[] invoice = line.split(splitBy);  // use comma as separator
				if(invoice[17].length() == 0) {
					continue;
				}
				count++;
				invoiceRecord.setBusiness_code(invoice[0]);
				invoiceRecord.setCust_number(invoice[1]);
				invoiceRecord.setName_customer(invoice[2]);
				invoiceRecord.setClear_date(invoice[3]);
				invoiceRecord.setBusiness_year(invoice[4]);
				invoiceRecord.setDoc_id(invoice[5]);
				invoiceRecord.setPosting_date(invoice[6]);
				invoiceRecord.setDocument_create_date(invoice[8]);
				invoiceRecord.setDue_in_date(invoice[9]);
				invoiceRecord.setInvoice_currency(invoice[10]);
				invoiceRecord.setDocument_type(invoice[11]);
				invoiceRecord.setPosting_id(invoice[12]);
				invoiceRecord.setArea_business(invoice[13]);
				invoiceRecord.setTotal_open_amount(invoice[14]);
				invoiceRecord.setBaseline_create_date(invoice[15]);
				invoiceRecord.setCust_payment_terms(invoice[16]);
				invoiceRecord.setInvoice_id(invoice[17]);
				invoiceRecord.setIsOpen(invoice[18]);
				
				invoiceList.add(invoiceRecord);
			} 
				
			System.out.println(count+" Rows Processed");
			br.close();
		}catch (IOException e) {  
			e.printStackTrace();  
		}
		return invoiceList;
	}  
	
	//To Check Duplicate Doc_id as it is primary key and can't be duplicate
	public static boolean checkDuplicate(long doc_id) {
		int count=0;
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			String queryCheck = "SELECT count(*) from invoice_details WHERE doc_id = ?";
			PreparedStatement duplicateStatement = con.prepareStatement(queryCheck);
			duplicateStatement.setLong(1, doc_id);
			ResultSet result = duplicateStatement.executeQuery();
			if(result.next()) {
			    count = result.getInt(1);
			}
			result.close();
			duplicateStatement.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(count==1)
			return true;
		else
			return false;
	}
	
	// Adding Invoice Details (business_code,cust_number,name_customer,clear_date,business_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,area_business,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id,isOpen) to the database
	
	public static void addInvoiceDetails(ArrayList<MilestoneOnePOJO> invoiceList, int batchSize){
		int duplicate=0;
		int count=0;
		int batchRecord=0;
		Connection con = null;
		String sql = "INSERT INTO invoice_details VALUES(?,?,?,?,?,?,?,STR_TO_DATE(?,'%Y%m%d'),STR_TO_DATE(?,'%Y%m%d'),?,?,?,?,?,STR_TO_DATE(?,'%Y%m%d'),?,?,?);";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement statement = con.prepareStatement(sql);
			for (MilestoneOnePOJO invoice: invoiceList) {
				if(checkDuplicate(invoice.getDoc_id())) {
					duplicate++;
					System.out.println(duplicate+" Duplicate Rows Found");
					continue;
				}
				int psIndex=1;
			    statement.setString(psIndex++,invoice.getBusiness_code());
			    statement.setString(psIndex++,invoice.getCust_number()); 
			    statement.setString(psIndex++,invoice.getName_customer());
			    if(invoice.getClear_date().length() == 0) {
				    statement.setNull(psIndex++,Types.NULL);
			    }
			    else {
				    statement.setString(psIndex++,invoice.getClear_date());
			    }
			    statement.setInt(psIndex++,invoice.getBusiness_year());
			    statement.setLong(psIndex++,invoice.getDoc_id()); 
			    statement.setString(psIndex++,invoice.getPosting_date());
			    statement.setString(psIndex++,invoice.getDocument_create_date());
			    statement.setString(psIndex++,invoice.getDue_in_date());
			    statement.setString(psIndex++,invoice.getInvoice_currency());
			    statement.setString(psIndex++,invoice.getDocument_type());
			    statement.setShort(psIndex++,invoice.getPosting_id());
			    statement.setString(psIndex++,invoice.getArea_business());
			    statement.setDouble(psIndex++,invoice.getTotal_open_amount());
			    statement.setString(psIndex++,invoice.getBaseline_create_date());
			    statement.setString(psIndex++,invoice.getCust_payment_terms());
			    statement.setLong(psIndex++,invoice.getInvoice_id());
			    statement.setShort(psIndex,invoice.getIsOpen());
			
			    statement.addBatch();
			    batchRecord++;
			    count++;
			    System.out.println(count+" Records added to batch");
			    if (batchRecord==batchSize) {
			    	int[] affectedRecords = statement.executeBatch();
			    	System.out.println(affectedRecords.length+ " Executed");
					batchRecord=0;
			    }
			}
			int[] affectedRecords = statement.executeBatch();
	    	System.out.println(affectedRecords.length+ " Executed");
			
			statement.close();
			con.close();
	  }catch (Exception e) { 
			e.printStackTrace(); 
		}
		System.out.println(count+" Rows Inserted");
		System.out.println(duplicate+" Duplicate Rows Found");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<MilestoneOnePOJO> invoiceList=new ArrayList<>();
		invoiceList = csvReader();
		addInvoiceDetails(invoiceList,1000);
	}

}
