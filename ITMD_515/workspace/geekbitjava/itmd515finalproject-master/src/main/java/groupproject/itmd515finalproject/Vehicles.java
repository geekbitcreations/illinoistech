package groupproject.itmd515finalproject;

/*

Deborah Barndt
	 Thomas Boller
	 3-27-18
	 Vehicles.java
	 Project Assignment 3
	This is a class entity to hold Vehicles
*/

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicles implements java.io.Serializable {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Vehicles () {
		}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		
		@Id
		private int vehicle_id;
		private String make;
		private String model;
		private int year;
		private String license_plate;
		private String color;
		
		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
		/**
		 * @return the vehicle_id
		 */
		public int getVehicleId() {
			return vehicle_id;
		}
		/**
		 * @param vehicle_id the vehicle_id to set
		 */
		public void setVehicleId(int vehicle_id) {
			this.vehicle_id = vehicle_id;
		}
		/**
		 * @return the make
		 */
		public String getMake() {
			return make;
		}
		/**
		 * @param make the make to set
		 */
		public void setMake(String make) {
			this.make = make;
		}
		/**
		 * @return the model
		 */
		public String getModel() {
			return model;
		}
		/**
		 * @param model the model to set
		 */
		public void setModel(String model) {
			this.model = model;
		}
		/**
		 * @return the year
		 */
		public int getYear() {
			return year;
		}
		/**
		 * @param year the year to set
		 */
		public void setYear(int year) {
			this.year = year;
		}
		/**
		 * @return the name
		 */
		public String getLicensePlate() {
			return license_plate;
		}
		/**
		 * @param license_plate the license_plate to set
		 */
		public void setLicensePlate(String license_plate) {
			this.license_plate = license_plate;
		}
		/**
		 * @return the color
		 */
		public String getColor() {
			return color;
		}
		/**
		 * @param color the color to set
		 */
		public void setColor(String color) {
			this.color = color;
		}	
}