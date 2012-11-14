/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Route;
import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import utils.GenericComparator;

/**
 *
 * @author adminl
 */
public class RouteDao extends ProjectDao<Route> {

    public RouteDao() {
	super(Route.class);
    }

    public Route getRouteById(String routeId) {
	Query q = em.createNamedQuery("Route.findByRouteId");
	q.setParameter("routeId", routeId);

	return (Route) q.getSingleResult();
    }

    public List<Route> getAllRoutes() {
	Query q = em.createNamedQuery("Route.findAll");

	List<Route> routes = q.getResultList();
	Collections.sort(routes, new GenericComparator("routeLongName", true));
	return routes;
    }

    public List<String> getHeadsignListByRouteId(String routeId) {

	Query q = em.createQuery("SELECT DISTINCT t.tripHeadsign FROM Trip t WHERE t.routeId.routeId = :routeId");
	q.setParameter("routeId", routeId);

	return q.getResultList();
    }

   /* public void updateRouteNames() {
	Query q = em.createNamedQuery("Route.findAll");
	List<Route> routes = q.getResultList();

	tx.begin();
	for (Route route : routes) {
	    String updatedName = 
		    utils.StringUtils.toUpperFirst(route.getRouteLongName());
	    
	    route.setRouteLongName(updatedName);
	    em.merge(route);
	}
	tx.commit();
    }*/
}
