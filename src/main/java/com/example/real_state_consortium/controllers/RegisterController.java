package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.ChangeViewGeneral;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class RegisterController {

    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }

    public void confirmRegister(ActionEvent e) throws IOException{

    }
}
