package database;

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
@Table(name = "PARAMS")
@NamedQueries({
    @NamedQuery(name = "Params.findAllByUser", query = "SELECT p FROM Params AS p WHERE "
            + "p.userId = :user_id")
    , @NamedQuery(name = "Params.findByName", query = "SELECT p FROM Params AS p WHERE p.name = :name "
            + "and p.userId = :user_id")
    , @NamedQuery(name = "Params.findByPattern", query = "SELECT p FROM Params AS p WHERE "
            + "p.name like :pattern "
            + "and p.userId = :user_id")
    , @NamedQuery(name = "Params.findByRange", query = "SELECT p FROM Params AS p WHERE "
            + "p.value >= :min_value and p.value <= :max_value "
            + "and p.userId = :user_id")})

public class Params implements Serializable {

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
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Users userId;

    public Params() {
    }

    public Params(long id) {
        this.id = id;
    }

    public Params(String name, int value) {
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

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users id) {
        userId = id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Params && object.hashCode() == hashCode();
    }
}
