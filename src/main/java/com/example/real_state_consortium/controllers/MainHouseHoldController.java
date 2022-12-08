package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.BarCollectionPrincipal1;
import com.example.real_state_consortium.utils.ChangeViewGeneral;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class MainHouseHoldController implements BarCollectionPrincipal1 {
    public void decorationHome(MouseEvent e) throws IOException {
        ChangeViewGeneral.decorationHome(e);
    }
    public void funny(MouseEvent e) throws IOException{
        ChangeViewGeneral.funny(e);
    }
    public void goBack(MouseEvent e) throws IOException{
       ChangeViewGeneral.goBack(e);
    }

}
