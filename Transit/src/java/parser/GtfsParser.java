/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import entity.Agency;
import entity.Calendar;
import entity.Route;
import entity.Stop;
import entity.StopTime;
import entity.Trip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tom
 */
public class GtfsParser {

    private String inputFolderPath;
    private String agencyFilePath;
    private String routeFilePath;
    private String stopFilePath;
    private String calendarFilePath;
    private String calendarDateFilePath;
    private String stopTimeFilePath;
    private String tripFilePath;
    
    private List<Agency> agencies;
    private List<Calendar> calendars;
    private List<Route> routes;
    private List<Stop> stops;
    private List<StopTime> stopTimes;
    private List<Trip> trips;

    public List<Agency> getAgencies() {
	return agencies;
    }

    public List<Calendar> getCalendars() {
	return calendars;
    }

    public List<Route> getRoutes() {
	return routes;
    }

    public List<Stop> getStops() {
	return stops;
    }

    public List<StopTime> getStopTimes() {
	return stopTimes;
    }

    public List<Trip> getTrips() {
	return trips;
    }

    public final void setInputFolderPath(String inputFolderPath) {
	this.inputFolderPath = inputFolderPath;
	this.agencyFilePath = inputFolderPath + "agency.txt";
	this.routeFilePath = inputFolderPath + "routes.txt";
	this.stopFilePath = inputFolderPath + "stops.txt";
	this.calendarFilePath = inputFolderPath + "calendar.txt";
	this.calendarDateFilePath = inputFolderPath + "calendar_dates.txt";
	this.stopTimeFilePath = inputFolderPath + "stop_times.txt";
	this.tripFilePath = inputFolderPath + "trips.txt";
    }

    public GtfsParser() {
	setInputFolderPath("setup/gtfs/");
    }

    public void parse() {
	// Instanciate all parsers
	AbstractFileParser agencyParser = new AgencyFileParser();
	AbstractFileParser calendarParser = new CalendarFileParser();
	AbstractFileParser calendarDateParser = new CalendarDateFileParser();
	AbstractFileParser routeParse = new RouteFileParser();
	AbstractFileParser stopParser = new StopFileParser();
	AbstractFileParser stopTimeParser = new StopTimeFileParser();
	AbstractFileParser tripParser = new TripFileParser();

	// Parse files
	agencies = agencyParser.parseFile(agencyFilePath);
	calendars = calendarParser.parseFile(calendarFilePath);
	calendars.addAll(calendarDateParser.parseFile(calendarDateFilePath));
	routes = routeParse.parseFile(routeFilePath);
	stops = stopParser.parseFile(stopFilePath);
	stopTimes = stopTimeParser.parseFile(stopTimeFilePath);
	trips = tripParser.parseFile(tripFilePath);

	// Some maps are needed to make associations
	Map<String, Agency> mapAgencies = convertAgencyListToMap(agencies);
	Map<String, Route> mapRoutes = convertRouteListToMap(routes);
	Map<String, List<Calendar>> mapListCalendars = convertCalendarListToMapList(calendars);

	// Setup associations between route and agency
	for (Route route : routes) {
	    Agency agency = mapAgencies.get(route.getParsedAgencyId());
	    route.setAgencyId(agency);

	    mapRoutes.put(route.getRouteId(), route);
	}

	// setup associations between trip and calendar/route 
	for (Trip trip : trips) {

	    List<Calendar> cals = mapListCalendars.get(trip.getTripPK().getServiceId());
	    trip.setCalendarList(cals);

	    Route route = mapRoutes.get(trip.getParsedRouteId());
	    trip.setRouteId(route);
	}
    }

    
    //Helper methods
    private static Map<String, Agency> convertAgencyListToMap(List<Agency> agencies) {
	Map<String, Agency> map = new HashMap<String, Agency>();

	for (Agency agency : agencies) {
	    map.put(agency.getAgencyId(), agency);
	}
	return map;
    }

    private static Map<String, Route> convertRouteListToMap(List<Route> routes) {
	Map<String, Route> map = new HashMap<String, Route>();

	for (Route route : routes) {
	    map.put(route.getRouteId(), route);
	}
	return map;
    }

    private static Map<String, List<Calendar>> convertCalendarListToMapList(List<Calendar> calendars) {
	Map<String, List<Calendar>> map = new HashMap<String, List<Calendar>>();

	for (Calendar calendar : calendars) {
	    String serviceId = calendar.getCalendarPK().getServiceId();
	    List<Calendar> cals = map.get(serviceId);
	    
	    // add to previous list
	    if(cals == null){
		cals = new ArrayList<Calendar>();
		map.put(serviceId, cals);
	    }
	    cals.add(calendar);
	}
	return map;
    }
}
