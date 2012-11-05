/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
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


        // dairies
        Category category1 = new Category();
        List<Product> database1 = new ArrayList<>();
        category1.setName("dairies");
        database1.add(new Product("milk", "good milk", "http://google.com", 1.59, 12, category1));
        database1.add(new Product("cream", "good cream", "http://google.com", 3.59, 2, category1));
        category1.setProducts(database1);

        // bakery
        Category category2 = new Category();
        List<Product> database2 = new ArrayList<>();
        category2.setName("bakery");
        database2.add(new Product("bread", "good bread", "http://google.com", 1.59, 12, category2));
        database2.add(new Product("croissant", "good cream", "http://google.com", 3.59, 21, category2));
        database2.add(new Product("cake", "good cake", "http://google.com", 7.59, 18, category2));
        category2.setProducts(database2);

        // vegetables
        Category category3 = new Category();
        List<Product> database3 = new ArrayList<>();
        category3.setName("vegetables");
        database3.add(new Product("eeg plant", "miam", "http://google.com", 4.59, 21, category3));
        database3.add(new Product("tomato", "very red", "http://google.com", 5.59, 12, category3));
        database3.add(new Product("cumcumber", "masqued", "http://google.com", 3.59, 2, category3));
        category3.setProducts(database3);

        // meats
        Category category4 = new Category();
        List<Product> database4 = new ArrayList<>();
        category4.setName("meats");
        database4.add(new Product("beef", "very fresh", "http://google.com", 19.59, 12, category4));
        database4.add(new Product("lamb", "zzzzz", "http://google.com", 23.59, 2, category4));
        category4.setProducts(database4);


        //assertEquals(0,category1.getId());

        // 3. Stockage du livre dans la base de données.
        tx.begin();
        em.persist(category1);
        em.persist(category2);
        em.persist(category3);
        em.persist(category4);
        tx.commit();

        assertNotNull(category1.getId());
        assertNotNull(category2.getId());
        assertNotNull(category3.getId());
        assertNotNull(category4.getId());

        Category cat = em.find(Category.class, category1.getId());
        assertNotNull(cat);
        
        List<Product> products = cat.getProducts();
        assertEquals(2, products.size());
        for (Product product : products) {
            assertNotNull(product.getId());
        }
       
        
    }
}
