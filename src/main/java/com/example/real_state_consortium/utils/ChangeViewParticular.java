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

public class ChangeViewParticular {
    private static Stage stage;
    private static Scene scene;

    public static void paintHome(MouseEvent e) throws IOException {
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/paintHome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
    public static void kitchenHome(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/kitchenHome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
    public static void floorHome(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/floorHome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
    public static void toiletHome(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/toiletHome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void continueWithBuy(MouseEvent e) throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/structure/structureview.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void watchCatalog(MouseEvent e)  throws IOException{
        URL url= new File("src/main/resources/com/example/real_state_consortium/houseHoldItems/mainHouseHold.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void enterAtCheckUser(MouseEvent e) throws IOException{
        URL url = new File("src/main/resources/com/example/real_state_consortium/checkUser/login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }

    public static void enterProject(MouseEvent e) throws IOException{
        URL url = new File("src/main/resources/com/example/real_state_consortium/exercisesPractice/exercises.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        scene = new Scene(root);
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = root.getScene();
        stage.setScene(scene);
        stage.show();
    }
}
