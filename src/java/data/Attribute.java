package data;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Ella
 */

public class Attribute {
    
    private ArrayList<Parameter> store = new ArrayList<Parameter>();
    
    public void addParameter(String name, String value) {
        Parameter param = new Parameter(name, value);
        if(store.contains(param)){
            int index = store.indexOf(param);
            store.get(index).setValue(value);
        } else {
            store.add(param);
        }
    }
    public ArrayList<Parameter> getParametersAll() {
        return store;
    }
    
    public ArrayList<Parameter> getParametersByPattern(String pattern) {
        ArrayList<Parameter> storePartial = new ArrayList<Parameter>();
        Pattern oPattern = Pattern.compile(pattern);
        for(Parameter param: store) {
            String name = param.getName();
            Matcher matcher = oPattern.matcher(name);
            if(matcher.find()) {
                storePartial.add(param);
            }
        }       
        return storePartial;
    }
    
    public ArrayList<Parameter> getParametersByInterval(int start, int end) {
        ArrayList<Parameter> storePartial = new ArrayList<Parameter>();
        for(Parameter param: store) {
            int value = param.getValue();
            if(start <= value && value <= end) {
                storePartial.add(param);
            }
        } 
        return storePartial;
    }
}
