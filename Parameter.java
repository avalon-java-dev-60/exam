/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static java.lang.Integer.parseInt;

/**
 *
 * @author MultatulyIM
 */
public class Parameter {
    private String name;
    private int value;
    public Parameter(){
        this.name="";
        this.value=0;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int convValue(String p_value){
        return parseInt(p_value);
    }
        
    public String convStr(){
        return "<li>"+this.name+" - "+this.value+"</li>";
    } 
    
}
