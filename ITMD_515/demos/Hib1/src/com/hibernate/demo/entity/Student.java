package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="student")
 
public class Student {
	//perform mapping (annotation)
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="fn")
	private String firstName;
    
    @Column(name="ln")
    private String lastName;
	
    @Column(name="email")
    private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {  //for debug / details
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student() {}

	public Student(String firstName, String lastName, String email) {
 
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
 	
}
