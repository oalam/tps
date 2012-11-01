/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class OrderManagerTest {

    public OrderManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");
    }

    @AfterClass
    public static void tearDownClass() {

        System.out.println("tearDownClass");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of placeOrder method, of class OrderManager.
     */
    @Test
    public void testPlaceOrder() {
        System.out.println("placeOrder");

        // Set user infos
        String payementInfos = "4929194065179112";
        String address = "10 rue des rosiers 75001 PARIS";
        String name = "Hitchcock Alfred";

        // Set basket content
        ShoppingBasket cart = new ShoppingBasket();
        Product milk = new Product("milk", "good fresh milk",
                "http://milk.com", 0.95, 50,0);

        Product cream = new Product("cream", "good fresh cream",
                "http://cream.com", 1.95, 10,0);

        cart.addProduct(milk);
        cart.addProduct(cream);
        cart.updateProductQuantity(milk, 2);
        cart.updateProductQuantity(cream, 1);


        // Place the order
        OrderManager orderMgr = new OrderManager();
        int oldOrderCount = orderMgr.getAllOrders().size();

        try {
	    Customer cust = new Customer( name, address, payementInfos);
            Order newOrder = orderMgr.placeOrder(cust, cart);

            // Make sure order has been placed
            assertNotNull(newOrder);

            // Make sure this order contains a valid Customer
            Customer cust2 = newOrder.getCustomer();
            assertNotNull(cust2);
            assertEquals(cust, cust2);

            // Verify the ordered products
            List<OrderedProduct> orderedProds = newOrder.getOrderedProducts();
            assertEquals(2, orderedProds.size());
            assertEquals(2 * .95 + 1.95, newOrder.getTotal(), 0.0001);


            // Verify stock integrity

            // Make sure there is a new order in the list
            int newOrderCount = orderMgr.getAllOrders().size();
            assertEquals(oldOrderCount + 1, newOrderCount);
            
            
        } catch (ProductStockException ex) {
            Logger.getLogger(OrderManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void plik() {
        System.out.println("plik");
    }
}
