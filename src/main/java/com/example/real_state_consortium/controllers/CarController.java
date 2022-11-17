package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.BarCollectionPrincipal1;
import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import com.example.real_state_consortium.utils.Data3;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class CarController implements Initializable,BarCollectionPrincipal1 {



    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllElementsInCar();
    }

    private void getAllElementsInCar() {
        ArrayList<Data3> s = mfc.getListAllElementsCar();
        if (s.size()>0){
            s.forEach(x-> System.out.println(x.toString()));
        }
    }

    public void decorationHome(MouseEvent e) throws IOException {
        ChangeViewGeneral.decorationHome(e);
    }

    public void funny(MouseEvent e) throws IOException{
        ChangeViewGeneral.funny(e);
    }

    public void relaxation(MouseEvent e) throws IOException{
        ChangeViewGeneral.relaxation(e);
    }

    public void goBack(MouseEvent e) throws IOException{
        ChangeViewGeneral.goBack(e);
    }

    public void continueWithBuy(MouseEvent e) throws IOException{
        ChangeViewParticular.continueWithBuy(e);
    }



}
