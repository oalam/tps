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
public class EmployeTest {
    


  

    /**
     * Test of setIndiceBrut method, of class Employe.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIndiceBrutException() {
        System.out.println("setIndiceBrut");
       
        Employe employe = new EmployePermanent("", "", 150, true, 1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIndiceBrutException2() {
        System.out.println("setIndiceBrut");
       
        Employe employe = new EmployePermanent("", "", 950, true, 1);
    }
   


  

}
