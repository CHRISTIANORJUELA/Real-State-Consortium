package com.example.real_state_consortium.models;

public class Transaction {
    private String typeTargetCredit;
    private String numTargetCredit;
    private Float totalAmount;

    public Transaction(String typeTargetCredit, String numTargetCredit, Float totalAmount) {
        this.typeTargetCredit = typeTargetCredit;
        this.numTargetCredit = numTargetCredit;
        this.totalAmount = totalAmount;
    }

    public String getTypeTargetCredit() {
        return typeTargetCredit;
    }

    public void setTypeTargetCredit(String typeTargetCredit) {
        this.typeTargetCredit = typeTargetCredit;
    }

    public String getNumTargetCredit() {
        return numTargetCredit;
    }

    public void setNumTargetCredit(String numTargetCredit) {
        this.numTargetCredit = numTargetCredit;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
