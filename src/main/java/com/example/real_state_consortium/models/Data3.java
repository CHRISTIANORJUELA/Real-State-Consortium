package com.example.real_state_consortium.models;

public class Data3 {
    private String nameElement;
    private int stockElement;
    private double value;

    public Data3(String nameElement, int stockElement, double value) {
        this.nameElement = nameElement;
        this.stockElement = stockElement;
        this.value = value;
    }

    public String getNameElement() {
        return nameElement;
    }
    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }
    public int getStockElement() {
        return stockElement;
    }
    public void setStockElement(int stockElement) {
        this.stockElement = stockElement;
    }
    public double getValue() {
        return value;
    }

    public void setValue(double price) {
        this.value = price;
    }

    @Override
    public String toString() {
        return "Data3{" +
                "nameElement='" + nameElement + '\'' +
                ", stockElement=" + stockElement +
                ", value=" + value +
                '}';
    }
}
