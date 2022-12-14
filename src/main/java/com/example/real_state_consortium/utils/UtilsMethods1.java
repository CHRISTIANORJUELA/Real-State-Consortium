package com.example.real_state_consortium.utils;

import com.example.real_state_consortium.exeptions.InformationIsWrong;
import com.example.real_state_consortium.models.Data3;
import com.example.real_state_consortium.models.Structure;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class UtilsMethods1 {

    private static StringBuilder strDisponibility = new StringBuilder(20);

    public static boolean validateIscampusNumberIsTrue(String StringtfEnterStock){
        if ((StringtfEnterStock != null) && (StringtfEnterStock.matches("[0-9]+"))){
            return true;
        }else{
            try {
                throw new InformationIsWrong(" Llena los campos correspondientes ,con datos Correctos solo (numeros) no permitido decimales");
            }catch (InformationIsWrong e){
                PrintMessage.printMessage("Recuerda",e.getMessage());
            }
        }
        return false;
    }

    public static boolean validateIsCampusDecimalIstrue(String stringEnter) {
        if ((stringEnter != null) && (stringEnter.matches("^[0-9]+([.][0-9]+)?$"))){
            return true;
        }else{
            try {
                throw new InformationIsWrong(" llenar los datos correspondiente con numeros");
            }catch (InformationIsWrong e){
              PrintMessage.printMessageWarning("Recuerda",e.getMessage());
            }
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
           if (stockOfEnter>0 && stockOfEnter<=units && strDisponibility.toString().equalsIgnoreCase("Disponible")){
               return true;
           }else {
               if (stockOfEnter>units){PrintMessage.printMessageWarning("Acci??n rechazada","Has excedido la cantidad de unidades disponibles");}}
               if (stockOfEnter<0){PrintMessage.printMessageWarning("Acci??n Rechazada","El numero que entraste es incorrecto");
           }
       }catch (NumberFormatException e){
           System.out.println(e);
       }
        return false;
    }

    public static void validateElementsView(ArrayList<ElementsOfView> elementsInView , Button button, Label lbUnits, Label lbDisponibility, TextField tfEnterStock, Label lbPrice, Label lbNameProduct){
        boolean passOfView = elementsInView.stream().anyMatch(x-> x.getNameView().equals(lbNameProduct));
        if (passOfView){
            elementsInView.forEach(x->{
                if (x.getNameView().getText().equalsIgnoreCase(lbNameProduct.getText())){
                    /*x.getDisponiblilityView().setText(lbDisponibility.getText());
                    x.getStockInView().setText(lbUnits.getText());

                     */
                    /*x.setStockInView("100");
                    lbUnits.setAccessibleText("100");
                    */
                }
            });
            elementsInView.forEach(x-> System.out.println("Agregado a la vista : "+"Nombre : "+x.getNameView().getText()+" Cantidad : "+x.getStockInView().getText()));
        }else {
            elementsInView.add(new ElementsOfView(button,lbNameProduct,lbDisponibility,lbUnits,lbPrice));
        }
    }
    public static boolean makeSurePassIsTrue(String nameClient, String nameAgent, String typeTarget, String numberTargetCredit, ArrayList<Data3> allElementsInCar, Structure structure){
            if (nameClient != null && nameAgent != null && typeTarget != null && numberTargetCredit != null && validateIscampusNumberIsTrue(numberTargetCredit) && validateIscampusStringIsTrue(nameClient)){
                if (allElementsInCar.size()>0 || structure != null){
                    return true;
                }else {
                    PrintMessage.printMessage("Por favor","agrega elementos al carrito o has una cotizaci??n");
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

