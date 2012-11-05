/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dao.EmptyDao;
import dao.MockProductDao;
import dao.ProductDao;
import entity.Category;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
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
public class ProductDaoTest {

    ProductDao dao = new EmptyDao();

    public ProductDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ProductDao.
     */
    @Test
    public void testCreate() {
        System.out.println("create");


        // assuming that we have allready read category from db
        Category c = new Category();
        c.setName("meats");
        c.setId(2);

        List<Product> productList = new ArrayList<>();

        Product p = new Product();
        p.setName("steak");
        p.setDescription("boeuf de nouvelle zelande");
        p.setPhotoUrl("http://chrispasset.wordpress.com/2011/11/05/simple-and-easy-preparation-of-a-good-steak/&docid=z7BN63ng0ecrXM&imgurl=http://chrispasset.files.wordpress.com/2011/11/mediumrare.jpg");
        p.setPrice(5.95);
        p.setStockQuantity(9);
        //p.setCategory(2);
         p.setCategory(c);


         productList.add(p);
         c.setProducts(productList);
      /*  dao.create(p);
        
        
        
        
        

        Product p2 = new Product();
        p2.setId(p.getId());

        dao.read(p2);
        assertEquals(p, p2);

        // test delete
        dao.delete(p);

        Product p3 = new Product();
        p3.setId(p.getId());
        dao.read(p3);
        //    assertNotSame(p,p3);
        assertNotNull(p);
        assertEquals(false, p.equals(p3));

        // test update
        dao.create(p);
        p.setName("beefsteak");
        dao.update(p);
        p3.setId(p.getId());
        dao.read(p3);
        assertEquals("beefsteak", p3.getName());

        dao.delete(p);
        
        
        */
        
    }
}
