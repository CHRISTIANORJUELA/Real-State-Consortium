package com.example.real_state_consortium.services;

import com.example.real_state_consortium.models.ValidateAgent;

import java.util.ArrayList;

public interface RegisterService {
    boolean registerAgent(String nameAgent, String passWordAgent);

    ArrayList<ValidateAgent> getAgents();
}
