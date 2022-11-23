package com.example.real_state_consortium;

import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HelloController {

    private Stage stage;
    private Scene scene;

    public void watchCatalog(MouseEvent e)  throws IOException{
        ChangeViewParticular.watchCatalog(e);
    }

    public void enterAtLogin(MouseEvent e) throws IOException{
        ChangeViewParticular.enterAtLogin(e);
    }

    public void quoteProperty(MouseEvent e) throws IOException{
        ChangeViewParticular.quoteProperty(e);
    }
}