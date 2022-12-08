package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.services.RegisterService;
import com.example.real_state_consortium.utils.PrintMessage;

import java.util.ArrayList;

public class RegisterServiceImpl implements RegisterService {
    private ArrayList<ValidateAgent> agents;
    public boolean registerAgent(String nameAgent, String passWordAgent){
        initializeAgents();
        boolean passForChangeView = false;
        boolean passToRegisterRegister = agents.stream().anyMatch(x->x.getNameAgent().equalsIgnoreCase(passWordAgent.toLowerCase()) || x.getCode().equalsIgnoreCase(passWordAgent));
        if (passToRegisterRegister){
            PrintMessage.printMessage("Lo sentimos","La contraseña o el Nombre de Usuario ya exiten");
        }else {
            agents.add(new ValidateAgent(nameAgent,passWordAgent));
            PrintMessage.printMessage("Proceso","Se agrego correctamente el Agente");
            passForChangeView = true;
        }
        return passForChangeView;
    }
    public void initializeAgents(){
        if (agents == null){
            agents = new ArrayList<>();
            agents.add(new ValidateAgent("Maria","349240"));
            agents.add(new ValidateAgent("Veronica","204024"));
        }
    }

    public ArrayList<ValidateAgent> getAgents(){
        initializeAgents();
        return agents;
    }
}
