package com.example.real_state_consortium.services;

import com.example.real_state_consortium.models.ValidateAgent;
import java.util.ArrayList;
public interface AgentService {
    ArrayList<ValidateAgent> returnAgentsIntable(ArrayList<ValidateAgent> list);

    void addAgent(String name,String passWord,ArrayList<ValidateAgent> list);

    void deleteAgentInTable(ValidateAgent agentSelect);

    void modifyAgents(ValidateAgent v,String name,String passWord);

    void searchAgent(String name);

    ArrayList<ValidateAgent> returnAgentsFilter();
}
