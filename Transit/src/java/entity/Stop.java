/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tom
 */
@Entity
@Table(name = "stop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stop.findAll", query = "SELECT s FROM Stop s"),
    @NamedQuery(name = "Stop.findByStopId", query = "SELECT s FROM Stop s WHERE s.stopId = :stopId"),
    @NamedQuery(name = "Stop.findByStopName", query = "SELECT s FROM Stop s WHERE s.stopName = :stopName"),
    @NamedQuery(name = "Stop.findByStopLat", query = "SELECT s FROM Stop s WHERE s.stopLat = :stopLat"),
    @NamedQuery(name = "Stop.findByStopLon", query = "SELECT s FROM Stop s WHERE s.stopLon = :stopLon"),
    @NamedQuery(name = "Stop.findByLoacationType", query = "SELECT s FROM Stop s WHERE s.loacationType = :loacationType")})
public class Stop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "stop_id")
    private String stopId;
    @Basic(optional = false)
    @Column(name = "stop_name")
    private String stopName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "stop_lat")
    private BigDecimal stopLat;
    @Basic(optional = false)
    @Column(name = "stop_lon")
    private BigDecimal stopLon;
    @Column(name = "loacation_type")
    private Boolean loacationType;
    
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stop")
    private List<StopTime> stopTimeList;
    

    public Stop() {
    }

    public Stop(String stopId) {
	this.stopId = stopId;
    }

    public Stop(String stopId, String stopName, BigDecimal stopLat, BigDecimal stopLon) {
	this.stopId = stopId;
	this.stopName = stopName;
	this.stopLat = stopLat;
	this.stopLon = stopLon;
    }

    public String getStopId() {
	return stopId;
    }

    public void setStopId(String stopId) {
	this.stopId = stopId;
    }

    public String getStopName() {
	return stopName;
    }

    public void setStopName(String stopName) {
	this.stopName = stopName;
    }

    public BigDecimal getStopLat() {
	return stopLat;
    }

    public void setStopLat(BigDecimal stopLat) {
	this.stopLat = stopLat;
    }

    public BigDecimal getStopLon() {
	return stopLon;
    }

    public void setStopLon(BigDecimal stopLon) {
	this.stopLon = stopLon;
    }

    public Boolean getLoacationType() {
	return loacationType;
    }

    public void setLoacationType(Boolean loacationType) {
	this.loacationType = loacationType;
    }

    @XmlTransient
    public List<StopTime> getStopTimeList() {
	return stopTimeList;
    }

    public void setStopTimeList(List<StopTime> stopTimeList) {
	this.stopTimeList = stopTimeList;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (stopId != null ? stopId.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Stop)) {
	    return false;
	}
	Stop other = (Stop) object;
	if ((this.stopId == null && other.stopId != null) || (this.stopId != null && !this.stopId.equals(other.stopId))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.Stop[ stopId=" + stopId + " ]";
    }
    
}
