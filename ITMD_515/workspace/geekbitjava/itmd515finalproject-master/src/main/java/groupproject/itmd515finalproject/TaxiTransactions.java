package groupproject.itmd515finalproject;

/*
Deborah Barndt
	 Thomas Boller
	 3-27-18
	 TaxiTransactions.java
	 Project Assignment 3
	This is a class entity to hold TaxiTransactions
*/

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class TaxiTransactions implements java.io.Serializable {
	

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public TaxiTransactions () {
		}
		
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
		private byte rating;

		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */		

		public int getTid() {
			return tid;
		}
		public void setTid(int tid) {
			this.tid = tid;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getDriverid() {
			return driverid;
		}
		public void setDriverid(String driverid) {
			this.driverid = driverid;
		}
		public Date getDateOfSale() {
			return dateOfSale;
		}
		public void setDateOfSale(Date dateOfSale) {
			this.dateOfSale = dateOfSale;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		public Time getPickupTime() {
			return pickupTime;
		}
		public void setPickupTime(Time pickupTime) {
			this.pickupTime = pickupTime;
		}
		public String getPickupLocation() {
			return pickupLocation;
		}
		public void setPickupLocation(String pickupLocation) {
			this.pickupLocation = pickupLocation;
		}
		public Time getDropoffTime() {
			return dropoffTime;
		}
		public void setDropoffTime(Time dropoffTime) {
			this.dropoffTime = dropoffTime;
		}
		public String getDropoffLocation() {
			return dropoffLocation;
		}
		public void setDropoffLocation(String dropoffLocation) {
			this.dropoffLocation = dropoffLocation;
		}
		public byte getRating() {
			return rating;
		}
		public void setRating(byte rating) {
			this.rating = rating;
		}		
}
