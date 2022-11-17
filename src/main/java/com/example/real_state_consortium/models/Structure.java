package com.example.real_state_consortium.models;

public class Structure {
    private String typeStructure;
    private int floors;
    private float front;
    private float background;
    private int extractStructure;
    private float squareMeters;
    private float pricePerMeter2;
    private float totalPriceOfStructure;
    private boolean structureWasSell;
    public Structure(String typeStructure, int floors, float front , float background , int extractStructure ,float squareMeters ,float pricePerMeter2,float totalPriceOfStructure) {
        this.typeStructure = typeStructure;
        this.floors = floors;
        this.front = front;
        this.background = background;
        this.extractStructure = extractStructure;
        this.squareMeters = squareMeters;
        this.pricePerMeter2 = pricePerMeter2;
        this.totalPriceOfStructure = totalPriceOfStructure;
        this.structureWasSell = false;
    }

    public Structure(){

    }
    public String getTypeStructure() {
        return typeStructure;
    }
    public void setTypeStructure(String typeStructure) {
        this.typeStructure = typeStructure;
    }
    public int getFloors() {
        return floors;
    }
    public void setFloors(int floors) {
        this.floors = floors;
    }
    public float getFront() {
        return front;
    }
    public void setFront(float front) {
        this.front = front;
    }
    public float getBackground() {
        return background;
    }
    public void setBackground(float background) {
        this.background = background;
    }
    public int getExtractStructure() {return extractStructure;}
    public void setExtractStructure(int extractStructure) {this.extractStructure = extractStructure;}
    public float getSquareMeters() {
        return squareMeters;
    }
    public void setSquareMeters(float squareMeters) {
        this.squareMeters = squareMeters;
    }
    public float getPricePerMeter2() {
        return pricePerMeter2;
    }
    public void setPricePerMeter2(float pricePerMeter2) {
        this.pricePerMeter2 = pricePerMeter2;
    }
    public float getTotalPriceOfStructure() {return totalPriceOfStructure;}
    public void setTotalPriceOfStructure(float totalPriceOfStructure) {this.totalPriceOfStructure = totalPriceOfStructure;}
    public boolean getStructureWasSell() {return structureWasSell;}
    public void setStructureWasSell(boolean structureWasSell) {this.structureWasSell = structureWasSell;}
}
