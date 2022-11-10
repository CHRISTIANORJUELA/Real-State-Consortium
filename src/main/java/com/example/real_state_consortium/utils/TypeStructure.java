package com.example.real_state_consortium.utils;

public enum TypeStructure {
    BUILDING("Edificio"),
    MANSION("Mansión"),
    HOUSE("House");
    private String nameStructure;
    TypeStructure(String nameStructure){
        this.nameStructure = nameStructure;
    }

    public String getNameStructure() {
        return nameStructure;
    }
}
