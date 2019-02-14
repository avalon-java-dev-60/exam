/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MultatulyIM
 */
@Entity
@Table(name = "TPARAMETERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tparameters.findAll", query = "SELECT t FROM Tparameters t")
    , @NamedQuery(name = "Tparameters.findByNameP", query = "SELECT t FROM Tparameters t WHERE t.nameP = :nameP")
    , @NamedQuery(name = "Tparameters.findByValueP", query = "SELECT t FROM Tparameters t WHERE t.valueP = :valueP")})
public class Tparameters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME_P")
    private String nameP;
    @Column(name = "VALUE_P")
    private Integer valueP;
    @JoinColumn(name = "UID", referencedColumnName = "UID")
    @ManyToOne
    private Tuser uid;

    public Tparameters() {
    }

    public Tparameters(String nameP) {
        this.nameP = nameP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public Integer getValueP() {
        return valueP;
    }

    public void setValueP(Integer valueP) {
        this.valueP = valueP;
    }

    public Tuser getUid() {
        return uid;
    }

    public void setUid(Tuser uid) {
        this.uid = uid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nameP != null ? nameP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tparameters)) {
            return false;
        }
        Tparameters other = (Tparameters) object;
        if ((this.nameP == null && other.nameP != null) || (this.nameP != null && !this.nameP.equals(other.nameP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Tparameters[ nameP=" + nameP + " ]";
    }
    
}
