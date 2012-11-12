/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AgencyDao;
import dao.CalendarDao;
import dao.RouteDao;
import dao.StopDao;
import dao.StopTimeDao;
import dao.TripDao;
import entity.Agency;
import entity.Calendar;
import entity.Route;
import entity.Stop;
import entity.StopTime;
import entity.Trip;
import java.util.List;
import parser.GtfsParser;
import utils.UnZip;

/**
 *
 * @author tom
 */
public class JpaTransitService implements TransitService {

    private RouteDao routeDao = new RouteDao();
    private TripDao tripDao = new TripDao();
    private AgencyDao agencyDao = new AgencyDao();
    private CalendarDao calendarDao = new CalendarDao();
    private StopDao stopDao = new StopDao();
    private StopTimeDao stopTimeDao = new StopTimeDao();

    @Override
    public void importGtfsArchive(String archiveFilePath) {
	int count = 0;

	System.out.println("begining inflating");
	UnZip.unZipIt(archiveFilePath, "setup/gtfs");

	System.out.println("begining parsing");
	GtfsParser parser = new GtfsParser();
	parser.parse();

	System.out.println("begining agency import");
	for (Agency agency : parser.getAgencies()) {
	    agencyDao.create(agency);
	    count++;
	}
	System.out.println("done agency import : " + count);

	System.out.println("begining route import");
	count = 0;
	for (Route route : parser.getRoutes()) {
	    
	    boolean created = routeDao.create(route);
	    if (created) {
		count++;
	    } else {
		System.out.println("fail create route " + route.getRouteId());
	    }
	}
	System.out.println("done route import : " + count);

	System.out.println("begining calendar import");
	count = 0;
	for (Calendar calendar : parser.getCalendars()) {
	    
	    boolean created = calendarDao.create(calendar);
	    if (created) {
		count++;
	    } else {
		System.out.println("fail create calendar " + calendar.getCalendarPK().getServiceId());
	    }
	}
	System.out.println("done calendar import : " + count + " on " + parser.getCalendars().size());

	System.out.println("begining stop import");
	count = 0;
	for (Stop stop : parser.getStops()) {

	    boolean created = stopDao.create(stop);
	    if (created) {
		count++;
	    } else {
		System.out.println("fail create stop " + stop.getStopId());
	    }
	}
	System.out.println("done stop import : " + count);


	System.out.println("begining trip import");
	count = 0;
	for (Trip trip : parser.getTrips()) {
	    boolean created = tripDao.create(trip);
	    if (created) {
		count++;
	    } else {
		System.out.println("fail create trip " + trip.getTripPK().getTripId() + " - " + trip.getTripPK().getServiceId());
	    }

	}
	System.out.println("done trip import : " + count);

	System.out.println("begining stoptime import");
	count = 0;
	for (StopTime stopTime : parser.getStopTimes()) {

	    boolean created = stopTimeDao.create(stopTime);
	    if (created) {
		count++;
	    } else {
		System.out.println("fail create stop_time " + stopTime.getStopTimePK().getStopId() + " - " + stopTime.getStopTimePK().getTripId());
	    }
	}
	System.out.println("done stoptime import : " + count);
    }
    
    @Override
    public List<Trip> getTripListByRouteId(String routeId) {
	return tripDao.getTripListByRouteId(routeId);
    }

    @Override
    public List<Trip> getTripListByHeadsign(String tripHeadsign) {
	return tripDao.getTripListByHeadsign(tripHeadsign);
    }

    @Override
    public List<Trip> getTripListByStopId(String stopId) {
	return tripDao.getTripListByStopId(stopId);
    }

    @Override
    public List<String> getHeadsignListByRouteId(String routeId) {
	return routeDao.getHeadsignListByRouteId(routeId);
    }

    @Override
    public List<Route> getAllRoutes() {
	return routeDao.getAllRoutes();
    }

    @Override
    public Route getRouteById(String routeId) {
	return routeDao.getRouteById(routeId);
    }

    @Override
    public List<StopTime> getStopTimeListByTripId(String tripId) {
	return stopTimeDao.getStopTimeByTripId(tripId);
    }
}
