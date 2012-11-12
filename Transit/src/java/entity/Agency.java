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
@Table(name = "agency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agency.findAll", query = "SELECT a FROM Agency a"),
    @NamedQuery(name = "Agency.findByAgencyId", query = "SELECT a FROM Agency a WHERE a.agencyId = :agencyId"),
    @NamedQuery(name = "Agency.findByAgencyName", query = "SELECT a FROM Agency a WHERE a.agencyName = :agencyName"),
    @NamedQuery(name = "Agency.findByAgencyUrl", query = "SELECT a FROM Agency a WHERE a.agencyUrl = :agencyUrl"),
    @NamedQuery(name = "Agency.findByAgencyTimezone", query = "SELECT a FROM Agency a WHERE a.agencyTimezone = :agencyTimezone"),
    @NamedQuery(name = "Agency.findByAgencyLang", query = "SELECT a FROM Agency a WHERE a.agencyLang = :agencyLang")})
public class Agency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "agency_id")
    private String agencyId;
    @Basic(optional = false)
    @Column(name = "agency_name")
    private String agencyName;
    @Basic(optional = false)
    @Column(name = "agency_url")
    private String agencyUrl;
    @Basic(optional = false)
    @Column(name = "agency_timezone")
    private String agencyTimezone;
    @Basic(optional = false)
    @Column(name = "agency_lang")
    private String agencyLang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencyId")
    private List<Route> routeList;

    public Agency() {
    }

    public Agency(String agencyId) {
	this.agencyId = agencyId;
    }

    public Agency(String agencyId, String agencyName, String agencyUrl, String agencyTimezone, String agencyLang) {
	this.agencyId = agencyId;
	this.agencyName = agencyName;
	this.agencyUrl = agencyUrl;
	this.agencyTimezone = agencyTimezone;
	this.agencyLang = agencyLang;
    }

    public String getAgencyId() {
	return agencyId;
    }

    public void setAgencyId(String agencyId) {
	this.agencyId = agencyId;
    }

    public String getAgencyName() {
	return agencyName;
    }

    public void setAgencyName(String agencyName) {
	this.agencyName = agencyName;
    }

    public String getAgencyUrl() {
	return agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
	this.agencyUrl = agencyUrl;
    }

    public String getAgencyTimezone() {
	return agencyTimezone;
    }

    public void setAgencyTimezone(String agencyTimezone) {
	this.agencyTimezone = agencyTimezone;
    }

    public String getAgencyLang() {
	return agencyLang;
    }

    public void setAgencyLang(String agencyLang) {
	this.agencyLang = agencyLang;
    }

    @XmlTransient
    public List<Route> getRouteList() {
	return routeList;
    }

    public void setRouteList(List<Route> routeList) {
	this.routeList = routeList;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (agencyId != null ? agencyId.hashCode() : 0);
	return hash;
    }

    @Override
    public boolean equals(Object object) {
	// TODO: Warning - this method won't work in the case the id fields are not set
	if (!(object instanceof Agency)) {
	    return false;
	}
	Agency other = (Agency) object;
	if ((this.agencyId == null && other.agencyId != null) || (this.agencyId != null && !this.agencyId.equals(other.agencyId))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "entity.Agency[ agencyId=" + agencyId + " ]";
    }
    
}
