package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.services.AgentService;
import com.example.real_state_consortium.utils.PrintMessage;
import java.util.ArrayList;

public class AgentServiceImpl implements AgentService {
    ArrayList<ValidateAgent> agentsInTable;
    ArrayList<ValidateAgent> agentsIntableFilter;

    public void addAgent(String name,String passWord,ArrayList<ValidateAgent> list){
        initializeAgentsIntable(list);
        boolean passToaddAgent = agentsInTable.stream().anyMatch(x->x.getNameAgent().equalsIgnoreCase(name) || x.getCode().equalsIgnoreCase(passWord));
        if (passToaddAgent){
            PrintMessage.printMessage("Lo sentimos","El nombre de usurio o la contraseña ya existen");
        }else {
            agentsInTable.add(new ValidateAgent(name,passWord));
        }
    }

    public void deleteAgentInTable(ValidateAgent agentSelect){
     if (agentsInTable.size()>2){
         agentsInTable.remove(agentSelect);
     }else {
         PrintMessage.printMessageWarning("Recuerda","Siempre tienen que haber almenos dos Agentes Activos para que puedan Realizar Ventas");
     }
    }

    public void modifyAgents(ValidateAgent v,String name,String passWord){
        if (checkCondition(agentsInTable,name,passWord)==0){
            agentsInTable.forEach(x->{
                if (x.getNameAgent().equalsIgnoreCase(v.getNameAgent()) && x.getCode().equalsIgnoreCase(v.getCode())){
                    x.setNameAgent(name);
                    x.setCode(passWord);
                }
            });
        }else if(checkCondition(agentsInTable,name,passWord)==1){
            agentsInTable.forEach(x->{
                if (x.getNameAgent().equalsIgnoreCase(name.toLowerCase()) || x.getCode().equalsIgnoreCase(passWord)){
                    x.setNameAgent(name);
                    x.setCode(passWord);
                }
            });
        }else {
            PrintMessage.printMessage("Acción fallida","El nombre o la contraseña que quieres poner nueva !ya existen¡");
        }
    }

    public long checkCondition(ArrayList<ValidateAgent> agentsInTable,String name,String passWord){
         return agentsInTable.stream().filter(x->x.getNameAgent().equalsIgnoreCase(name.toLowerCase()) || x.getCode().equalsIgnoreCase(passWord)).count();
    }

    public void searchAgent(String name){
        initializeAgentsFilter();
        agentsIntableFilter.clear();
        agentsInTable.stream().filter(x->x.getNameAgent().contains(name)).forEach(x->{
            agentsIntableFilter.add(x);
        });
    }

    public void initializeAgentsIntable(ArrayList<ValidateAgent> list){
        if (agentsInTable == null){
            agentsInTable = list;
        }
    }

    public void initializeAgentsFilter(){
        if (agentsIntableFilter == null){
            agentsIntableFilter = new ArrayList<>();
        }
    }

    public ArrayList<ValidateAgent> returnAgentsIntable(ArrayList<ValidateAgent> list){
        initializeAgentsIntable(list);
        return agentsInTable;
    }

    public ArrayList<ValidateAgent> returnAgentsFilter(){
        initializeAgentsFilter();
        return agentsIntableFilter;
    }


}
