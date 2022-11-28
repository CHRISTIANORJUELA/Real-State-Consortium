package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class PaintHomeController implements BarCollectionPrincipal1, AddElement {
    @Override
    public void addElement(ActionEvent e) {
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
