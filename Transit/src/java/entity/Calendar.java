/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "calendar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c"),
    @NamedQuery(name = "Calendar.findByServiceId", query = "SELECT c FROM Calendar c WHERE c.calendarPK.serviceId = :serviceId"),
    @NamedQuery(name = "Calendar.findByMonday", query = "SELECT c FROM Calendar c WHERE c.monday = :monday"),
    @NamedQuery(name = "Calendar.findByTuesday", query = "SELECT c FROM Calendar c WHERE c.tuesday = :tuesday"),
    @NamedQuery(name = "Calendar.findByWednerday", query = "SELECT c FROM Calendar c WHERE c.wednerday = :wednerday"),
    @NamedQuery(name = "Calendar.findByThursday", query = "SELECT c FROM Calendar c WHERE c.thursday = :thursday"),
    @NamedQuery(name = "Calendar.findByFriday", query = "SELECT c FROM Calendar c WHERE c.friday = :friday"),
    @NamedQuery(name = "Calendar.findBySaturday", query = "SELECT c FROM Calendar c WHERE c.saturday = :saturday"),
    @NamedQuery(name = "Calendar.findBySunday", query = "SELECT c FROM Calendar c WHERE c.sunday = :sunday"),
    @NamedQuery(name = "Calendar.findByStartDate", query = "SELECT c FROM Calendar c WHERE c.calendarPK.startDate = :startDate"),
    @NamedQuery(name = "Calendar.findByEndDate", query = "SELECT c FROM Calendar c WHERE c.endDate = :endDate"),
    @NamedQuery(name = "Calendar.findByExceptionType", query = "SELECT c FROM Calendar c WHERE c.exceptionType = :exceptionType")})
public class Calendar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalendarPK calendarPK;
    @Basic(optional = false)
    @Column(name = "monday")
    private boolean monday;
    @Basic(optional = false)
    @Column(name = "tuesday")
    private boolean tuesday;
    @Basic(optional = false)
    @Column(name = "wednerday")
    private boolean wednerday;
    @Basic(optional = false)
    @Column(name = "thursday")
    private boolean thursday;
    @Basic(optional = false)
    @Column(name = "friday")
    private boolean friday;
    @Basic(optional = false)
    @Column(name = "saturday")
    private boolean saturday;
    @Basic(optional = false)
    @Column(name = "sunday")
    private boolean sunday;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "exception_type")
    private Integer exceptionType;
    
    
    @ManyToMany
    private List<Trip> tripList;

    public Calendar() {
    }

    public Calendar(CalendarPK calendarPK) {
	this.calendarPK = calendarPK;
    }

    public Calendar(CalendarPK calendarPK, boolean monday, boolean tuesday, boolean wednerday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
	this.calendarPK = calendarPK;
	this.monday = monday;
	this.tuesday = tuesday;
	this.wednerday = wednerday;
	this.thursday = thursday;
	this.friday = friday;
	this.saturday = saturday;
	this.sunday = sunday;
    }

    public Calendar(String serviceId, Date startDate) {
	this.calendarPK = new CalendarPK(serviceId, startDate);
    }

    public CalendarPK getCalendarPK() {
	return calendarPK;
    }

    public void setCalendarPK(CalendarPK calendarPK) {
	this.calendarPK = calendarPK;
    }

    public boolean getMonday() {
	return monday;
    }

    public void setMonday(boolean monday) {
	this.monday = monday;
    }

    public boolean getTuesday() {
	return tuesday;
    }

    public void setTuesday(boolean tuesday) {
	this.tuesday = tuesday;
    }

    public boolean getWednerday() {
	return wednerday;
    }

    public void setWednerday(boolean wednerday) {
	this.wednerday = wednerday;
    }

    public boolean getThursday() {
	return thursday;
    }

    public void setThursday(boolean thursday) {
	this.thursday = thursday;
    }

    public boolean getFriday() {
	return friday;
    }

    public void setFriday(boolean friday) {
	this.friday = friday;
    }

    public boolean getSaturday() {
	return saturday;
    }

    public void setSaturday(boolean saturday) {
	this.saturday = saturday;
    }

    public boolean getSunday() {
	return sunday;
    }

    public void setSunday(boolean sunday) {
	this.sunday = sunday;
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public Integer getExceptionType() {
	return exceptionType;
    }

    public void setExceptionType(Integer exceptionType) {
	this.exceptionType = exceptionType;
    }

    @XmlTransient
    public List<Trip> getTripList() {
	return tripList;
    }

    public void setTripList(List<Trip> tripList) {
	this.tripList = tripList;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (calendarPK != null ? calendarPK.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Calendar)) {
	    return false;
	}
	Calendar other = (Calendar) object;
	if ((this.calendarPK == null && other.calendarPK != null) || (this.calendarPK != null && !this.calendarPK.equals(other.calendarPK))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.Calendar[ calendarPK=" + calendarPK + " ]";
    }
    
}
