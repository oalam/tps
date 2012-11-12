/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.MysqlProductDao;
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

    ProductDao dao = new JPAProductDao();

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
        p.setPhotoUrl("http://chrispasset.files.wordpress.com/2011/11/mediumrare.jpg");
        p.setPrice(25.95);
        p.setStockQuantity(9);
        p.setCategory(c);


        productList.add(p);
        c.setProducts(productList);
        dao.create(p);

        Product p2 = dao.getProductById((int)p.getId());
        assertNotNull(p2);
        assertEquals(p, p2);

        // test delete
        dao.delete(p);

        Product p3 = dao.getProductById((int)p.getId());
        assertNotNull(p);
        assertEquals(false, p.equals(p3));

        // test update
        dao.create(p);
        p.setName("beefsteak");
        dao.update(p);
        p3 = dao.getProductById((int)p.getId());
        assertEquals("beefsteak", p3.getName());

        
        // remove test objects
        dao.delete(p);




    }
}
