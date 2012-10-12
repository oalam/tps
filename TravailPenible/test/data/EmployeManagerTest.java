/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tom
 */
public class EmployeManagerTest {

    EmployeManager manager;

    @Before
    public void setUp() {
        manager = new EmployeManager();

        manager.add(EmployeFactory.createEmploye("Bailet", "thomas", 300, true, 18));
        manager.add(EmployeFactory.createEmploye("Jobs", "Steve", 600, false, 1));
        manager.add(EmployeFactory.createEmploye("Gates", "Billou", 400, 1, 2, 3, 4));
    }

    @After
    public void tearDown() {
        manager = null;
    }

    /**
     * Test of getPermanents method, of class EmployeManager.
     */
    @Test
    public void testGetPermanents() {
        System.out.println("getPermanents");
        assertEquals(2, manager.getPermanents().size());
    }

    /**
     * Test of getTemporaires method, of class EmployeManager.
     */
    @Test
    public void testGetTemporaires() {
        System.out.println("getTemporaires");
        assertEquals(1, manager.getTemporaires().size());
    }

    /**
     * Test of getAllEmployes method, of class EmployeManager.
     */
    @Test
    public void testGetAllEmployes() {
        System.out.println("getAllEmployes");
        assertEquals(3, manager.getAllEmployes().size());
    }

    /**
     * Test of getTotalIndemnites method, of class EmployeManager.
     */
    @Test
    public void testGetTotalIndemnites() {
        System.out.println("getTotalIndemnites");

        assertEquals(300.0, manager.geTotalIndemnitesBruit(), 0.0001);

    }

    /**
     * Test of geTotalIndemnitesBruit method, of class EmployeManager.
     */
    @Test
    public void testGeTotalIndemnitesBruit() {
        System.out.println("geTotalIndemnitesBruit");

    }

    /**
     * Test of remove method, of class EmployeManager.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        manager.remove("Gates");
        assertEquals(2, manager.getPermanents().size());
        assertEquals(0, manager.getTemporaires().size());
        assertEquals(2, manager.getAllEmployes().size());
    }

    /**
     * Test of charger method, of class EmployeManager.
     */
    @Test
    public void testCharger() {
        System.out.println("charger");
        manager.enregistrer("temp.txt");
        manager.clear();
        assertEquals(0, manager.getPermanents().size());
        assertEquals(0, manager.getTemporaires().size());
        assertEquals(0, manager.getAllEmployes().size());
        manager.charger("temp.txt");
        assertEquals(2, manager.getPermanents().size());
        assertEquals(1, manager.getTemporaires().size());
        assertEquals(3, manager.getAllEmployes().size());
    }
}
