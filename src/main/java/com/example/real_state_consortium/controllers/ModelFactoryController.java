package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.DTOs.Name;
import com.example.real_state_consortium.services.Impl.Laboratory;
import com.example.real_state_consortium.services.ModelFactoryService;
import javafx.scene.control.TextArea;

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
}
