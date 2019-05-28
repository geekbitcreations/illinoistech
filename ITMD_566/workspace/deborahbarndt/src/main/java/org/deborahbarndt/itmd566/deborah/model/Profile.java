package org.deborahbarndt.itmd566.deborah.model;

public class Profile {
	
	public Profile() {
	
	}
	
	public Profile( long id, String profileName, String firstName, String lastName) {
		super();
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String profileName;
	private String firstName;
	private String lastName;
	private long id;

}
