package groupproject.itmd515finalproject;
/*
	Deborah Barndt
 	 Thomas Boller
 	 2-23-18
 	 DAO.java
 	 Project Assignment 1
	This is a data access object that uses JDBC to create sql tables and post data to them. Later functionality to
	pull data from the tables.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
		// set up a  database URL String var
	
	// set up a  database URL String var
	static final String URL = "jdbc:mysql://localhost:3306/sys?autoReconnect=true&useSSL=false";
	
	// set up credential strings
		static final String UID = "root";
		static final String PASSWD = "QW!@12odin";
	
	//database object definition
	Connection dbcon = null;
	Statement stmnt = null;
	 
	
	// method to create our table
	public void createTables() {
		try {


			//connect to the db
		      dbcon = DriverManager.getConnection(URL, UID, PASSWD);

			//statement for connection
			stmnt = dbcon.createStatement();

			String dtTable = "CREATE TABLE IF NOT EXISTS DeliveryTransactions "
							+ "(tid int(10) NOT NULL, "
							+ "	userid varchar(10), "
							+ "	driverid varchar(11), "
							+ "	dateofsale date, "
							+ "	rate numeric(9,2), "
							+ "	pickuptime time, "
							+ "	pickuplocation varchar(255), "
							+ "	dropofftime time, "
							+ "	dropofflocation varchar(255), "
							+ "	packagesize varchar(1), "
							+ "	PRIMARY KEY( tid ))";

			stmnt.executeUpdate(dtTable);
			System.out.println("Created dtTable in given database...");
			
			String taxTable = "CREATE TABLE IF NOT EXISTS TaxiTransactions "
					+ "(tid int(10) NOT NULL, "
					+ "	userid varchar(10), "
					+ "	driverid varchar(11), "
					+ "	dateofsale date, "
					+ "	rate numeric(9,2), "
					+ "	pickuptime time, "
					+ "	pickuplocation varchar(255), "
					+ "	dropofftime time, "
					+ "	dropofflocation varchar(255), "
					+ "	rating tinyint(1), "
					+ "	PRIMARY KEY( tid ))";

	stmnt.executeUpdate(taxTable);
	System.out.println("Created taxTable in given database...");			
	
		String UserTable = "CREATE TABLE IF NOT EXISTS Users "
				+ "(userid varchar(10) NOT NULL, "
				+ "	password varchar(20), "
				+ "	firstname varchar(20), "
				+ "	lastname varchar(20), "
				+ "	usertype varchar(10), "
				+ "	email varchar(30), "
				+ "	curr_loc varchar(255), "
				+ "	rating tinyint(1), "
				+ "	PRIMARY KEY( userid ))";

	stmnt.executeUpdate(UserTable);
	System.out.println("Created User Table in given database...");		
	
		String PayTable = "CREATE TABLE IF NOT EXISTS Payment "
				+ "(pid int(10) NOT NULL, "
				+ "	nameoncard varchar(40), "
				+ "	cardnumber numeric(20), "
				+ "	expdate date, "
				+ "	ccv smallint(4), "
				+ "	userid varchar(30), "
				+ "	PRIMARY KEY( pid ))";
	
	stmnt.executeUpdate(PayTable);
	System.out.println("Created Payment Table in given database...");		
	
		String VTable = "CREATE TABLE IF NOT EXISTS Vehicles"
				+ "(vehicle_id int(10) NOT NULL, "
				+ "	make varchar(20), "
				+ "	model varchar(20), "
				+ "	year int(5), "
				+ "	licenseplate varchar(20), "
				+ "	color varchar(20), "
				+ "	PRIMARY KEY( vehicle_id ))";
	
	stmnt.executeUpdate(VTable);
	System.out.println("Created Vehicle Table in given database...");	
	
		String DriverTable = "CREATE TABLE IF NOT EXISTS Drivers"
				+ "(vehicle_id int(10) NOT NULL, "
				+ "	drivertype varchar(10), "
				+ "	license varchar(20), "
				+ "	userid varchar(20), "
				+ "	name varchar(30), "
				+ "	curr_loc varchar(30), "
				+ "	PRIMARY KEY( vehicle_id ))";
		
		stmnt.executeUpdate(DriverTable);
		System.out.println("Created Driver Table in given database...");	
			
		} catch (SQLException se) {
			
			// Handle errors for JDBC
			se.printStackTrace();
			
		} finally {
			
			// finally block used to close resources
			try {
				
				//if there is a statement logged and thus a connection created, then close the connection
				if (stmnt != null)
					dbcon.close();
				
			}//end of finally try
			
			catch (SQLException se){} // catch does nothing
			
		} // end of Finally
		
	}//end of createTable()

	public void insertDtRecords(DeliveryTransactions[] dtList) {

		String dtTbl = null;
		
		try{
		  //Open connection to the PAPA server
	      System.out.println("Connecting to test server to insert");
	      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
	      System.out.println("Connection to test server successful.");
	      
	      //create statment
	      System.out.println("Inserting records into the table...");
	      stmnt = dbcon.createStatement();

	      //cycles through the delivery transactions objects and stores them
	      for(int i=0;i<dtList.length;i++) {
	    	  dtTbl = "INSERT INTO DeliveryTransactions(tid, userid, driverid, dateOfSale, rate, pickuptime, pickuplocation, dropofftime, dropofflocation, packagesize)" +
	      " VALUES('"+dtList[i].getTid()+"' , '"+dtList[i].getUserid()+"' , '"+dtList[i].getDriverid()+"' , '"+dtList[i].getDateOfSale()+
	      "' , '"+dtList[i].getRate()+"' , '"+dtList[i].getPickupTime()+"' , '"+dtList[i].getPickupLocation()+"' , '"+dtList[i].getDropoffTime()+
	      "' , '"+dtList[i].getDropoffLocation()+"' , '"+dtList[i].getPackageSize()+"')";

	      stmnt.executeUpdate(dtTbl); //run query to insert record by record
	     
	      }

	      System.out.println("dtList added to DB");

	   }catch(SQLException se){
		   
		// Handle errors for JDBC
		se.printStackTrace();
		
	  }finally {
		  
		// finally block used to close resources
		try {
			
			if (stmnt != null)
				dbcon.close();
			
		} catch (SQLException se) {  } // catch does nothing
	}// end finally try
		
}	

	public void insertTaxRecords(TaxiTransactions[] taxList) {
		
		String taxTbl = null;
		
		try{
		  //Open connection to the PAPA server
	      System.out.println("Connecting to test server to insert");
	      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
	      System.out.println("Connection to test server successful.");
	      
	      //create statment
	      System.out.println("Inserting records into the table...");
	      stmnt = dbcon.createStatement();
	      
	      //cycles through the taxi transactions objects and stores them
	      for(int i=0;i<taxList.length;i++) {
	    	  taxTbl = "INSERT INTO TaxiTransactions(tid, userid, driverid, dateOfSale, rate, pickuptime, pickuplocation, dropofftime, dropofflocation, rating)" +
	      " VALUES('"+taxList[i].getTid()+"' , '"+taxList[i].getUserid()+"' , '"+taxList[i].getDriverid()+"' , '"+taxList[i].getDateOfSale()+
	      "' , '"+taxList[i].getRate()+"' , '"+taxList[i].getPickupTime()+"' , '"+taxList[i].getPickupLocation()+"' , '"+taxList[i].getDropoffTime()+
	      "' , '"+taxList[i].getDropoffLocation()+"' , '"+taxList[i].getRating()+"')";

	      stmnt.executeUpdate(taxTbl); //run query to insert record by record
	     
	      }

	      System.out.println("taxList added to DB");

	   }catch(SQLException se){
		   
		// Handle errors for JDBC
		se.printStackTrace();
		
	  }finally {
		  
		// finally block used to close resources
		try {
			
			if (stmnt != null)
				dbcon.close();
			
		} catch (SQLException se) {  } // catch does nothing
	}// end finally try
		
	}
	
	public void insertUsers(Users[] UsrList) {
		
		String UsrTbl = null;
		
		try{
		  //Open connection to the PAPA server
	      System.out.println("Connecting to test server to insert");
	      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
	      System.out.println("Connection to test server successful.");
	      
	      //create statment
	      System.out.println("Inserting records into the table...");
	      stmnt = dbcon.createStatement();
	      
	      //cycles through the taxi transactions objects and stores them
	      for(int i=0;i<UsrList.length;i++) {
	    	  UsrTbl = "INSERT INTO Users(userid, password, firstname, lastname, usertype, email, curr_loc, rating)" +
	      " VALUES('"+UsrList[i].getUserid()+"' , '"+UsrList[i].getPassword()+"' , '"+UsrList[i].getFirstName()+"' , '"+UsrList[i].getLastName()+
	      "' , '"+UsrList[i].getUserType()+"' , '"+UsrList[i].getEmail()+"' , '"+UsrList[i].getCurr_Loc()+"' , '"+UsrList[i].getRating()+"')";

	      stmnt.executeUpdate(UsrTbl); //run query to insert record by record
	     
	      }

	      System.out.println("Users added to DB");

	   }catch(SQLException se){
		   
		// Handle errors for JDBC
		se.printStackTrace();
		
	  }finally {
		  
		// finally block used to close resources
		try {
			
			if (stmnt != null)
				dbcon.close();
			
		} catch (SQLException se) {  } // catch does nothing
	}// end finally try
		
	}	
	
	public void insertPayment(Payment[] PayList) {
		
		String PayTbl = null;
		
		try{
		  //Open connection to the PAPA server
	      System.out.println("Connecting to test server to insert");
	      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
	      System.out.println("Connection to test server successful.");
	      
	      //create statment
	      System.out.println("Inserting records into the table...");
	      stmnt = dbcon.createStatement();
	      
	      //cycles through the taxi transactions objects and stores them
	      for(int i=0;i<PayList.length;i++) {
	    	  PayTbl = "INSERT INTO Payment(pid, nameoncard, cardnumber, expdate, ccv, userid)" +
	      " VALUES('"+PayList[i].getPid()+"' , '"+PayList[i].getNameOnCard()+"' , '"+PayList[i].getCardNumber()+"' , '"+PayList[i].getExpDate()+
	      "' , '"+PayList[i].getCCV()+"' , '"+PayList[i].getUserid()+"')";

	      stmnt.executeUpdate(PayTbl); //run query to insert record by record
	     
	      }

	      System.out.println("Payments added to DB");

	   }catch(SQLException se){
		   
		// Handle errors for JDBC
		se.printStackTrace();
		
	  }finally {
		  
		// finally block used to close resources
		try {
			
			if (stmnt != null)
				dbcon.close();
			
		} catch (SQLException se) {  } // catch does nothing
	}// end finally try
		
	}	

	
	public void insertVehicles(Vehicles[] VList) {
		
		String VTbl = null;
		
		try{
		  //Open connection to the PAPA server
	      System.out.println("Connecting to test server to insert");
	      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
	      System.out.println("Connection to test server successful.");
	      
	      //create statment
	      System.out.println("Inserting records into the table...");
	      stmnt = dbcon.createStatement();
	      
	      //cycles through the taxi transactions objects and stores them
	      for(int i=0;i<VList.length;i++) {
	    	  VTbl = "INSERT INTO Vehicles(vehicle_id, make, model, year, licenseplate, color)" +
	      " VALUES('"+VList[i].getVehicleId()+"' , '"+VList[i].getMake()+"' , '"+VList[i].getModel()+"' , '"+VList[i].getYear()+
	      "' , '"+VList[i].getLicensePlate()+"' , '"+VList[i].getColor()+"')";

	      stmnt.executeUpdate(VTbl); //run query to insert record by record
	     
	      }

	      System.out.println("Vehicles added to DB");

	   }catch(SQLException se){
		   
		// Handle errors for JDBC
		se.printStackTrace();
		
	  }finally {
		  
		// finally block used to close resources
		try {
			
			if (stmnt != null)
				dbcon.close();
			
		} catch (SQLException se) {  } // catch does nothing
	}// end finally try
		
	}	
	
	public void insertDrivers(Drivers[] DriverList) {
		
		String DriverTbl = null;
		
		try{
		  //Open connection to the PAPA server
	      System.out.println("Connecting to test server to insert");
	      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
	      System.out.println("Connection to test server successful.");
	      
	      //create statment
	      System.out.println("Inserting records into the table...");
	      stmnt = dbcon.createStatement();
	      
	      //cycles through the taxi transactions objects and stores them
	      for(int i=0;i<DriverList.length;i++) {
	    	  DriverTbl = "INSERT INTO Drivers(vehicle_id, drivertype, license, userid, name, curr_loc)" +
	      " VALUES('"+DriverList[i].getVehicleId()+"' , '"+DriverList[i].getDriverType()+"' , '"+DriverList[i].getLicense()+
	      "' , '"+DriverList[i].getUserId()+"' , '"+DriverList[i].getName()+"' , '"+DriverList[i].getCurrentLoc()+"')";

	      stmnt.executeUpdate(DriverTbl); //run query to insert record by record
	     
	      }

	      System.out.println("Drivers added to DB");

	   }catch(SQLException se){
		   
		// Handle errors for JDBC
		se.printStackTrace();
		
	  }finally {
		  
		// finally block used to close resources
		try {
			
			if (stmnt != null)
				dbcon.close();
			
		} catch (SQLException se) {  } // catch does nothing
	}// end finally try
		
	}	
	
}//end of class DAO
