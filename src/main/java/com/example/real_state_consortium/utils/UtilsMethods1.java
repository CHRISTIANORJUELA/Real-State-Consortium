package com.example.real_state_consortium.utils;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class UtilsMethods1 {

    private static StringBuilder strUnits = new StringBuilder(20);
    private static StringBuilder strDisponibility = new StringBuilder(20);
    private static StringBuilder tfEnterStock = new StringBuilder(15);


    public static boolean validateFirstEnter(TextField tfEnterStock){
        if ((tfEnterStock.getText() != "") && (tfEnterStock.getText().matches("[0-9]+"))){
            return true;
        }
        return false;
    }

    public static boolean validateSecondEnter(String unitsElement, String disponibility, String enterStock){
       try {
           int units = Integer.parseInt(unitsElement);
           int stockOfEnter = Integer.parseInt(enterStock);
           loadStr(strDisponibility,disponibility);
           if (stockOfEnter<=units && strDisponibility.toString().equalsIgnoreCase("Disponible")){
               return true;
           }
       }catch (NumberFormatException e){
           System.out.println(e);
       }
        return false;
    }


    public static void validateElementsView(ModelFactoryController mfc ,Button button, Label lbUnits, Label lbDisponibility, TextField tfEnterStock, Label lbPrice, Label lbNameProduct){
        ArrayList<ElementsOfView> elements = mfc.getElementsInTheView();
        boolean passOfView = elements.stream().anyMatch(x-> x.getNameView().equals(lbNameProduct));
        if (!passOfView){
            elements.add(new ElementsOfView(button,lbNameProduct,lbDisponibility,lbUnits,lbPrice));
        }
    }

    public static void loadStr(StringBuilder str, String disponibility){
        if (str.length() == 0){
            str.append(disponibility);
        } else if (disponibility.equalsIgnoreCase("Sin unidades")) {
            str.replace(0,9,disponibility);
        }
    }
}

