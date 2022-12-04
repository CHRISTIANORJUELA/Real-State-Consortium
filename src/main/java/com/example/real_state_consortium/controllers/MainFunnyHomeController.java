package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.ChangeViewParticular;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainFunnyHomeController {
    public void sendGymFunny(MouseEvent e) throws IOException {
        ChangeViewParticular.sendGymFunny(e);
    }
}
