package com.example.real_state_consortium.utils;

public enum TypeStructure {
    BUILDING("Edificio",200000),
    MANSION("Mansión",150000),
    HOUSE("Casa",50000);
    private String nameStructure;
    private float priceStructure;
    TypeStructure(String nameStructure, float priceStructure){
        this.nameStructure = nameStructure;
        this.priceStructure = priceStructure;
    }

    public String getNameStructure() {
        return nameStructure;
    }

    public float getPriceStructure() {
        return priceStructure;
    }
}
