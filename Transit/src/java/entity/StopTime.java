/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "stop_time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StopTime.findAll", query = "SELECT s FROM StopTime s"),
    @NamedQuery(name = "StopTime.findByTripId", query = "SELECT s FROM StopTime s WHERE s.stopTimePK.tripId = :tripId ORDER BY s.stopSequence"),
    @NamedQuery(name = "StopTime.findByStopId", query = "SELECT s FROM StopTime s WHERE s.stopTimePK.stopId = :stopId"),
    @NamedQuery(name = "StopTime.findByArrivalTime", query = "SELECT s FROM StopTime s WHERE s.arrivalTime = :arrivalTime"),
    @NamedQuery(name = "StopTime.findByDepartureTime", query = "SELECT s FROM StopTime s WHERE s.departureTime = :departureTime"),
    @NamedQuery(name = "StopTime.findByStopSequence", query = "SELECT s FROM StopTime s WHERE s.stopSequence = :stopSequence"),
    @NamedQuery(name = "StopTime.findByPickupType", query = "SELECT s FROM StopTime s WHERE s.pickupType = :pickupType"),
    @NamedQuery(name = "StopTime.findByDropOffType", query = "SELECT s FROM StopTime s WHERE s.dropOffType = :dropOffType")})
@AssociationOverrides({
    @AssociationOverride(name = "stopTimePK.trip_id", joinColumns =
    @JoinColumn(name = "trip_id")),
    @AssociationOverride(name = "stopTimePK.stop_id", joinColumns =
    @JoinColumn(name = "stop_id"))})
public class StopTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StopTimePK stopTimePK;
    @Basic(optional = false)
    @Column(name = "arrival_time")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    @Basic(optional = false)
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Basic(optional = false)
    @Column(name = "stop_sequence")
    private int stopSequence;
    @Basic(optional = false)
    @Column(name = "pickup_type")
    private int pickupType;
    @Basic(optional = false)
    @Column(name = "drop_off_type")
    private int dropOffType;
    
    @JoinColumn(name = "stop_id", referencedColumnName = "stop_id", insertable = false, updatable = false)
   // @MapsId(value="stopId")
    private Stop stop;

    @JoinColumns({
	@JoinColumn(name = "trip_id", referencedColumnName = "trip_id",
	nullable = false, insertable = false, updatable = false),
	@JoinColumn(name = "stop_id", referencedColumnName = "stop_id",
	nullable = true, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Trip trip;

    public StopTime() {
    }

    public StopTime(StopTimePK stopTimePK) {
	this.stopTimePK = stopTimePK;
    }

    public StopTime(StopTimePK stopTimePK, Date arrivalTime, Date departureTime, int stopSequence, int pickupType, int dropOffType) {
	this.stopTimePK = stopTimePK;
	this.arrivalTime = arrivalTime;
	this.departureTime = departureTime;
	this.stopSequence = stopSequence;
	this.pickupType = pickupType;
	this.dropOffType = dropOffType;
    }

    public StopTime(String tripId, String stopId) {
	this.stopTimePK = new StopTimePK(tripId, stopId);
    }

    public StopTimePK getStopTimePK() {
	return stopTimePK;
    }

    public void setStopTimePK(StopTimePK stopTimePK) {
	this.stopTimePK = stopTimePK;
    }

    public Date getArrivalTime() {
	return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
	this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
	return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
	this.departureTime = departureTime;
    }

    public int getStopSequence() {
	return stopSequence;
    }

    public void setStopSequence(int stopSequence) {
	this.stopSequence = stopSequence;
    }

    public int getPickupType() {
	return pickupType;
    }

    public void setPickupType(int pickupType) {
	this.pickupType = pickupType;
    }

    public int getDropOffType() {
	return dropOffType;
    }

    public void setDropOffType(int dropOffType) {
	this.dropOffType = dropOffType;
    }

    public Stop getStop() {
	return stop;
    }

    public void setStop(Stop stop) {
	this.stop = stop;
    }

    public Trip getTrip() {
	return trip;
    }

    public void setTrip(Trip trip) {
	this.trip = trip;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (stopTimePK != null ? stopTimePK.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof StopTime)) {
	    return false;
	}
	StopTime other = (StopTime) object;
	if ((this.stopTimePK == null && other.stopTimePK != null) || (this.stopTimePK != null && !this.stopTimePK.equals(other.stopTimePK))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.StopTime[ stopTimePK=" + stopTimePK + " ]";
    }
}
