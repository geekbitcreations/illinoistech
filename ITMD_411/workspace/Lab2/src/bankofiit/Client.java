/**
 * Deborah Barndt
 * 9-22-16
 * Client.java
 * Lab 2
 * This program will create an abstract class Client to allow for three abstract methods the bank needs to process. 
 * Written by Deborah Barndt. */
package bankofiit;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Deborah Barndt
 *
 */
public abstract class Client 
{

	/**
	 * 
	 */
	public Client() 
	{
		// TODO Auto-generated constructor stub
	}
	
	private String id, 			// the client's id
	   			  sex,			// value of whether the client is male or female
	              region,		// value of the client's city, town, rural, suburban
	              married,		// value of whether the client is married
	              car,			// value of whether the client has a car
	              save_act,		// value of whether the client has a savings account
	              current_act, 	// value of whether the client has a current account
	              mortgage,		// value of whether the client has a mortgage
	              pep;			// value of whether the client is a politically exposed person

	private int age,			// value of the client's age
			   children;		// amount of children the client has

	private double income;		// amount of income the client has

	//Create the bank records object to be processed.
	BankRecords clientInfo[];
	List<List<String>> bankInfo = new ArrayList<List<String>>();
	
	// Setter to assign the clientInfo to the ArrayList.
	public void setclientInfo(BankRecords[] clientInfo)
	{
		this.clientInfo = clientInfo;
	}
		
	// Setter to assign the id of the client.
	public void setId(String id)
	{
		this.id = id;
	}
		
	// Setter to assign the age of the client.
	public void setAge(int age)
	{
		this.age = age;
	}
		
	// Setter to assign the sex of the client.
	public void setSex(String sex)
	{
		this.sex = sex;
	}
		
	// Setter to assign the region of the client.
	public void setRegion(String region)
	{
		this.region = region;
	}
		
	// Setter to assign the income of the client.
	public void setIncome(double income)
	{
		this.income = income;
	}
		
	// Setter to assign the married status of the client.
	public void setMarried(String married)
	{
		this.married = married;
	}
		
	// Setter to assign the amount of children of the client.
	public void setChildren(int children)
	{
		this.children = children;
	}
		
	// Setter to assign the car status of the client.
	public void setCar(String car)
	{
		this.car = car;
	}
		
	// Setter to assign the savings account status of the client.
	public void setSave_act(String save_act)
	{
		this.save_act = save_act;
	}
		
	// Setter to assign the current account status of the client.
	public void setCurrent_act(String current_act)
	{
		this.current_act = current_act;
	}
	
	// Setter to assign the mortgage status of the client.
	public void setMortgage(String mortgage)
	{
		this.mortgage = mortgage;
	}
		
	// Setter to assign the politically exposed person status of the client.
	public void setPep(String pep)
	{
		this.pep = pep;
	}
		
	// Getter to get the clientInfo from the ArrayList
	//public BankRecords[] getclientInfo() 
	public BankRecords[] getclientInfo()
	{
		return clientInfo;
	}

	// Getter to get the id of the client.
	public String getId()
	{
		return id;
	}
		
	// Getter to get the age of the client
	public int getAge()
	{
		return age;
	}
		
	// Getter to get the sex of the client.
	public String getSex()
	{
		return sex;
	}
		
	// Getter to get the region of the client.
	public String getRegion()
	{
		return region;
	}
		
	// Getter to get the income of the client.
	public double getIncome()
	{
		return income;
	}
		
	// Getter to get the married status of the client.
	public String getMarried()
	{
		return married;
	}
		
	// Getter to get the amount of children of the client.
	public int getChildren()
	{
		return children;
	}
		
	// Getter to get the car status of the client.
	public String getCar()
	{
		return car;
	}
		
	// Getter to get the savings account status of the client.
	public String getSave_act()
	{
		return save_act;
	}
		
	// Getter to get the current account status of the client.
	public String getCurrent_act()
	{
		return current_act;
	}
		
	// Getter to get the mortgage of the client.
	public String getMortgage()
	{
		return mortgage;
	}
		
	// Getter to get the politically exposed person status of the client.
	public String getPep()
	{
		return pep;
	}
	
	// Method to read all the record data from the CSV file in the ArrayList.
	abstract void readData();
	
	// Method to process all the record data from the ArrayList and add the data into each of the instance fields.
	abstract void processData();
	
	// Method to print the first 25 records for various fields to be displayed.
	abstract void printData() throws MalformedURLException;
}


