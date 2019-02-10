package database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMS")
@NamedQueries({
    @NamedQuery(
            name = "parameter.findParam",
            query = "SELECT p FROM DBParameter AS p WHERE p.param = :param"
            
    )
    ,     
    @NamedQuery(
            name = "parameter.findTemplate",
            query = "SELECT p FROM DBParameter p"
    )
    ,
    @NamedQuery(
            name = "parameter.findInterval",
            query = "SELECT p FROM DBParameter p"
    )
})

public class DBParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PARAM")
    private String param;
    @Column(name = "VAL")
    private int value;

    public DBParameter() {
    }

    public String getParam() {
        return param;
    }

    public int getValue() {
        return value;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object
    ) {
        return object instanceof DBParameter && object.hashCode() == hashCode();
    }

}
