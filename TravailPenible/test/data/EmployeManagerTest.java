/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Employe;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tom
 */
public class EmployeManagerTest {
    
    public EmployeManagerTest() {
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
     * Test of getPermanents method, of class EmployeManager.
     */
    @Test
    public void testGetPermanents() {
	System.out.println("getPermanents");
	EmployeManager instance = new EmployeManager();
	List expResult = null;
	List result = instance.getPermanents();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getTemporaires method, of class EmployeManager.
     */
    @Test
    public void testGetTemporaires() {
	System.out.println("getTemporaires");
	EmployeManager instance = new EmployeManager();
	List expResult = null;
	List result = instance.getTemporaires();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEmployes method, of class EmployeManager.
     */
    @Test
    public void testGetAllEmployes() {
	System.out.println("getAllEmployes");
	EmployeManager instance = new EmployeManager();
	List expResult = null;
	List result = instance.getAllEmployes();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalIndemnites method, of class EmployeManager.
     */
    @Test
    public void testGetTotalIndemnites() {
	System.out.println("getTotalIndemnites");
	EmployeManager instance = new EmployeManager();
	double expResult = 0.0;
	double result = instance.getTotalIndemnites();
	assertEquals(expResult, result, 0.0);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of geTotalIndemnitesBruit method, of class EmployeManager.
     */
    @Test
    public void testGeTotalIndemnitesBruit() {
	System.out.println("geTotalIndemnitesBruit");
	EmployeManager instance = new EmployeManager();
	double expResult = 0.0;
	double result = instance.geTotalIndemnitesBruit();
	assertEquals(expResult, result, 0.0);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class EmployeManager.
     */
    @Test
    public void testAdd() {
	System.out.println("add");
	Employe emp = null;
	EmployeManager instance = new EmployeManager();
	instance.add(emp);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class EmployeManager.
     */
    @Test
    public void testRemove() {
	System.out.println("remove");
	String nom = "";
	EmployeManager instance = new EmployeManager();
	instance.remove(nom);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of charger method, of class EmployeManager.
     */
    @Test
    public void testCharger() {
	System.out.println("charger");
	String nomfichier = "";
	EmployeManager instance = new EmployeManager();
	instance.charger(nomfichier);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of enregistrer method, of class EmployeManager.
     */
    @Test
    public void testEnregistrer() {
	System.out.println("enregistrer");
	String nomfichier = "";
	EmployeManager instance = new EmployeManager();
	instance.enregistrer(nomfichier);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class EmployeManager.
     */
    @Test
    public void testClear() {
	System.out.println("clear");
	EmployeManager instance = new EmployeManager();
	instance.clear();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
}
