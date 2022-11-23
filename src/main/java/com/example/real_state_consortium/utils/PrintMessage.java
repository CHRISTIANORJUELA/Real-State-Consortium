package com.example.real_state_consortium.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class PrintMessage {
    public static boolean ComfirmationSell (String messageHeader,String messageContent){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Mensaje");
        a.setHeaderText(messageHeader);
        a.setContentText(messageContent);
        Optional<ButtonType> btnType = a.showAndWait();
        if (btnType.get() == ButtonType.OK){
            return true;
        }
        return false;
    }

    public static void printMessage(String messageHeader,String messageContent){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Mensaje");
        a.setHeaderText(messageHeader);
        a.setContentText(messageContent);
        a.showAndWait();
    }

    public static void printMessageYellow(String messageHeader,String messageContent){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Mensaje");
        a.setHeaderText(messageHeader);
        a.setContentText(messageContent);
        a.showAndWait();
    }


}
