/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Trip;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author tom
 */
public class JpaTransitServiceTest {
    
    public JpaTransitServiceTest() {
    }

    /**
     * Test of importGtfsArchive method, of class JpaTransitService.
     */
    @Test
    public void test() {
	
	
	TransitService service = TransitServiceFactory.getService();
	
	List<Trip> trips = service.getTripListByHeadsign("SARA");
	
	System.out.println("trips.size() = " + trips.size());
    }

    
    @Test
    public void testImport() {
	
	
	TransitService service = TransitServiceFactory.getService();
	
	service.importGtfsArchive("setup/export-TN-GTFS-LAST.zip");
    }

 
}
