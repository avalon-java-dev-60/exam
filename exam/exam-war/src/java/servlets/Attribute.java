/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor.Malmygin
 */
public class Attribute {
    
    private List<Parameter> list;

    public Attribute() {
        list = new ArrayList<Parameter>();
    }

    public List<Parameter> getList() {
        return list;
    }
    
    public void add(Parameter prm){
        list.add(prm);
    }
}
