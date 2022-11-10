package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.ChangeViewGeneral;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StructureController {
    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }
}
