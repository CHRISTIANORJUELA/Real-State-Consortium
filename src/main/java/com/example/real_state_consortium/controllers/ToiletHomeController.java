package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.AddElement;
import com.example.real_state_consortium.utils.BarCollectionPrincipal1;
import com.example.real_state_consortium.utils.ChangeViewGeneral;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;


public class ToiletHomeController implements BarCollectionPrincipal1, AddElement {

    @FXML
    Label lbUnits;

    @FXML
    Label lbDisponibility;

    @FXML
    TextField tfEnterStock;

    @FXML
    Label lbPrice;

    @FXML
    Label lbNameProduct;


    public void addElement(ActionEvent e){
        Button button = (Button) e.getTarget();
        StartElementsOfController.firstStep(button);
    }



    public void watchCar(MouseEvent e) throws IOException{
        ChangeViewGeneral.watchCar(e);
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
}
