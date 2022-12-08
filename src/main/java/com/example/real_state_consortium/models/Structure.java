package com.example.real_state_consortium.models;

public class Structure {
    private String typeStructure;
    private int floors;
    private double front;
    private double background;
    private int extractStructure;
    private double squareMeters;
    private double pricePerMeter2;
    private double totalPriceOfStructure;
    private boolean structureWasSell;
    public Structure(String typeStructure, int floors, double front , double background , int extractStructure ,double squareMeters ,double pricePerMeter2,double totalPriceOfStructure) {
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
    public double getFront() {
        return front;
    }
    public void setFront(double front) {
        this.front = front;
    }
    public double getBackground() {
        return background;
    }
    public void setBackground(double background) {
        this.background = background;
    }
    public int getExtractStructure() {return extractStructure;}
    public void setExtractStructure(int extractStructure) {this.extractStructure = extractStructure;}
    public double getSquareMeters() {
        return squareMeters;
    }
    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }
    public double getPricePerMeter2() {
        return pricePerMeter2;
    }
    public void setPricePerMeter2(double pricePerMeter2) {
        this.pricePerMeter2 = pricePerMeter2;
    }
    public double getTotalPriceOfStructure() {return totalPriceOfStructure;}
    public void setTotalPriceOfStructure(double totalPriceOfStructure) {this.totalPriceOfStructure = totalPriceOfStructure;}
    public boolean getStructureWasSell() {return structureWasSell;}
    public void setStructureWasSell(boolean structureWasSell) {this.structureWasSell = structureWasSell;}

    @Override
    public String toString() {
        return "Structure{" +
                "typeStructure='" + typeStructure + '\'' +
                ", floors=" + floors +
                ", front=" + front +
                ", background=" + background +
                ", extractStructure=" + extractStructure +
                ", squareMeters=" + squareMeters +
                ", pricePerMeter2=" + pricePerMeter2 +
                ", totalPriceOfStructure=" + totalPriceOfStructure +
                ", structureWasSell=" + structureWasSell +
                '}';
    }
}
