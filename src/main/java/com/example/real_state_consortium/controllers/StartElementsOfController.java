package com.example.real_state_consortium.controllers;


import com.example.real_state_consortium.services.Impl.AddAtCarImpl;
import com.example.real_state_consortium.services.Impl.Laboratory;
import com.example.real_state_consortium.utils.ElementsOfView;
import com.example.real_state_consortium.utils.UtilsMethods1;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class StartElementsOfController {
    static Label lbUnits;
    static Label lbDisponibility;
    static TextField tfEnterStock;
    static Label lbPrice;
    static Label lbNameProduct;

    public static ModelFactoryController mfc = ModelFactoryController.getInstance();
    public static Laboratory laboratory = new Laboratory();
    public static void firstStep(Button button){
        loadInformationOfView(button);
        if (UtilsMethods1.validateIscampusNumberIsTrue(tfEnterStock.getText())){
            String idBtn = button.getId();
            String units = lbUnits.getText();
            String disponibility = lbDisponibility.getText();
            String stockEnter = tfEnterStock.getText();
            String price = lbPrice.getText();
            String nameProduct = lbNameProduct.getText();
            if (UtilsMethods1.validateSecondEnter(units,disponibility,stockEnter)){
                ArrayList<ElementsOfView> elementsOfViews = mfc.getElementsInTheView();
                UtilsMethods1.validateElementsView(elementsOfViews,button,lbUnits,lbDisponibility,tfEnterStock,lbPrice,lbNameProduct);
                mfc.addElementIncarr(mfc,laboratory,idBtn,units,disponibility,stockEnter,price,nameProduct);
            }
    }
}
   public static void loadInformationOfView(Button button){
    AnchorPane an = (AnchorPane) button.getParent();
    lbUnits = (Label) an.getChildren().get(1);
    lbDisponibility = (Label) ((AnchorPane) button.getParent()).getChildren().get(2);
    tfEnterStock = (TextField) ((AnchorPane) button.getParent()).getChildren().get(3);
    lbPrice = (Label) ((AnchorPane) button.getParent()).getChildren().get(7);
    lbNameProduct = (Label) ((AnchorPane) button.getParent()).getChildren().get(11);
    }



}
