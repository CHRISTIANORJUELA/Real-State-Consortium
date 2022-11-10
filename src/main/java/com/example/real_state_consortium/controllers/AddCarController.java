package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.BarCollectionPrincipal1;
import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import javafx.scene.input.MouseEvent;
import java.io.IOException;


public class AddCarController implements BarCollectionPrincipal1 {



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

    public void continueWithBuy(MouseEvent e) throws IOException{
        ChangeViewParticular.continueWithBuy(e);
    }




}
