/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class ShoppingBasketTest {

    public ShoppingBasketTest() {
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
     * Test of updateProductQuantity method, of class ShoppingBasket.
     */
    @Test
    public void testUpdateProductQuantity() {
        System.out.println("updateProductQuantity");

        ShoppingBasket cart = new ShoppingBasket();

        short milkQuantity = 3;
        short creamQuantity = 2;
        double milkPrice = 0.95;
        double creamPrice = 2.95;
        double attendeeTotal = milkQuantity * milkPrice + 
                creamQuantity * creamPrice;

        Product milk = new Product("milk", "good fresh milk",
                "http://milk.com", milkPrice, 50,0);

        Product cream = new Product("cream", "good fresh cream",
                "http://cream.com", creamPrice, 10,0);


        cart.addProduct(milk);
        cart.addProduct(cream);
        
        cart.updateProductQuantity(milk, 0);
        cart.updateProductQuantity(cream, 5);
        
        cart.updateProductQuantity(milk, milkQuantity);
        cart.updateProductQuantity(cream, creamQuantity);
        
        double realtotal = cart.getTotal();
        
        assertEquals(attendeeTotal, realtotal, 0.001);
        System.out.println("realtotal = " + realtotal);
    }


}
