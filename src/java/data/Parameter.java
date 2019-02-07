package data;

import java.util.Objects;

/**
 *
 * @author Ella
 */
public class Parameter {
    private String name;
    private int value;
    
    public Parameter(String name, String value) {
        this.name = name;
        this.value = Integer.parseInt(value);
    }
  
    public void setValue(String newValue) {
       this.value = Integer.parseInt(newValue); 
    }
    
    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "<li>" + name + " - " + value + "</li>";
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parameter other = (Parameter) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
