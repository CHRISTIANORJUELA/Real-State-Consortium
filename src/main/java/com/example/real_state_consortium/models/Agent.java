package com.example.real_state_consortium.models;

public class Agent extends Person {
    private int antiquity;
    private float remuneration;

    public Agent(String name, String document, int antiquity,float remuneration) {
        super(name, document);
        this.antiquity = antiquity;
        this.remuneration = remuneration;
    }

    public int getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(int antiquity) {
        this.antiquity = antiquity;
    }

    public float getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(float remuneration) {
        this.remuneration = remuneration;
    }
}
