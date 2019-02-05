package domain;

import java.util.ArrayList;
import java.util.List;

public class Attribute {

    ArrayList<Parameter> attribute;

    public Attribute() {
        attribute = new ArrayList<Parameter>();
    }

    public ArrayList<Parameter> getList() {
        return attribute;
    }


    public void add(Parameter param) {
        attribute.add(param);
    }

}
