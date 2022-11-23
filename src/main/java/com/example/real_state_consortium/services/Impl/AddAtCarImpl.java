package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.services.AddAtCarService;
import com.example.real_state_consortium.utils.PrintMessage;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class AddAtCarImpl implements AddAtCarService {

    ArrayList<DataElements> dataElements;
    ArrayList<Data3> data3;
    ArrayList<Data3> data3send;

    public void addElementInCar(ModelFactoryController mfc,String idBtn,String units,String disponibility,String stockEnter,String priceElement,String nameProduct){
            initializeFirstsData(mfc);
            int stock = Integer.parseInt(stockEnter);
            float price = Float.parseFloat(priceElement);
            data3.add(new Data3(nameProduct,stock,price));
            Map<String,Double> map1 = data3.stream().collect(Collectors.groupingBy(Data3::getNameElement,Collectors.summingDouble(x -> x.getValue()*x.getStockElement())));
            for (Map.Entry map:map1.entrySet()){
                double stockPush = calculateStockPush((String) map.getKey(),(double) map.getValue());
                setData3Send((String) map.getKey(),(double) map.getValue(), stockPush);
            }
            checkElementsExistsInArrayCar(mfc,data3send);
            map1.clear();
    }

    public Double calculateStockPush(String name ,Double price){
        Double elements = null;
        for (DataElements e:dataElements){
            if (e.getNameElement().equalsIgnoreCase(name)){
                elements = price/e.getValue();
            }
        }
        return elements;
    }
    public void setData3Send(String name,double totalValue, double stockPush){
        boolean pass = data3send.stream().anyMatch(x-> x.getNameElement().equalsIgnoreCase(name));
        if (pass){
            data3send.forEach(x->{
                if (x.getNameElement().equalsIgnoreCase(name)){
                    x.setStockElement((int) Math.round(stockPush));
                    x.setValue(totalValue);
                }
            });
        }else {
            data3send.add(new Data3(name,(int) Math.round(stockPush), totalValue));
        }
    }
    public void checkElementsExistsInArrayCar(ModelFactoryController mfc,ArrayList<Data3> data3send){
        ArrayList<Data3> elementsInCar = mfc.getListAllElementsCar();
        for (Data3 d:data3send){
            boolean pass = elementsInCar.stream().anyMatch(x-> x.getNameElement().equalsIgnoreCase(d.getNameElement()));
            if (pass){
                elementsInCar.forEach(x->{
                    if (x.getNameElement().equalsIgnoreCase(d.getNameElement())){
                        x.setStockElement(d.getStockElement());
                        x.setValue(d.getValue());
                        PrintMessage.printMessage("Atención",x.getNameElement()+" Ha sido Agregado");
                    }
                });
            }else {
                elementsInCar.add(new Data3(d.getNameElement(),d.getStockElement(), d.getValue()));
            }
        }
    }
    public void initializeFirstsData(ModelFactoryController mfc){
        if (data3 == null){
            data3 = new ArrayList<>();

        }
        if (dataElements == null){
            dataElements = new ArrayList<>();
            dataElements.addAll(mfc.returnDataPaint());
            dataElements.addAll(mfc.returnDataToilet());
        }
        if (data3send==null){
            data3send = new ArrayList<>();
        }
    }

    public void clearData(){
        if (data3 != null){
            data3.clear();
        }
        if (data3send != null){
            data3send.clear();
        }
    }




}
