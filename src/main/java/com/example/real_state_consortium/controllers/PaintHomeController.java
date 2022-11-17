package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class PaintHomeController implements BarCollectionPrincipal1, AddElement {


    // Position 1: stock Element
    // Position 2: Disponibyility
    // Position 3: TfNumber;
    //position 8: Price
    // position 12: nameProduct

    @FXML
    Label lbUnits;
    Label lbDisponibility;

    TextField tfEnterStock;

    Label lbPrice;

    Label lbNameProduct;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @Override
    public void addElement(ActionEvent e){
        Button button = (Button) e.getTarget();
        StartElementsOfController.firstStep(mfc,button);
        /*loadCar(button);
        if (UtilsMethods1.validateFirstEnter(tfEnterStock)){
            String idBtn = button.getId();
            String units = lbUnits.getText();
            String disponibility = lbDisponibility.getText();
            String stockEnter = tfEnterStock.getText();
            String price = lbPrice.getText();
            String nameProduct = lbNameProduct.getText();
            if (UtilsMethods1.validateSecondEnter(units,disponibility,stockEnter)){
                UtilsMethods1.validateElementView(mfc,button,lbUnits,lbDisponibility,tfEnterStock,lbPrice,lbNameProduct);

               mfc.addElementInCar(mfc,idBtn,units,disponibility,stockEnter,price,nameProduct);
            }

         */
        }






   /* @Override
    public void loadCar(Button button){
            lbUnits =  (Label) button.getParent().getChildrenUnmodifiable().get(1);
            lbDisponibility = (Label) button.getParent().getChildrenUnmodifiable().get(2);
            tfEnterStock = (TextField) button.getParent().getChildrenUnmodifiable().get(3);
            lbPrice = (Label) button.getParent().getChildrenUnmodifiable().get(8);
            lbNameProduct = (Label) button.getParent().getChildrenUnmodifiable().get(12);
    }

     */



    public void watchCar(MouseEvent e) throws IOException{
        ChangeViewGeneral.watchCar(e);
    }

    public void decorationHome(MouseEvent e) throws IOException {
        ChangeViewGeneral.decorationHome(e);
    }

    public void funny(MouseEvent e) throws IOException{
        ChangeViewGeneral.funny(e);
    }

    public void relaxation(MouseEvent e) throws IOException{
        ChangeViewGeneral.relaxation(e);
    }

    public void goBack(MouseEvent e) throws IOException{
        ChangeViewGeneral.goBack(e);
    }


    /*System.out.println("Unidades "+lbUnits.getText()+" disponibilidad "+lbDisponibility.getText()+
                " precio "+lbPrice.getText()+ " nombre del producto "+lbNameProduct.getText()
                );
         */

}
