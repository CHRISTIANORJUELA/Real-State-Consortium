package com.example.real_state_consortium.models;

public class CheckUser {
    private String nameAgent;
    private String code;

    public CheckUser(String nameAgent, String code) {
        this.nameAgent = nameAgent;
        this.code = code;
    }

    public String getNameAgent() {
        return nameAgent;
    }

    public void setNameAgent(String nameAgent) {
        this.nameAgent = nameAgent;
    }


}
