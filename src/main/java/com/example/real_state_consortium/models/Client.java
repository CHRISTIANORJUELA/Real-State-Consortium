package com.example.real_state_consortium.models;

import kotlin.jvm.internal.SpreadBuilder;

public class Client extends Person {
    private String typeTargetCredit;
    private String numberTarjetCredit;
    private int customerSupport;

    public Client(String name, String document, String typeTargetCredit, String numberTarjetCredit, int customerSupport) {
        super(name, document);
        this.typeTargetCredit = typeTargetCredit;
        this.numberTarjetCredit = numberTarjetCredit;
        this.customerSupport = customerSupport;
    }

    public String getTypeTargetCredit() {
        return typeTargetCredit;
    }

    public void setTypeTargetCredit(String typeTargetCredit) {
        this.typeTargetCredit = typeTargetCredit;
    }

    public String getNumberTarjetCredit() {
        return numberTarjetCredit;
    }

    public void setNumberTarjetCredit(String numberTarjetCredit) {
        this.numberTarjetCredit = numberTarjetCredit;
    }

    public int getCustomerSupport() {
        return customerSupport;
    }

    public void setCustomerSupport(int customerSupport) {
        this.customerSupport = customerSupport;
    }
}
