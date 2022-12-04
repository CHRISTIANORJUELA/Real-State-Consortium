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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController{
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPassword;

    ModelFactoryController mfc = ModelFactoryController.getInstance();
    public void comfirmLogin(ActionEvent e) throws IOException {
       if(UtilsMethods1.validateIscampusStringIsTrue(tfName.getText()) && tfPassword.getText() != null){
           String nameAgent = tfName.getText();
           String passWordAgent = tfPassword.getText();
           mfc.loginAgent(nameAgent,passWordAgent,mfc.getAgents());
           if (mfc.getPassLogin()){
               ChangeViewParticular.sendMainPerson(e);
           }else {
               PrintMessage.printMessageWarning("Lo sentimos","Aun no tienes una cuenta registrate para poder entrar");
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
