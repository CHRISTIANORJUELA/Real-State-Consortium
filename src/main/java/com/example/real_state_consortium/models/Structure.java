package com.example.real_state_consortium.models;

public class Structure {
    private String typeStructure;
    private int floors;
    private float front;
    private float width;
    private String typeZone;
    private float squareMeters;
    private float pricePerMeter2;

    public Structure(String typeStructure, int floors, float front , float width , String typeZone ,float squareMeters ,float pricePerMeter2) {
        this.typeStructure = typeStructure;
        this.floors = floors;
        this.front = front;
        this.width = width;
        this.typeZone = typeZone;
        this.squareMeters = squareMeters;
        this.pricePerMeter2 = pricePerMeter2;
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

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getTypeZone() {
        return typeZone;
    }

    public void setTypeZone(String typeZone) {
        this.typeZone = typeZone;
    }

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
}
