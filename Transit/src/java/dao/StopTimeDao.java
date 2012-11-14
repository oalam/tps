/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.StopTime;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author adminl
 */
public class StopTimeDao extends ProjectDao<StopTime> {

    public StopTimeDao() {
        super(StopTime.class);
    }
    
     public List<StopTime> getStopTimeByStopId(String stopId){
	Query q = em.createNamedQuery("StopTime.findByStopId");
	q.setParameter("stopId",stopId);
	return q.getResultList();
    }
     
     public List<StopTime> getStopTimeByTripId(String tripId){
	Query q = em.createNamedQuery("StopTime.findByTripId");
	q.setParameter("tripId", tripId);
	
	return q.getResultList();
    }
}
