/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tom
 */
@Embeddable
public class CalendarPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "service_id")
    private String serviceId;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public CalendarPK() {
    }

    public CalendarPK(String serviceId, Date startDate) {
	this.serviceId = serviceId;
	this.startDate = startDate;
    }

    public String getServiceId() {
	return serviceId;
    }

    public void setServiceId(String serviceId) {
	this.serviceId = serviceId;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (serviceId != null ? serviceId.hashCode() : 0);
	hash += (startDate != null ? startDate.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof CalendarPK)) {
	    return false;
	}
	CalendarPK other = (CalendarPK) object;
	if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
	    return false;
	}
	if ((this.startDate == null && other.startDate != null) || (this.startDate != null && !this.startDate.equals(other.startDate))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.CalendarPK[ serviceId=" + serviceId + ", startDate=" + startDate + " ]";
    }
    
}
