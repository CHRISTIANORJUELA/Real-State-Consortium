package com.example.real_state_consortium.utils;

public class UtilsMethodsOfThread {
    public static boolean comprobateAnyStringIsNullAndOnlyContainNumeber(String value1,String value2,String value3,String value4){
        if (value1!=null && value2!=null && value3!= null && value4!=null){
            if (value1.matches("[0-9]+") && value2.matches("[0-9]+") && value3.matches("[0-9]+") && value4.matches("[0-9]+")){
                if (Integer.parseInt(value1)<=1000 && Integer.parseInt(value2)<=1000 && Integer.parseInt(value2)<=1000 && Integer.parseInt(value2)<=1000){
                    return true;
                }else {
                    PrintMessage.PrintMessageError("Valor Incorrecto","Has ingresado en algún campo una lentitud muy pequeña porfavor ingresa una mayor a 10000");
                }
            }else{
                PrintMessage.printMessageWarning("Valor Incorrecto","Los campos deben contener solo numeros");
            }
        }else {
            PrintMessage.printMessageWarning("Campos Vacios","Por Favor intoduce valores (numericos) a los campos");
        }
        return false;
    }


}
