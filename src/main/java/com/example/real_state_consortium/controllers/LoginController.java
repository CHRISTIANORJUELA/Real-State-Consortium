package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.ChangeViewGeneral;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    AnchorPane bkgroup;
    public void initialize(URL url, ResourceBundle rbs){
        try {

        } catch (Exception b){

        }
    }





    public void comfirmLogin(ActionEvent e){

    }




    public void enterRegister(MouseEvent e) throws IOException{
        ChangeViewGeneral.enterRegister(e);
    }


    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }



}
