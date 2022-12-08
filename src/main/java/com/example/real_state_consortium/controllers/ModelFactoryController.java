package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.Receipt;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.models.Data3;
import com.example.real_state_consortium.utils.ElementsOfView;
import com.example.real_state_consortium.services.Impl.Laboratory;
import com.example.real_state_consortium.services.ModelFactoryService;
import java.util.ArrayList;
public class ModelFactoryController implements ModelFactoryService {
    Laboratory laboratory;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        laboratory = new Laboratory();
    }

    //****************************************************************************************//
    //************************REAL STATE CONSORTIUM****************************************************************


    public void addElementIncarr(ModelFactoryController mfc, Laboratory laboratorium, String btn , String lbUnits, String lbDisponibility, String tfEnterStock, String lbPrice, String lbNameProduct){
        laboratory.getAddAtCarImpl().addElementInCar(mfc, laboratorium, btn ,  lbUnits,  lbDisponibility,  tfEnterStock,  lbPrice,  lbNameProduct);
    }

    public  void clearData(){
        laboratory.getAddAtCarImpl().clearData();
    }

    public  ArrayList<ElementsOfView> getElementsInTheView(){return laboratory.getCarServiceImpl().getElementsInTheView();}

    public void calculateStructure( ModelFactoryController mfc,double metersBackground,double meterFront,int floors,int extract,String stucture){
        laboratory.getStructureServiceImpl().calculateStructure(mfc,metersBackground,meterFront,floors,extract,stucture);
    }

    public  void setNullStructureClassObject(){
        laboratory.getStructureServiceImpl().setNullStructureClassObject();
    }

    public void loginAgent(String nameAgent,String passWordAgent,ArrayList<ValidateAgent> agents){laboratory.getLoginServiceImpl().loginAgent(nameAgent,passWordAgent,agents);}

    public boolean registerAgent(String nameAgent, String passWordAgent){return laboratory.getRegisterServiceImpl().registerAgent(nameAgent,passWordAgent);}

    public void addAgent(String name,String passWord,ArrayList<ValidateAgent> list){
        laboratory.getAgentServiceImpl().addAgent(name,passWord,list);
    }

    public void deleteAgentInTable(ValidateAgent agentSelect){laboratory.getAgentServiceImpl().deleteAgentInTable(agentSelect);}

    public void modifyAgents(ValidateAgent v,String name,String passWord){laboratory.getAgentServiceImpl().modifyAgents(v,name,passWord);}

    public void searchAgent(String name){
        laboratory.getAgentServiceImpl().searchAgent(name);
    }

    public ArrayList<ValidateAgent> returnAgentsFilter(){return laboratory.getAgentServiceImpl().returnAgentsFilter();}

    public ArrayList<Data3> getListAllElementsCar(){
     return laboratory.getCarServiceImpl().getListAllElementsCar();
    }

    public Structure getStructureClass(){
        return laboratory.getStructureServiceImpl().getStructureClass();
    }

    public void finallySell(String nameClient, String nameAgent, String typeTarget, String numberTargetCredit, ArrayList<Data3> allElementsInCar, Structure structure) {
        laboratory.getFinallySellimpl().finallySell(nameClient, nameAgent , typeTarget, numberTargetCredit ,allElementsInCar,structure);
    }
    public ArrayList<ValidateAgent> returnAgentsIntable(ArrayList<ValidateAgent> list){return laboratory.getAgentServiceImpl().returnAgentsIntable(list);}

    public ArrayList<Receipt> getReceiptFinal(){return laboratory.getFinallySellimpl().getReceiptFinal();}

    public boolean getPassLogin(){
        return laboratory.getLoginServiceImpl().getPassLogin();
    }

    public ArrayList<ValidateAgent> getAgents(){
        return laboratory.getRegisterServiceImpl().getAgents();
    }
}
