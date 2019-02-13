/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parambase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ella
 */
@Entity
@Table(name = "PARAMETERS")
@NamedQueries({
    @NamedQuery(name = "Parameters.findAll", query = "SELECT p FROM Parameters AS p  "
            )
    , @NamedQuery(name = "Parameters.findByName", query = "SELECT p FROM Parameters AS p WHERE p.name = :name "
            )
    , @NamedQuery(name = "Parameters.findByPattern", query = "SELECT p FROM Parameters AS p WHERE "
            + "p.name like :pattern "
            )
    , @NamedQuery(name = "Parameters.findByValue", query = "SELECT p FROM Parameters AS p WHERE "
            + "p.value >= :min_value and p.value <= :max_value "
            )})

public class Parameters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE")
    private int value;
   
    
   

    public Parameters() {
    }

    public Parameters(long id) {
        this.id = id;
    }

    public Parameters(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Parameters && object.hashCode() == hashCode();
    }
}