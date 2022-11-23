package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import com.example.real_state_consortium.utils.UtilsMethods1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfPassword;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void confirmRegister(ActionEvent e) throws IOException{
      if (UtilsMethods1.validateIscampusStringIsTrue(tfName.getText()) && tfPassword.getText() != null){
          String nameAgent = tfName.getText();
          String passWordAgent = tfPassword.getText();
          if (mfc.registerAgent(nameAgent,passWordAgent)){
              ChangeViewParticular.enterAtLoginWithActioEvent(e);
          };
      }
    }

    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }
}
