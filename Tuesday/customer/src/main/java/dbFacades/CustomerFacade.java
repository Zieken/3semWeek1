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
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author Kasper Jeppesen
 */
public class CustomerFacade 
{
    private static EntityManagerFactory emf;
    private static CustomerFacade instance;
    
    private CustomerFacade(){}
    
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    
    public Customer findById(Long id)
    {
        //open a database connection (and creates a database, if one doesnt exists)
        EntityManager em = emf.createEntityManager();
        
        try
        {
            return em.find(Customer.class, id);
        }
        finally
        {
            em.close();
        }
        
    }
    
    public List<Customer> findByLastName(String lastname)
    {
         //open a database connection (and creates a database, if one doesnt exists)
        EntityManager em = emf.createEntityManager();
        
        try
        {
           TypedQuery<Customer> query = 
                       em.createQuery("Select customer from Customer customer WHERE customer.lastname = :lastname",Customer.class);
           
           query.setParameter("lastname", lastname);
           List<Customer> customersWithTheLastName = query.getResultList();
           
           return customersWithTheLastName;
            
        }
        finally
        {
            em.close();
        }
    }
    
    public List<Customer> AllCustomers()
    {
        //open a database connection (and creates a database, if one doesnt exists)
        EntityManager em = emf.createEntityManager();
        
        try
        {
            TypedQuery<Customer> query = 
                       em.createQuery("Select customer from Customer customer",Customer.class);
            
            return query.getResultList();
        }
        finally
        {
            em.close();
        }
    }
    
    public Long getNumberOfCustomers()
    {
        //open a database connection (and creates a database, if one doesnt exists)
        EntityManager em = emf.createEntityManager();
        
        try
        {
            //JPA query is executed on the entities ( java classes ) and not the rows of the database table
            Query query = 
                       em.createQuery("Select count(e) from Customer e ");
            Long count = (long) query.getSingleResult();
            
            return count;
            
        }
        finally
        {
            em.close();
        }
    }
    
    public Customer addCustomer(String firstname, String lastname)
    {
        //open a database connection (and creates a database, if one doesnt exists)
        EntityManager em = emf.createEntityManager();
        
        try
        {
            //Instantiates a customer
            Customer customer = new Customer(firstname, lastname);
            
            //Persist customer
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            
             return customer;
        }
        finally
        {
            em.close();
        }
        
    }
    
    public static void main(String[] args)
    {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        
        //test for add customer (works)
//        Customer c1 = facade.addCustomer("Mikkel", "Patriksen");
//        Customer c2 = facade.addCustomer("Betina", "Thomsen");
//        System.out.println(c1.getFirstname());
//        System.out.println(c2.getFirstname());

        //test for number of customers (works)
//        Long customerNumber = facade.getNumberOfCustomers();
//        System.out.println(customerNumber);

        //test for getting all customers (works)
//        List allCustomers = facade.AllCustomers();
//        System.out.println(allCustomers);
        
        //test for finding customer by id (works)
        // not id 21, but id 2 - its a l for identifying 2 as a Long and not an int
//        Customer c = facade.findById(2l);
//        System.out.println(c);

        //test for finding customer by last name (works)
//        List customersByLastname = facade.findByLastName("Thomsen");
//        System.out.println(customersByLastname);
    }
    
}
