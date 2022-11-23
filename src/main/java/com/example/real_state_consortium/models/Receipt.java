package com.example.real_state_consortium.models;

import com.example.real_state_consortium.utils.Data3;
import java.time.LocalDate;
import java.util.ArrayList;
public class Receipt {
    private String nameAgent;
    private String nameBuyer;
    private ArrayList<Data3> elementsAdded;
    private Structure structure;
    private Float priceSell;
    private LocalDate daySell;
    private boolean passed;

    public Receipt(String nameAgent, String nameBuyer, ArrayList<Data3> elementsAdded, Structure structure , Float priceSell , LocalDate daySell , boolean passed) {
        this.nameAgent = nameAgent;
        this.nameBuyer = nameBuyer;
        this.elementsAdded = elementsAdded;
        this.structure = structure;
        this.priceSell = priceSell;
        this.daySell = daySell;
        this.passed = passed;
    }

    public Receipt(String nameAgent, String nameBuyer, ArrayList<Data3> elementsAdded , Float priceSell , LocalDate daySell , boolean passed){
        this.nameAgent = nameAgent;
        this.nameBuyer = nameBuyer;
        this.elementsAdded = elementsAdded;
        this.priceSell = priceSell;
        this.daySell = daySell;
        this.passed = passed;
    }

    public Receipt(String nameAgent, String nameBuyer,Structure structure, Float priceSell , LocalDate daySell , boolean passed){
        this.nameAgent = nameAgent;
        this.nameBuyer = nameBuyer;
        this.structure = structure;
        this.priceSell = priceSell;
        this.daySell = daySell;
        this.passed = passed;
    }



    public String getNameAgent() {
        return nameAgent;
    }

    public void setNameAgent(String nameAgent) {
        this.nameAgent = nameAgent;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }

    public ArrayList<Data3> getElementsAdded() {
        return elementsAdded;
    }

    public void setElementsAdded(ArrayList<Data3> elementsAdded) {
        this.elementsAdded = elementsAdded;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public Float getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Float priceSell) {
        this.priceSell = priceSell;
    }

    public LocalDate getDaySell() {
        return daySell;
    }

    public void setDaySell(LocalDate daySell) {
        this.daySell = daySell;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

}
