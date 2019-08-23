/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kasper Jeppesen
 */
public class EntityTested 
{
    public static void main(String[] args)
    {
        //open a database connection (creates a new database, if one doesnt exist)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        //Instantiates Customers
        Customer c1 = new Customer("Lene", "Mathiasen");
        Customer c2 = new Customer("John", "Johnson");
        Customer c3 = new Customer("Kim", "Jacobsen");
        Customer c4 = new Customer("Mike", "Larsen");
        
        try
        {
            //Persist Customers
             em.getTransaction().begin();
              em.persist(c1);
              em.persist(c2);
              em.persist(c3);
              em.persist(c4);
              em.getTransaction().commit();
              
              //Verify that Customers have been managed and have been given a database Id
              System.out.println(c1.getFirstname());
              System.out.println(c2.getId());
              System.out.println(c3.getId());
              System.out.println(c4.getId());
        }
        finally
        {
            em.close();
        }
    }
}
