/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.StopTimeDao;
import entity.Agency;
import entity.Route;
import entity.StopTime;
import entity.Trip;
import java.util.ArrayList;
import java.util.List;
import service.TransitService;
import service.TransitServiceFactory;

/**
 *
 * @author adminl
 */
public class SearchAction extends ActionSupport {

    // business methods handler
    private TransitService service = TransitServiceFactory.getService();
    private String stop_name;
    private List<Agency> agencies;
    private List<Route> routes;
    private List<String> headsigns;
    private List<List<StopTime>> stopTimes = new ArrayList<List<StopTime>>();
    private List<Trip> tripList;
    private String routeLongName;
    private String routeId;
    private String currentHeadsign;

    public String getCurrentHeadsign() {
        return currentHeadsign;
    }

    public void setCurrentHeadsign(String currentHeadsign) {
        this.currentHeadsign = currentHeadsign;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
        this.routeLongName = routeLongName;
    }

    public List<String> getHeadsigns() {
        return headsigns;
    }

    public void setHeadsigns(List<String> headsigns) {
        this.headsigns = headsigns;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public List<List<StopTime>> getStopTimes() {
	return stopTimes;
    }

    public void setStopTimes(List<List<StopTime>> stopTimes) {
	this.stopTimes = stopTimes;
    }

    
    @Override
    public String execute() {
        /* if (stop_name.equals("agency")) {
         agencies = BusinessObjectFactory.createSampleAgencyList();
         }
         // ProjectDao dao = new ProjectDao() {};
         if (stop_name.equals("agency")) {
         routes = BusinessObjectFactory.createSampleRouteList(agencies);
         }*/


        return SUCCESS;

    }

    public String search() {

        routes = service.getAllRoutes();

      
        StopTimeDao stDao = new StopTimeDao();
       // List<StopTime> stopTimes = stDao.getStopTimeByStopId("StopArea:DUA8711371");


        // ProjectDao dao = new ProjectDao() {};
//        agencies = BusinessObjectFactory.createSampleAgencyList();
//        routes = BusinessObjectFactory.createSampleRouteList(agencies);
//        System.out.println("agencies.size() = " + agencies.size());

        return SUCCESS;


    }

    public String displayRoute() {
        routes = service.getAllRoutes();


        return SUCCESS;
    }

    public String displayHeadSign() {
        headsigns = service.getHeadsignListByRouteId(routeId);
        routeLongName = service.getRouteById(routeId).getRouteLongName();

        return SUCCESS;
    }

    public String displayTrips() {

        tripList = service.getTripListByHeadsign(currentHeadsign);
	
	for (Trip trip : tripList) {
	    stopTimes.add(service.getStopTimeListByTripId(trip.getTripPK().getTripId()));
	    
	}

        return SUCCESS;



    }
}
