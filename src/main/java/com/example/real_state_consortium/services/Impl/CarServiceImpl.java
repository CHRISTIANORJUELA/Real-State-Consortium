package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.ElementsOfView;
import com.example.real_state_consortium.services.CarService;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarServiceImpl implements CarService {
    ArrayList<Data3> listAllElementsCar = new ArrayList<>();
    ArrayList<ElementsOfView> elementsInTheView = new ArrayList<>();




    public ArrayList<Data3> getListAllElementsCar() {
        return listAllElementsCar;
    }

    public  ArrayList<ElementsOfView> getElementsInTheView(){
        return elementsInTheView;
    }
}
