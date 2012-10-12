/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Employe;
import java.util.ArrayList;
import java.util.List;
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
public class FileEmployeDaoTest {
    

    @Test
    public void testCharger() {
	System.out.println("charger");
	String fileName = "tmp.tx";
	FileEmployeDao dao = new FileEmployeDao();
	
	List<Employe> db = new ArrayList<>();
	db.add(EmployeFactory.createEmploye("bailet", "thomas", 400, true, 18));
	db.add(EmployeFactory.createEmploye("jobs", "steve", 600, false, 1));	
	db.add(EmployeFactory.createEmploye("gates", "bill", 600, 3, 2, 5, 9));
	dao.enregistrer(fileName, db);
	
	List<Employe> db2 = dao.charger(fileName);
	assertEquals(3, db2.size());
	
	int index = 0;
	for (Employe employe : db2) {
	    assertEquals(employe, db.get(index++));
	}

    }


}
