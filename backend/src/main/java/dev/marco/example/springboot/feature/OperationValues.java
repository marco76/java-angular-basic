package dev.marco.example.springboot.feature;

public class OperationValues {
    private Integer valueA;
    private Integer valueB;

    public OperationValues() {
    }

    public OperationValues(Integer valueA, Integer valueB) {
        this.valueA = valueA;
        this.valueB = valueB;
    }
    public Integer getValueA() {
        return valueA;
    }

    public Integer getValueB() {
        return valueB;
    }

    public void setValueA(Integer valueA) {
        this.valueA = valueA;
    }

    public void setValueB(Integer valueB) {
        this.valueB = valueB;
    }
}
