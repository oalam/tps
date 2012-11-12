/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByRouteId", query = "SELECT r FROM Route r WHERE r.routeId = :routeId"),
    @NamedQuery(name = "Route.findByRouteShortName", query = "SELECT r FROM Route r WHERE r.routeShortName = :routeShortName"),
    @NamedQuery(name = "Route.findByRouteLongName", query = "SELECT r FROM Route r WHERE r.routeLongName = :routeLongName"),
    @NamedQuery(name = "Route.findByRouteType", query = "SELECT r FROM Route r WHERE r.routeType = :routeType"),
    @NamedQuery(name = "Route.findByRouteColor", query = "SELECT r FROM Route r WHERE r.routeColor = :routeColor")})
public class Route implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "route_id")
    private String routeId;
    @Basic(optional = false)
    @Column(name = "route_short_name")
    private String routeShortName;
    @Basic(optional = false)
    @Column(name = "route_long_name")
    private String routeLongName;
    @Basic(optional = false)
    @Column(name = "route_type")
    private int routeType;
    @Column(name = "route_color")
    private Integer routeColor;
    @JoinColumn(name = "agency_id", referencedColumnName = "agency_id")
    @ManyToOne(optional = false)
    private Agency agencyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeId")
    private List<Trip> tripList;

    
        @Transient
    private String parsedAgencyId;

    public String getParsedAgencyId() {
	return parsedAgencyId;
    }

    public void setParsedAgencyId(String parsedAgencyId) {
	this.parsedAgencyId = parsedAgencyId;
    }

    
    public Route() {
    }

    public Route(String routeId) {
	this.routeId = routeId;
    }

    public Route(String routeId, String routeShortName, String routeLongName, int routeType) {
	this.routeId = routeId;
	this.routeShortName = routeShortName;
	this.routeLongName = routeLongName;
	this.routeType = routeType;
    }

    public String getRouteId() {
	return routeId;
    }

    public void setRouteId(String routeId) {
	this.routeId = routeId;
    }

    public String getRouteShortName() {
	return routeShortName;
    }

    public void setRouteShortName(String routeShortName) {
	this.routeShortName = routeShortName;
    }

    public String getRouteLongName() {
	return routeLongName;
    }

    public void setRouteLongName(String routeLongName) {
	this.routeLongName = routeLongName;
    }

    public int getRouteType() {
	return routeType;
    }

    public void setRouteType(int routeType) {
	this.routeType = routeType;
    }

    public Integer getRouteColor() {
	return routeColor;
    }

    public void setRouteColor(Integer routeColor) {
	this.routeColor = routeColor;
    }

    public Agency getAgencyId() {
	return agencyId;
    }

    public void setAgencyId(Agency agencyId) {
	this.agencyId = agencyId;
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
	hash += (routeId != null ? routeId.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Route)) {
	    return false;
	}
	Route other = (Route) object;
	if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.Route[ routeId=" + routeId + " ]";
    }
    
}
