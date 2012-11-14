/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Route;
import entity.StopTime;
import entity.Trip;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author tom
 */
public class RouteDaoTest {

    public RouteDaoTest() {
    }

    /**
     * Test of getRouteById method, of class RouteDao.
     */
    @Test
    public void testGetRouteById() {
	RouteDao dao = new RouteDao();
	Route r = dao.getRouteById("DUA800803080");
	assertTrue(r.getRouteLongName().contains("St Quentin en Yvelines"));
	//System.out.println("r = " + r.getRouteLongName());

	List<Trip> trips = r.getTripList();
	assertEquals(273, trips.size());
    }
   

    @Test
    public void testGetAllRoutes() {
	RouteDao dao = new RouteDao();

	// récuperation de tous les trip
	List<Route> routes = dao.getAllRoutes();
	assertEquals(181, routes.size());
    }
    @Test
    public void testGetTripsByHeadsign() {
	TripDao dao = new TripDao();

	List<Trip> trips = dao.getTripListByHeadsign("SLOM");
	assertEquals(22, trips.size());
	
	//displayTrips(trips);

    }
    
    @Test
    public void testGetStopTimes() {
	StopTimeDao dao = new StopTimeDao();
	//JAVEL
	List<StopTime> stoptimes = dao.getStopTimeByStopId("StopPoint:DUA8739306");
	//displayTrips(trips);
	
	assertEquals(1042, stoptimes.size());
    }
    
    @Test
    public void testGetTripByStopId() {
	TripDao dao = new TripDao();
	//JAVEL
	List<Trip> trips = dao.getTripListByStopId("StopPoint:DUA8739306");
	//displayTrips(trips);
	
	assertEquals(1042, trips.size());
    }
    
     @Test
    public void testGetHeadsigns() {
	RouteDao dao = new RouteDao();

	// récuperation de tous les trip
	List<String> headsigns = dao.getHeadsignListByRouteId("DUA800803080");
	assertEquals(4, headsigns.size());
	
	 
    }

    private void displayTrips(List<Trip> trips) {
	for (Trip trip : trips) {
	    List<StopTime> stopTimes = trip.getStopTimeList();

	    String headSign = trip.getTripHeadsign();
	    System.out.print(headSign + " > ");
	    for (StopTime stopTime : stopTimes) {
		SimpleDateFormat df = new SimpleDateFormat("hh:mm", Locale.FRENCH);
		Date depart = stopTime.getDepartureTime();

		String name = stopTime.getStop().getStopName();

		System.out.print(df.format(depart));
		System.out.print(" " + name + " | ");
	    }
	    System.out.println("");
	}
    }
    
    
    /*@Test
    public void testUpdateName(){
	RouteDao dao = new RouteDao();
    dao.updateRouteNames();
    }*/
}
