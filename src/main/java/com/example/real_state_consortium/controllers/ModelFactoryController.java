package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.DTOs.Name;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.utils.ElementsOfView;
import com.example.real_state_consortium.services.Impl.Laboratory;
import com.example.real_state_consortium.services.ModelFactoryService;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

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

    public void searchSubString(String subString, TextArea textArea){
        laboratory.getExercisesPracticeImpl().searchSubString(subString,textArea);
    }

    public void ChangeNameAtFruit(){
        laboratory.getExercisesPracticeImpl().ChangeNameAtFruit();
    }

    public ArrayList<Name> returnArrayNames(){
        return laboratory.getExercisesPracticeImpl().returnArrayNames();
    }

    public void sortNames(){
        laboratory.getExercisesPracticeImpl().sortNames();
    }

    public List<Name> returnNameSort(){
        return laboratory.getExercisesPracticeImpl().returnNameSort();
    }

    public void addHash(String key,String value){
        laboratory.getExercisesPracticeImpl().addHash(key, value);
    }

    public void deleteHash(String key){
        laboratory.getExercisesPracticeImpl().deleteHash(key);
    }

    public void printHash(){
        laboratory.getExercisesPracticeImpl().printHash();
    }

    //************************REAL STATE CONSORTIUM****************************************************************

    public void addElementCar(Label lbUnits, Label lbDisponibility, TextField tfEnterStock, Label lbPrice, Label lbNameProduct){
         laboratory.getPaintServiceImpl().addElementCar(lbUnits,lbDisponibility,tfEnterStock,lbPrice,lbNameProduct);
    }

    public void addElementInCar(ModelFactoryController mfc ,String btn , String lbUnits, String lbDisponibility, String tfEnterStock, String lbPrice, String lbNameProduct){
        laboratory.getAddAtCarImpl().addElementInCar(mfc,btn ,lbUnits,lbDisponibility,tfEnterStock,lbPrice,lbNameProduct);
    }

    public ArrayList<DataElements> returnDataPaint(){
        return laboratory.getPaintServiceImpl().initializeDataPaint();
    }

    public ArrayList<DataElements> returnDataToilet(){
        return laboratory.getToiletServiceImpl().initializeDataToilet();
    }

    public  ArrayList<ElementsOfView> getElementsInTheView(){
        return laboratory.getCarServiceImpl().getElementsInTheView();
    }

    public void calculateStructure( ModelFactoryController mfc,float metersBackground,float meterFront,int floors,int extract,String stucture){
        laboratory.getStructureServiceImpl().calculateStructure(mfc,metersBackground,meterFront,floors,extract,stucture);
    }

    public void deleteStructureFalse(){
        laboratory.getStructureServiceImpl().deleteStructureFalse();
    }

    public ArrayList<Data3> getListAllElementsCar(){
     return laboratory.getCarServiceImpl().getListAllElementsCar();
    }

    public List<Structure> getStructures(){
        return laboratory.getStructureServiceImpl().getStructures();
    }

    public Structure getStructureClass(){
        return laboratory.getStructureServiceImpl().getStructureClass();
    }

}
