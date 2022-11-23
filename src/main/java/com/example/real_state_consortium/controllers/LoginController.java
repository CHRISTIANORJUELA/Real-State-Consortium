package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import com.example.real_state_consortium.utils.PrintMessage;
import com.example.real_state_consortium.utils.UtilsMethods1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPassword;

    ModelFactoryController mfc = ModelFactoryController.getInstance();
    public void initialize(URL url, ResourceBundle rbs){

    }







    public void comfirmLogin(ActionEvent e) throws IOException {
       if(UtilsMethods1.validateIscampusStringIsTrue(tfName.getText()) && tfPassword.getText() != null){
           String nameAgent = tfName.getText();
           String passWordAgent = tfPassword.getText();
           mfc.loginAgent(nameAgent,passWordAgent,mfc.getAgents());
           if (mfc.getPassLogin()){
               ChangeViewParticular.sendMainPerson(e);
           }else {
               PrintMessage.printMessageYellow("Lo sentimos","Pero a un no tienes una cuenta");
           }
       }
    }




    public void enterRegister(MouseEvent e) throws IOException{
        ChangeViewGeneral.enterRegister(e);
    }


    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }



}
