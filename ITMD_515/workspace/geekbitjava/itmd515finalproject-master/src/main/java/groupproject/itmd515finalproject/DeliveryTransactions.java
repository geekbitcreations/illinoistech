package groupproject.itmd515finalproject;

/*
Deborah Barndt
	 Thomas Boller
	 3-27-18
	 DeliveryTransactions.java
	 Project Assignment 3
	This is a class entity to hold DeliveryTransactions
*/


import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class DeliveryTransactions implements java.io.Serializable {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public DeliveryTransactions () {}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		
		@Id
		private int tid;
		private String userid;
		private String driverid;
		private Date dateOfSale;
		private double rate;
		private Time pickupTime;
		private String pickupLocation;
		private Time dropoffTime;
		private String dropoffLocation;
		private char packageSize;
		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
		/**
		 * @return the tid
		 */
		public int getTid() {
			return tid;
		}
		/**
		 * @param tid the tid to set
		 */
		public void setTid(int tid) {
			this.tid = tid;
		}
		/**
		 * @return the userid
		 */
		public String getUserid() {
			return userid;
		}
		/**
		 * @param userid the userid to set
		 */
		public void setUserid(String userid) {
			this.userid = userid;
		}
		/**
		 * @return the driverid
		 */
		public String getDriverid() {
			return driverid;
		}
		/**
		 * @param driverid the driverid to set
		 */
		public void setDriverid(String driverid) {
			this.driverid = driverid;
		}
		/**
		 * @return the dateOfSale
		 */
		public Date getDateOfSale() {
			return dateOfSale;
		}
		/**
		 * @param dateOfSale the dateOfSale to set
		 */
		public void setDateOfSale(Date dateOfSale) {
			this.dateOfSale = dateOfSale;
		}
		/**
		 * @return the rate
		 */
		public double getRate() {
			return rate;
		}
		/**
		 * @param rate the rate to set
		 */
		public void setRate(double rate) {
			this.rate = rate;
		}
		/**
		 * @return the pickupTime
		 */
		public Time getPickupTime() {
			return pickupTime;
		}
		/**
		 * @param pickupTime the pickupTime to set
		 */
		public void setPickupTime(Time pickupTime) {
			this.pickupTime = pickupTime;
		}
		/**
		 * @return the pickupLocation
		 */
		public String getPickupLocation() {
			return pickupLocation;
		}
		/**
		 * @param pickupLocation the pickupLocation to set
		 */
		public void setPickupLocation(String pickupLocation) {
			this.pickupLocation = pickupLocation;
		}
		/**
		 * @return the dropoffTime
		 */
		public Time getDropoffTime() {
			return dropoffTime;
		}
		/**
		 * @param dropoffTime the dropoffTime to set
		 */
		public void setDropoffTime(Time dropoffTime) {
			this.dropoffTime = dropoffTime;
		}
		/**
		 * @return the dropoffLocation
		 */
		public String getDropoffLocation() {
			return dropoffLocation;
		}
		/**
		 * @param dropoffLocation the dropoffLocation to set
		 */
		public void setDropoffLocation(String dropoffLocation) {
			this.dropoffLocation = dropoffLocation;
		}
		/**
		 * @return the packageSize
		 */
		public char getPackageSize() {
			return packageSize;
		}
		/**
		 * @param packageSize the packageSize to set
		 */
		public void setPackageSize(char packageSize) {
			this.packageSize = packageSize;
		}

		

}
