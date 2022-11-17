package com.example.real_state_consortium.services;

import com.example.real_state_consortium.DTOs.Name;
import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.utils.ElementsOfView;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public interface ModelFactoryService {
    void searchSubString(String subString, TextArea textArea);
    void ChangeNameAtFruit();

    ArrayList<Name> returnArrayNames();

    void sortNames();

    List<Name> returnNameSort();

    void addHash(String key, String value);

    void deleteHash(String key);

    void printHash();

    void addElementCar(Label lbUnits, Label lbDisponibility, TextField tfEnterStock, Label lbPrice, Label lbNameProduct);

    void addElementInCar(ModelFactoryController mfc,String btn , String lbUnits, String lbDisponibility, String tfEnterStock, String lbPrice, String lbNameProduct);

    void calculateStructure( ModelFactoryController mfc,float metersBackground,float meterFront,int floors,int extract,String stucture);

    void deleteStructureFalse();

    List<Structure> getStructures();

    ArrayList<DataElements> returnDataPaint();

    ArrayList<DataElements> returnDataToilet();

    ArrayList<ElementsOfView> getElementsInTheView();

    Structure getStructureClass();

    ArrayList<Data3> getListAllElementsCar();
}
