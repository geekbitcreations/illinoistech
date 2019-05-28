package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
 
		SessionFactory factory = new Configuration()
						         .configure("hibernate.cfg.xml")
						         .addAnnotatedClass(Student.class)
						         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
	        //create student obj
			System.out.println("Creating student object...");
			Student tempStudent = new Student("Mr.","Smith","smitty@iit.edu");
			
			//start up transaction
			session.beginTransaction();
			
			//save the student
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Process complete!");
		
		}finally {
			factory.close();
		}

	}

}
