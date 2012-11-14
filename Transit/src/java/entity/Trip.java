/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "trip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t"),
    @NamedQuery(name = "Trip.findByTripId", query = "SELECT t FROM Trip t WHERE t.tripPK.tripId = :tripId"),
    @NamedQuery(name = "Trip.findByServiceId", query = "SELECT t FROM Trip t WHERE t.tripPK.serviceId = :serviceId"),
    @NamedQuery(name = "Trip.findByTripHeadsign", query = "SELECT t FROM Trip t WHERE t.tripHeadsign = :tripHeadsign"),
    @NamedQuery(name = "Trip.findByDirectionId", query = "SELECT t FROM Trip t WHERE t.directionId = :directionId"),
    @NamedQuery(name = "Trip.findByStopId", query = "SELECT s FROM StopTime s WHERE s.stopTimePK.stopId = :stopId")})
public class Trip implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TripPK tripPK;
    @Column(name = "trip_headsign")
    private String tripHeadsign;
    @Column(name = "direction_id")
    private Integer directionId;
    @JoinTable(name = "trip_calendar", joinColumns = {
        @JoinColumn(name = "trip_id", referencedColumnName = "trip_id")}, inverseJoinColumns = {
        @JoinColumn(name = "service_id", referencedColumnName = "service_id"),
        @JoinColumn(name = "start_date", referencedColumnName = "start_date")})
    @ManyToMany( mappedBy = "tripList")
    private List<Calendar> calendarList;
  
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
    private List<StopTime> stopTimeList;
    
    
    
    
    @JoinColumn(name = "route_id", referencedColumnName = "route_id")
    @ManyToOne(optional = false)
    private Route routeId;

    
    @Transient
    private String parsedRouteId;


    public String getParsedRouteId() {
	return parsedRouteId;
    }

    public void setParsedRouteId(String parsedRouteId) {
	this.parsedRouteId = parsedRouteId;
    }

    
    public Trip() {
    }

    public Trip(TripPK tripPK) {
	this.tripPK = tripPK;
    }

    public Trip(String tripId, String serviceId) {
	this.tripPK = new TripPK(tripId, serviceId);
    }

    public TripPK getTripPK() {
	return tripPK;
    }

    public void setTripPK(TripPK tripPK) {
	this.tripPK = tripPK;
    }

    public String getTripHeadsign() {
	return tripHeadsign;
    }

    public void setTripHeadsign(String tripHeadsign) {
	this.tripHeadsign = tripHeadsign;
    }

    public Integer getDirectionId() {
	return directionId;
    }

    public void setDirectionId(Integer directionId) {
	this.directionId = directionId;
    }

    @XmlTransient
    public List<Calendar> getCalendarList() {
	return calendarList;
    }

    public void setCalendarList(List<Calendar> calendarList) {
	this.calendarList = calendarList;
    }

    @XmlTransient
    public List<StopTime> getStopTimeList() {
	return stopTimeList;
    }

    public void setStopTimeList(List<StopTime> stopTimeList) {
	this.stopTimeList = stopTimeList;
    }

    public Route getRouteId() {
	return routeId;
    }

    public void setRouteId(Route routeId) {
	this.routeId = routeId;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (tripPK != null ? tripPK.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Trip)) {
	    return false;
	}
	Trip other = (Trip) object;
	if ((this.tripPK == null && other.tripPK != null) || (this.tripPK != null && !this.tripPK.equals(other.tripPK))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.Trip[ tripPK=" + tripPK + " ]";
    }
    
}
