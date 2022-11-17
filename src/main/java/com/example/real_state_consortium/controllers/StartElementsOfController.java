package com.example.real_state_consortium.controllers;


import com.example.real_state_consortium.utils.UtilsMethods1;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StartElementsOfController {

    static Label lbUnits;
    static Label lbDisponibility;
    static TextField tfEnterStock;
    static Label lbPrice;
    static Label lbNameProduct;
    public static void firstStep(ModelFactoryController mfc,Button button){
        loadCar(button);
        if (UtilsMethods1.validateFirstEnter(tfEnterStock)){
            String idBtn = button.getId();
            String units = lbUnits.getText();
            String disponibility = lbDisponibility.getText();
            String stockEnter = tfEnterStock.getText();
            String price = lbPrice.getText();
            String nameProduct = lbNameProduct.getText();
            if (UtilsMethods1.validateSecondEnter(units,disponibility,stockEnter)){
                UtilsMethods1.validateElementsView(mfc,button,lbUnits,lbDisponibility,tfEnterStock,lbPrice,lbNameProduct);
                mfc.addElementInCar(mfc,idBtn,units,disponibility,stockEnter,price,nameProduct);
            }
    }
}

   public static void loadCar(Button button){
    lbUnits = (Label) button.getParent().getChildrenUnmodifiable().get(1);
    lbDisponibility = (Label) button.getParent().getChildrenUnmodifiable().get(2);
    tfEnterStock = (TextField) button.getParent().getChildrenUnmodifiable().get(3);
    lbPrice = (Label) button.getParent().getChildrenUnmodifiable().get(7);
    lbNameProduct = (Label) button.getParent().getChildrenUnmodifiable().get(11);

    }



}
