/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MultatulyIM
 */
@Entity
@Table(name = "TUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tuser.findAll", query = "SELECT t FROM Tuser t")
    , @NamedQuery(name = "Tuser.findByUid", query = "SELECT t FROM Tuser t WHERE t.uid = :uid")
    , @NamedQuery(name = "Tuser.findByNameU", query = "SELECT t FROM Tuser t WHERE t.nameU = :nameU")})
public class Tuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UID")
    private Integer uid;
    @Size(max = 32)
    @Column(name = "NAME_U")
    private String nameU;
    @OneToMany(mappedBy = "uid")
    private Collection<Tparameters> tparametersCollection;

    public Tuser() {
    }

    public Tuser(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    @XmlTransient
    public Collection<Tparameters> getTparametersCollection() {
        return tparametersCollection;
    }

    public void setTparametersCollection(Collection<Tparameters> tparametersCollection) {
        this.tparametersCollection = tparametersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tuser)) {
            return false;
        }
        Tuser other = (Tuser) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Tuser[ uid=" + uid + " ]";
    }
    
}
