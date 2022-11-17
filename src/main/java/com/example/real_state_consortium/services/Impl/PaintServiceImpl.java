package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.services.PaintService;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class PaintServiceImpl implements PaintService {

    ArrayList<Data3> data3;
    ArrayList<DataElements> dataElementsPaint;


    ArrayList<Data3> data3send;

    public void addElementCar(Label lbUnits, Label lbDisponibility, TextField tfEnterStock, Label lbPrice, Label lbNameProduct){
        /*initializeData2();
         if (UtilsMethods1.validateSecondEnter(lbUnits,lbDisponibility,tfEnterStock)){
             int stock = Integer.parseInt(tfEnterStock.getText());
             float price = Float.parseFloat(lbPrice.getText());
             data3.add(new Data3(lbNameProduct.getText(),stock,price));
             Map<String,Double> map1 = data3.stream().collect(Collectors.groupingBy(Data3::getNameElement,Collectors.summingDouble(x -> x.getPrice()*x.getStockElement())));
             System.out.println();
             System.out.println();
             for (Map.Entry map:map1.entrySet()){
                 Double stockPush = calculateStockPush((String) map.getKey(),(Double) map.getValue());
                 data3send.add(new Data3((String) map.getKey(),(int) Math.round(stockPush),(double) map.getValue()));
             }
             System.out.println();
             System.out.println();
             data3send.forEach(x-> System.out.println("Nombre "+x.getNameElement()+" cantidad "+x.getStockElement()+" valor "+x.getPrice()));

             map1.clear();
             data3send.clear();
         }

         */
    }




   /* public Double calculateStockPush(String name ,Double price){
        Double elements = null;
        for (DataElements e:dataElements){
            if (e.getNameElement().equalsIgnoreCase(name.toLowerCase())){
                elements = price/e.getValue();
            }
        }
        return elements;
    }

    */

        /*public void initializeData2(){
        if (dataElements == null){
            dataElements = new ArrayList<>();
            dataElements.add(new DataElements("Amarillo Piña",20, 3400f,"Disponible"));
            dataElements.add(new DataElements("Pintura 2",30, 4200f,"Disponible"));
            dataElements.add(new DataElements("Pintura 3",15, 7000f,"Disponible"));
            dataElements.add(new DataElements("Pintura 4",10, 8500f,"Disponible"));
            dataElements.add(new DataElements("Pintura 5",10, 10000f,"Disponible"));
            dataElements.add(new DataElements("Pintura 6",10, 20000f,"Disponible"));
        }
        if (data3 == null){
            data3 = new ArrayList<>();
        }
        if (data3send == null){
            data3send = new ArrayList<>();
        }
    }

         */


    public ArrayList<DataElements> initializeDataPaint(){
        if (dataElementsPaint == null){
            dataElementsPaint = new ArrayList<>();
            dataElementsPaint.add(new DataElements("Amarillo Piña",20, 3400f,"Disponible"));
            dataElementsPaint.add(new DataElements("Pintura 2",30, 4200f,"Disponible"));
            dataElementsPaint.add(new DataElements("Pintura 3",15, 7000f,"Disponible"));
            dataElementsPaint.add(new DataElements("Pintura 4",10, 8500f,"Disponible"));
            dataElementsPaint.add(new DataElements("Pintura 5",10, 10000f,"Disponible"));
            dataElementsPaint.add(new DataElements("Pintura 6",10, 20000f,"Disponible"));
        }
        return dataElementsPaint;
    }
}
