package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.services.AgentService;
import com.example.real_state_consortium.utils.PrintMessage;

import java.util.ArrayList;
import java.util.Optional;

public class AgentServiceImpl implements AgentService {
    ArrayList<ValidateAgent> agentsInTable;
    ArrayList<ValidateAgent> agentsIntableFilter;

    public void addAgent(String name,String passWord){
        initializeAgentsIntable();
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
                //notNameInList(name);
                //notCodeInList(passWord);
            /*if(notNameInList(name)){}
            int contName = 0;
            int contPassWord = 0;
            for (int i=0;i<agentsInTable.size();i++){
                if (agentsInTable.get(i).getNameAgent().equalsIgnoreCase(name.toLowerCase())){
                    contName++;
                }
                if (agentsInTable.get(i).getCode().equalsIgnoreCase(passWord)){
                    contPassWord++;
                }
            }
            if (contName<=0){
                modifyName;
            }

             */
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


    public void initializeAgentsIntable(){
        if (agentsInTable == null){
            agentsInTable = new ArrayList<>();
            agentsInTable.add(new ValidateAgent("Manuela","984782"));
            agentsInTable.add(new ValidateAgent("Maria","449424"));
        }
    }

    public void initializeAgentsFilter(){
        if (agentsIntableFilter == null){
            agentsIntableFilter = new ArrayList<>();
        }
    }

    public ArrayList<ValidateAgent> returnAgentsIntable(){
        initializeAgentsIntable();
        return agentsInTable;
    }

    public ArrayList<ValidateAgent> returnAgentsFilter(){
        initializeAgentsFilter();
        return agentsIntableFilter;
    }


}
