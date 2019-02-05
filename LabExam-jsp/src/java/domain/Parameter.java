package domain;

public class Parameter {

    String parameter;
    int value;

    public Parameter(String parameter, int value) {
        this.parameter = parameter;
        this.value = value;
    }

    public String printInfo() {
        String string= this.parameter + " " + String.valueOf(this.value);
        return string;
    }

    public String getParameter() {
        return parameter;
    }

    public int getValue() {
        return value;
    }

    public String changeParam(String parameter) {
        this.parameter = parameter;
        return this.parameter;
    }

    public int changeValue(String parameter, String value) {
        this.value = Integer.parseInt(value);
        return this.value;
    }

}
