/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbFacades;

import Entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kasper Jeppesen
 */
public class CustomerFacadeTest {
    
    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    /**
     * Test of findById method, of class CustomerFacade.
     */
    @Test
    public void testFindById() 
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
       CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        
        //Arrange
        Customer c;
        
        //Act
        c = facade.findById(1L);
        
        //Assert
        assertEquals("Tom", c.getFirstname());
        assertEquals("Jacobsen", c.getLastname());
        
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @Test
    public void testFindByLastName() 
    {
        //Arrange
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        List<Customer> c;
        
        //Act
        c = facade.findByLastName("Mathiasen");
        
        //assert
        assertEquals("Mathiasen", c.get(0).getLastname());
    }

    /**
     * Test of AllCustomers method, of class CustomerFacade.
     */
    @Test
    public void testAllCustomers() 
    {
        //Arrange
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        List<Customer> c;
        
        //Act
        c = facade.AllCustomers();
        
        //Assert
        assertEquals(8, c.size());
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @Test
    public void testGetNumberOfCustomers() 
    {
        //Arrange
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        Long numberOfCustomers;
        
        //Act
        numberOfCustomers = facade.getNumberOfCustomers();
        
        //Assert
        //assertEquals(8L, numberOfCustomers);
        
    }

    /**
     * Test of addCustomer method, of class CustomerFacade.
     */
//    @Test
//    public void testAddCustomer(String firstname, String lastname) 
//    {
//        //open a database connection (and creates a database, if one doesnt exists)
//        EntityManager em = emf.createEntityManager();      
//        
//        //Instantiates a customer
//        Customer customer = new Customer(firstname, lastname);
//        
//        //Persist customer
//        em.getTransaction().begin();
//        em.persist(customer);
//        em.getTransaction().commit();
//         
//        
//    }

   
    
}
