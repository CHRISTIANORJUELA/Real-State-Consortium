package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.ChangeViewParticular;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainPersonController {

    public void seeAgentsCrud(MouseEvent e) throws IOException{
        ChangeViewParticular.seeAgentsCrud(e);
    }
}
