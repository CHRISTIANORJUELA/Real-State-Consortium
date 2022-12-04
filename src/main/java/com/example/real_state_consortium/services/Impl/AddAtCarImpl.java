package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.services.AddAtCarService;
import com.example.real_state_consortium.utils.PrintMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class AddAtCarImpl implements AddAtCarService {
    ArrayList<DataElements> dataElements;
    ArrayList<Data3> data3;
    ArrayList<Data3> data3send;
    private  PaintServiceImpl paintService;
    private  ToiletServiceImpl toiletService;
    private KitchenServiceImpl kitchenService;
    private FloorServiceImpl floorService;
    private GymServiceImpl gymService;
    private ArrayList<Data3> allElementsIncar;

    public AddAtCarImpl(){}
    public void addElementInCar(ModelFactoryController mfc,Laboratory laboratory,String idBtn,String units,String disponibility,String stockEnter,String priceElement,String nameProduct){
            initializeFirstsData(laboratory,mfc);
            int stock = Integer.parseInt(stockEnter);
            float price = Float.parseFloat(priceElement);
            data3.add(new Data3(nameProduct,stock,price));
            Map<String,Double> map1 = data3.stream().collect(Collectors.groupingBy(Data3::getNameElement,Collectors.summingDouble(x -> x.getValue()*x.getStockElement())));
            for (Map.Entry map:map1.entrySet()){
                double stockPush = calculateStockPush((String) map.getKey(),(double) map.getValue());
                setData3Send((String) map.getKey(),(double) map.getValue(), stockPush);
            }
            checkElementsExistsInArrayCar(data3send);
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
    public void checkElementsExistsInArrayCar(ArrayList<Data3> data3send){
        for (Data3 d:data3send){
            boolean pass = allElementsIncar.stream().anyMatch(x-> x.getNameElement().equalsIgnoreCase(d.getNameElement()));
            if (pass){
                allElementsIncar.forEach(x->{
                    if (x.getNameElement().equalsIgnoreCase(d.getNameElement())){
                        x.setStockElement(d.getStockElement());
                        x.setValue(d.getValue());
                    }
                });
            }else {
                allElementsIncar.add(new Data3(d.getNameElement(),d.getStockElement(), d.getValue()));
                PrintMessage.printMessage("Atención"," Ha sido Agregado el elemento al Carrito");
            }
        }

    }
    public void initializeFirstsData(Laboratory laboratory, ModelFactoryController mfc){
        if (paintService==null){paintService = laboratory.getPaintServiceImpl();}
        if (toiletService==null){toiletService=laboratory.getToiletServiceImpl();}
        if (kitchenService==null){kitchenService=laboratory.getKitchenServiceImpl();}
        if (floorService==null){floorService=laboratory.getFloorServiceImpl();}
        if (gymService==null){gymService=laboratory.getGymServiceImpl();}
        if(allElementsIncar==null){allElementsIncar=mfc.getListAllElementsCar();}
        if (data3 == null){data3 = new ArrayList<>();}
        if (dataElements == null){
            dataElements = new ArrayList<>();
           // dataElements.addAll(laboratory.getPaintServiceImpl().initializeDataPaint());
           // dataElements.addAll(mfc.returnDataToilet());
            dataElements.addAll(paintService.initializeDataPaint());
            dataElements.addAll(toiletService.initializeDataToilet());
            dataElements.addAll(kitchenService.initializeDataKitchen());
            dataElements.addAll(floorService.initializeDataFloor());
            dataElements.addAll(gymService.initializeDataGym());
        }
        if (data3send==null){data3send = new ArrayList<>();}
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
