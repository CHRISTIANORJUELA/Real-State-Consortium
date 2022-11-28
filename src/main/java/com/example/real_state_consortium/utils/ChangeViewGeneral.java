package com.example.real_state_consortium.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChangeViewGeneral {
    private static Stage stage;
    private static Scene scene;
    public static void watchCar(MouseEvent e) throws IOException {
        URL url = new File("src/main/resources/com/example/real_state_consortium/addCar/addCarView.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
    public static void decorationHome(MouseEvent e) throws IOException {
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/mainDecorationHome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }


    public static void funny(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/mainFunnyHome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void relaxation(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/mainRelaxationHome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
    public static void goBack(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/hello-view.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
    public static void enterRegister(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/ValidateAgent/register.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
}
