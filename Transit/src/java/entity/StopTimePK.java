/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author tom
 */
@Embeddable
public class StopTimePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "trip_id")
    private String tripId;
    @Basic(optional = false)
    @Column(name = "stop_id")
    private String stopId;

    public StopTimePK() {
    }

    public StopTimePK(String tripId, String stopId) {
	this.tripId = tripId;
	this.stopId = stopId;
    }

    public String getTripId() {
	return tripId;
    }

    public void setTripId(String tripId) {
	this.tripId = tripId;
    }

    public String getStopId() {
	return stopId;
    }

    public void setStopId(String stopId) {
	this.stopId = stopId;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (tripId != null ? tripId.hashCode() : 0);
	hash += (stopId != null ? stopId.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof StopTimePK)) {
	    return false;
	}
	StopTimePK other = (StopTimePK) object;
	if ((this.tripId == null && other.tripId != null) || (this.tripId != null && !this.tripId.equals(other.tripId))) {
	    return false;
	}
	if ((this.stopId == null && other.stopId != null) || (this.stopId != null && !this.stopId.equals(other.stopId))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.StopTimePK[ tripId=" + tripId + ", stopId=" + stopId + " ]";
    }
    
}
