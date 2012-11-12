/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Route;
import entity.Trip;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author adminl
 */
public class TripDao extends ProjectDao<Trip> {

    public TripDao() {
        super(Trip.class);
    }

    public List<Trip> getTripListByRouteId(String routeId){
	Query q = em.createNamedQuery("Trip.findByRouteId");
	q.setParameter("routeId", routeId);
	
	return q.getResultList();
    }
    
    public List<Trip> getTripListByHeadsign(String tripHeadsign){
	Query q = em.createNamedQuery("Trip.findByTripHeadsign");
	q.setParameter("tripHeadsign", tripHeadsign );
	
	return q.getResultList();
    }
    
    public List<Trip> getTripListByStopId(String stopId){
	
	Query q = em.createNamedQuery("Trip.findByStopId");
	q.setParameter("stopId", stopId);
	
	
	return q.getResultList();
    }

}
