package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.services.LoginService;

import java.util.ArrayList;

public class LoginServiceImpl implements LoginService {
    private boolean passLogin = false;
    public void loginAgent(String nameAgent, String passWordAgent, ArrayList<ValidateAgent> agents){
      boolean passTologin = agents.stream().anyMatch(x->x.getNameAgent().equalsIgnoreCase(nameAgent.toLowerCase()) && x.getCode().equalsIgnoreCase(passWordAgent));
      if (passTologin){
          passLogin = true;
      }
    }

    public boolean getPassLogin(){
        return passLogin;
    }
}
