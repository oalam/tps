/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Route;
import entity.StopTime;
import entity.Trip;
import java.util.List;

/**
 *
 * @author tom
 */
public interface TransitService {
    
    void importGtfsArchive(String archiveFilePath);

    List<Trip> getTripListByRouteId(String routeId);
    
    List<Trip> getTripListByHeadsign(String tripHeadsign);
    
    List<Trip> getTripListByStopId(String stopId);
    
    List<String> getHeadsignListByRouteId(String routeId);
    
    List<StopTime> getStopTimeListByTripId(String tripId);
    
    List<Route> getAllRoutes();
    
    Route getRouteById(String routeId);
}
