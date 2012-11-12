/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.StopTime;
import entity.Trip;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adminl
 */
public class DaoQueriesTest {

    public DaoQueriesTest() {
    }
    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction tx;

    @BeforeClass
    public static void setUpEntityManager() {
	emf = Persistence.createEntityManagerFactory("FortissimoPU");
	em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownEntityManager() {
	em.close();
	emf.close();
    }

    @Before
    public void setUpTransaction() {
	tx = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test1() {


	Query q = em.createNamedQuery("Trip.findByStopId");
	q.setParameter("stopId", "StopPoint:DUA76:228");

	List<Trip> trips = q.getResultList();
	assertEquals(219, trips.size());

	Query q2 = em.createNamedQuery("Trip.findByTripHeadsign");
	q2.setParameter("tripHeadsign", "SLOM");

	trips = q2.getResultList();
	assertEquals(22, trips.size());


	Query q3 = em.createNamedQuery("StopTime.findByTripId");
	// one SLOM trip
	q3.setParameter("tripId", "DUASN142456F01002381658");

	List<StopTime> stoptimes = q3.getResultList();
	assertEquals(26, stoptimes.size());

//	CriteriaBuilder cb = em.getCriteriaBuilder();
//	CriteriaQuery cq = cb.createQuery(StopTime.class);
//	Root<StopTime> c = cq.from(StopTime.class);
//	cq.select(c);
//	ParameterExpression<Trip> p = cb.parameter(Trip.class);
//	cq.where(cb.equal(c.get("trip"), p));
//
//
//	TypedQuery<StopTime> q3 = em.createQuery(cq);
//	q3.setParameter(p, trips.get(12));
//	List<StopTime> stoptimes = q3.getResultList();
//assertEquals(0, stoptimes.size());

//	
//	List<StopTime> stops = trips.get(0).getStopTimeList();
//	
//	assertEquals(22, stops.size());

    }

    @Test
    public void test2() {

	Query q = em.createNamedQuery("Trip.findByServiceId");
	q.setParameter("serviceId", "8070");

	List<Trip> trips = q.getResultList();
	assertEquals(67, trips.size());
    }
}
