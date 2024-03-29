/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adminl
 */
public class CategoryTest {

    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction tx;

    @BeforeClass
    public static void setUpEntityManager() {
        emf = Persistence.createEntityManagerFactory("HaricotAimableTestPU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownEntityManager() {
        em.close();
        emf.close();
    }

    @Before
    public void setUpTransaction() {
        tx = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getProducts method, of class Category.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");

        Map<String, Category> categories = 
                BusinessObjectFactory.createSampleCategoryList();


        // 3. Stockage du livre dans la base de données.
        tx.begin();
        em.persist(categories.get("dairies"));
        em.persist(categories.get("bakery"));
        em.persist(categories.get("vegetables"));
        em.persist(categories.get("meats"));
        tx.commit();

        assertNotNull(categories.get("dairies").getId());
        assertNotNull(categories.get("bakery").getId());
        assertNotNull(categories.get("vegetables").getId());
        assertNotNull(categories.get("meats").getId());

        Category cat = em.find(Category.class, 
                categories.get("dairies").getId());
        assertNotNull(cat);
        
        List<Product> products = cat.getProducts();
        assertEquals(2, products.size());
        for (Product product : products) {
            assertNotNull(product.getId());
        }
       
        tx.begin();
        em.remove(categories.get("dairies"));
        em.remove(categories.get("bakery"));
        em.remove(categories.get("vegetables"));
        em.remove(categories.get("meats"));
        tx.commit();
        
    }
}
