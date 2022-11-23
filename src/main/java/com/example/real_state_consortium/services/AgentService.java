package com.example.real_state_consortium.services;

import com.example.real_state_consortium.models.ValidateAgent;

import java.util.ArrayList;

public interface AgentService {
    ArrayList<ValidateAgent> returnAgentsIntable();

    void addAgent(String name,String passWord);

    void deleteAgentInTable(ValidateAgent agentSelect);

    void modifyAgents(ValidateAgent v,String name,String passWord);

    void searchAgent(String name);

    ArrayList<ValidateAgent> returnAgentsFilter();
}
