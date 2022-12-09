package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.Receipt;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.models.Data3;
import com.example.real_state_consortium.utils.ElementsOfView;
import com.example.real_state_consortium.services.Impl.Instances;
import com.example.real_state_consortium.services.ModelFactoryService;
import java.util.ArrayList;
public class ModelFactoryController implements ModelFactoryService {
    Instances instances;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        instances = new Instances();
    }

    //****************************************************************************************//
    //************************REAL STATE CONSORTIUM****************************************************************


    public void addElementIncarr(ModelFactoryController mfc, Instances instances, String btn , String lbUnits, String lbDisponibility, String tfEnterStock, String lbPrice, String lbNameProduct){
        instances.getAddAtCarImpl().addElementInCar(mfc, instances, btn ,  lbUnits,  lbDisponibility,  tfEnterStock,  lbPrice,  lbNameProduct);
    }

    public  void clearData(){
        instances.getAddAtCarImpl().clearData();
    }

    public  ArrayList<ElementsOfView> getElementsInTheView(){return instances.getCarServiceImpl().getElementsInTheView();}

    public void calculateStructure( ModelFactoryController mfc,double metersBackground,double meterFront,int floors,int extract,String stucture){
        instances.getStructureServiceImpl().calculateStructure(mfc,metersBackground,meterFront,floors,extract,stucture);
    }

    public  void setNullStructureClassObject(){
        instances.getStructureServiceImpl().setNullStructureClassObject();
    }

    public void loginAgent(String nameAgent,String passWordAgent,ArrayList<ValidateAgent> agents){instances.getLoginServiceImpl().loginAgent(nameAgent,passWordAgent,agents);}

    public boolean registerAgent(String nameAgent, String passWordAgent){return instances.getRegisterServiceImpl().registerAgent(nameAgent,passWordAgent);}

    public void addAgent(String name,String passWord,ArrayList<ValidateAgent> list){
        instances.getAgentServiceImpl().addAgent(name,passWord,list);
    }

    public void deleteAgentInTable(ValidateAgent agentSelect){instances.getAgentServiceImpl().deleteAgentInTable(agentSelect);}

    public void modifyAgents(ValidateAgent v,String name,String passWord){instances.getAgentServiceImpl().modifyAgents(v,name,passWord);}

    public void searchAgent(String name){
        instances.getAgentServiceImpl().searchAgent(name);
    }

    public ArrayList<ValidateAgent> returnAgentsFilter(){return instances.getAgentServiceImpl().returnAgentsFilter();}

    public ArrayList<Data3> getListAllElementsCar(){
     return instances.getCarServiceImpl().getListAllElementsCar();
    }

    public Structure getStructureClass(){
        return instances.getStructureServiceImpl().getStructureClass();
    }

    public void finallySell(String nameClient, String nameAgent, String typeTarget, String numberTargetCredit, ArrayList<Data3> allElementsInCar, Structure structure) {
        instances.getFinallySellimpl().finallySell(nameClient, nameAgent , typeTarget, numberTargetCredit ,allElementsInCar,structure);
    }
    public ArrayList<ValidateAgent> returnAgentsIntable(ArrayList<ValidateAgent> list){return instances.getAgentServiceImpl().returnAgentsIntable(list);}

    public ArrayList<Receipt> getReceiptFinal(){return instances.getFinallySellimpl().getReceiptFinal();}

    public boolean getPassLogin(){
        return instances.getLoginServiceImpl().getPassLogin();
    }

    public ArrayList<ValidateAgent> getAgents(){
        return instances.getRegisterServiceImpl().getAgents();
    }
}
