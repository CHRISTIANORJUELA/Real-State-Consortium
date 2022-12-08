package com.example.real_state_consortium.models;

public class DataElements extends Data3 {
    String disponibility;
    public DataElements(String nameElement, int stockElement, float price, String disponibility) {
        super(nameElement, stockElement, price);
        this.disponibility = disponibility;
    }

    public String getDisponibility() {
        return disponibility;
    }
    public void setDisponibility(String disponibility) {
        this.disponibility = disponibility;
    }
    @Override
    public String toString() {
        return "Name : "+getNameElement()+" Disponiblidad : "+getDisponibility()+" Cantidad : "+getStockElement()+" Precio :"+getValue();
    }
}
