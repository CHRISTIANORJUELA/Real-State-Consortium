package com.example.real_state_consortium.utils;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Structure;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class UtilsMethods1 {

    private static StringBuilder strUnits = new StringBuilder(20);
    private static StringBuilder strDisponibility = new StringBuilder(20);
    private static StringBuilder tfEnterStock = new StringBuilder(15);


    public static boolean validateIscampusNumberIsTrue(String StringtfEnterStock){
        if ((StringtfEnterStock != "") && (StringtfEnterStock.matches("[0-9]+"))){
            return true;
        }else{
            PrintMessage.printMessage("Por Favor","Llena los campos correspondientes  , con datos Correctos solo (numeros)");
        }
        return false;
    }

    public static boolean validateIscampusStringIsTrue(String string){
        if ((string != "") && (string.matches("^[a-zA-Z]*$"))){
            return true;
        }else{
            PrintMessage.printMessage("Por Favor","Llena los campos correspondientes del Formulario con datos Correctos solo (Letras)");
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
        if (passOfView){
            elements.forEach(x->{
                if (x.getNameView().getText().equalsIgnoreCase(lbNameProduct.getText())){
                    /*x.getDisponiblilityView().setText(lbDisponibility.getText());
                    x.getStockInView().setText(lbUnits.getText());

                     */
                    x.setStockInView("100");
                    lbUnits.setAccessibleText("100");
                }
            });
            elements.forEach(x-> System.out.println("Agregado a la vista : "+"Nombre : "+x.getNameView().getText()+" Cantidad : "+x.getStockInView().getText()));
        }else {
            elements.add(new ElementsOfView(button,lbNameProduct,lbDisponibility,lbUnits,lbPrice));

        }
    }
    public static boolean makeSurePassIsTrue(String nameClient, String nameAgent, String typeTarget, String numberTargetCredit, ArrayList<Data3> allElementsInCar, Structure structure){
            if (nameClient != null && nameAgent != null && typeTarget != null && numberTargetCredit != null && validateIscampusNumberIsTrue(numberTargetCredit) && validateIscampusStringIsTrue(nameClient)){
                if (allElementsInCar.size()>0 || structure != null){
                    return true;
                }else {
                    PrintMessage.printMessage("Por favor","agrega elementos al carrito o has una cotización");
                }
            }else {
                PrintMessage.printMessage("Por Favor","Los Datos del Formulario");
            }
        return false;
    }

    public static void loadStr(StringBuilder str, String disponibility){
        if (str.length() == 0){
            str.append(disponibility);
        } else if (disponibility.equalsIgnoreCase("Sin unidades")) {
            str.replace(0,9,disponibility);
        }
    }
}

