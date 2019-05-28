package beans;
import java.util.Hashtable;

import javax.validation.constraints.Pattern;


public class ValidationBean {
	private String name;
	private String email;
	private String ssn;
	private String address;
	@Pattern(regexp = "^\\d{5}-\\d{4}$")
	private String zipcode;
	private String city;
	private String state;
	private String lng;
	private String lat;
	private Hashtable errorMessages;
	
	 public boolean validate() {
		    boolean passValidation=true;
		    
		    if (!(email.length() > 7) || (email.indexOf('@') == -1)) {
		      errorMessages.put("email","Enter a valid email address");
		      email="";
		      passValidation=false;
		    }
		    if(!(zipcode.matches("^\\d{5}-\\d{4}$"))) {
		    		  errorMessages.put("zipcode","Zip code should be digits in the format: XXXXX-XXXX");
			      zipcode="";
			      passValidation=false;
		    }
		    return passValidation;
		  }
	 
	public String getErrorMsg(String s) {
		String errorMsg =(String)errorMessages.get(s.trim());
		return (errorMsg == null) ? "":errorMsg;
	}
		  
	public ValidationBean() {
		email="";
		zipcode="";
		errorMessages = new Hashtable();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
	
	
}
