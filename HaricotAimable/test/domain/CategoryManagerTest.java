/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class CategoryManagerTest {

    public CategoryManagerTest() {
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
     * Test of getAllCategories method, of class CategoryManager.
     */
    @Test
    public void testGetAllCategories() {
        System.out.println("getAllCategories");

        // instanciate a manager
        CategoryManager manager = CategoryManager.getInstance();

        // retrieve all categories
        List<Category> cats = manager.getAllCategories();

        // make sure there are 4 categories
        assertEquals(4, cats.size());

    }

    // dairies, meat, vegetables, bakery
    // test id unicity
    @Test
    public void testCategories() {
        System.out.println("categories");

        // instanciate a manager
        CategoryManager manager = CategoryManager.getInstance();

        // retrieve all categories
        List<Category> cats = manager.getAllCategories();


        String cat0Name = cats.get(0).getName().toLowerCase();
        assertEquals("dairies", cat0Name);

        String cat1Name = cats.get(1).getName().toLowerCase();
        assertEquals("meat", cat1Name);

        String cat2Name = cats.get(2).getName().toLowerCase();
        assertEquals("vegetables", cat2Name);

        String cat3Name = cats.get(3).getName().toLowerCase();
        assertEquals("bakery", cat3Name);


    }

    @Test
    public void testGetCategoryById() {
        // instanciate a manager
        CategoryManager manager = CategoryManager.getInstance();

        // retrieve all categories
        List<Category> cats = manager.getAllCategories();

        for (Category category : cats) {

            int categoryId = category.getId();
            System.out.println("categoryId = " + categoryId);
            Category newCategory = manager.getCategoryById(categoryId);

            assertEquals(category, newCategory);
        }
    }

    @Test
    public void testAddProducts() {
        // instanciate a manager
        CategoryManager manager = CategoryManager.getInstance();

        // retrieve all categories
        Category dairies = manager.getAllCategories().get(0);
        int intialProductCount = dairies.getProducts().size();


        // ajout de produits
        dairies.getProducts().add(new Product("milk", "good fresh milk",
                "http://milk.com", 0.95, 50,0));

        dairies.getProducts().add(new Product("cream", "good fresh cream",
                "http://cream.com", 2.95, 10,0));

        int productCount = dairies.getProducts().size();
        assertEquals(intialProductCount + 2, productCount);

    }
}
