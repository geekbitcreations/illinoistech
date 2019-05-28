package groupproject.itmd515finalproject;

/*
Deborah Barndt
	 Thomas Boller
	 3-27-18
	 Users.java
	 Project Assignment 3
	This is a class entity to hold Users
*/

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users implements java.io.Serializable {


	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Users () {
		}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */

		@Id
		private String userid;
		private String password;
		private String firstName;
		private String lastName;
		private String userType;
		private byte rating;
		private String email;
		private String curr_Loc;
	
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
	
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
		}
		public byte getRating() {
			return rating;
		}
		public void setRating(byte rating) {
			this.rating = rating;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCurr_Loc() {
			return curr_Loc;
		}
		public void setCurr_Loc(String curr_Loc) {
			this.curr_Loc = curr_Loc;
		}

	
		
}
