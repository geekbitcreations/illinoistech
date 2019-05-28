package groupproject.itmd515finalproject;

import org.hibernate.Session;

import groupproject.itmd515finalproject.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
  
    /**
     * Hibernate test
     */
    public void testHib()
    {
        Session session = HibernateUtils.getSessionFactory().openSession();
		 
        session.beginTransaction();
        Users user = new Users();
 
        user.setUserid("001");
        user.setEmail("tboller@gmail.com");
        user.setFirstName("Tom");
        user.setLastName("Boller");
        user.setPassword("test");
        user.setUserType("admin");

 
        session.save(user);
        session.getTransaction().commit();	
}
    }
    

