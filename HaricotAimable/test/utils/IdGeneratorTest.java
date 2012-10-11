/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
public class IdGeneratorTest {
    
    public IdGeneratorTest() {
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
     * Test of getNextId method, of class IdGenerator.
     */
    @Test
    public void testGetNextId() {
        System.out.println("getNextId");
      
        int firstResult = IdGenerator.getNextId();
        int secondResult = IdGenerator.getNextId();
        
        assertNotSame(firstResult, secondResult);
        //assertEquals(-1, firstResult-secondResult);
        
        
    }
}
