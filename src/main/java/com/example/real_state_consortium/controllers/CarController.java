package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.Data3;
import com.example.real_state_consortium.utils.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class CarController implements Initializable,BarCollectionPrincipal1 {
    @FXML
    private TableColumn<String, Data3> clName;
    @FXML
    private TableColumn<String, Data3> clStock;
    @FXML
    private TableColumn<String, Data3> clValue;
    @FXML
    private TableView<Data3> tableCar;
    @FXML
    private Label lbTotalStock;
    @FXML
    private Label lbValueTotal;
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllElementsInCar();
        clName.setCellValueFactory(new PropertyValueFactory<>("nameElement"));
        clStock.setCellValueFactory(new PropertyValueFactory<>("stockElement"));
        clValue.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    private void getAllElementsInCar() {
        ArrayList<Data3> arrayOfAddAtCar = mfc.getListAllElementsCar();
        if (arrayOfAddAtCar.size()>0){
            calculateTotalStockAndTotalValue(arrayOfAddAtCar);
            ObservableList<Data3> obsPrincipal =FXCollections.observableArrayList();
            convertNumTheArrayOfAddAtCar(arrayOfAddAtCar,obsPrincipal);
        }



    }

    private void convertNumTheArrayOfAddAtCar(ArrayList<Data3> arrayOfAddAtCar, ObservableList<Data3> obsPrincipal) {
        arrayOfAddAtCar.forEach(x-> x.setValue(BigDecimal.valueOf(x.getValue()).doubleValue()));
        obsPrincipal.setAll(arrayOfAddAtCar);
        tableCar.setItems(obsPrincipal);
        tableCar.refresh();
    }

    public void calculateTotalStockAndTotalValue(ArrayList<Data3> arrayList){
        int totalStock = arrayList.stream().collect(Collectors.summingInt(Data3::getStockElement));  // Calculo el total de elementos que hay en el carrito
        double totalValue = arrayList.stream().collect(Collectors.summingDouble(Data3::getValue));   // Calculo el precio acumulado de todos los elementos en el carrito
        lbTotalStock.setText(String.valueOf(totalStock));
        lbValueTotal.setText(String.valueOf(totalValue));
    }

    public void decorationHome(MouseEvent e) throws IOException {
        ChangeViewGeneral.decorationHome(e);
    }

    public void funny(MouseEvent e) throws IOException{
        ChangeViewGeneral.funny(e);
    }

    public void goBack(MouseEvent e) throws IOException{
        ChangeViewGeneral.goBack(e);
    }

    public void quoteProperty(MouseEvent e) throws IOException{
        ChangeViewParticular.quoteProperty(e);
    }

    public void finallySell(MouseEvent e)throws IOException{
        ChangeViewParticular.finallySell(e);
    }



}
