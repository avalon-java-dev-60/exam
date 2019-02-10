/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Victor.Malmygin
 */
public class Parameter {
    
    private String data_name;
    private int value;

    public Parameter(String data_name, int value) {
        this.data_name = data_name;
        this.value = value;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public void setNewValue(String value) {
        this.value = Integer.parseInt(value);
    }
}
