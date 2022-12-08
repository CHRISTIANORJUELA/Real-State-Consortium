package com.example.real_state_consortium.models;

public class ValidateAgent {
    private String nameAgent;
    private String code;

    public ValidateAgent(String nameAgent, String code) {
        this.nameAgent = nameAgent;
        this.code = code;
    }

    public String getNameAgent() {
        return nameAgent;
    }
    public void setNameAgent(String nameAgent) {
        this.nameAgent = nameAgent;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
