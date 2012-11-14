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
public class TripPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "trip_id")
    private String tripId;
    @Basic(optional = false)
    @Column(name = "service_id")
    private String serviceId;

    public TripPK() {
    }

    public TripPK(String tripId, String serviceId) {
	this.tripId = tripId;
	this.serviceId = serviceId;
    }

    public String getTripId() {
	return tripId;
    }

    public void setTripId(String tripId) {
	this.tripId = tripId;
    }

    public String getServiceId() {
	return serviceId;
    }

    public void setServiceId(String serviceId) {
	this.serviceId = serviceId;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (tripId != null ? tripId.hashCode() : 0);
	hash += (serviceId != null ? serviceId.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof TripPK)) {
	    return false;
	}
	TripPK other = (TripPK) object;
	if ((this.tripId == null && other.tripId != null) || (this.tripId != null && !this.tripId.equals(other.tripId))) {
	    return false;
	}
	if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.TripPK[ tripId=" + tripId + ", serviceId=" + serviceId + " ]";
    }
    
}
