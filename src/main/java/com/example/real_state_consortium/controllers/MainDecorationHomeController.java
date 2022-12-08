package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.BarCollectionDecorationHome;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainDecorationHomeController implements BarCollectionDecorationHome {
   public  void paintHome(MouseEvent e) throws IOException{
       ChangeViewParticular.paintHome(e);
    }
    public void kitchenHome(MouseEvent e) throws IOException{
     ChangeViewParticular.kitchenHome(e);
    }
    public void floorHome(MouseEvent e) throws IOException{
     ChangeViewParticular.floorHome(e);
    }
    public void toiletHome(MouseEvent e) throws IOException{
     ChangeViewParticular.toiletHome(e);
    }
}
