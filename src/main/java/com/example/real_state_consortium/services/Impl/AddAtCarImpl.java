package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Data3;
import com.example.real_state_consortium.models.DataElements;
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
            initializeForRun(laboratory,mfc); // Inicializo dataElements con los datos de cada vista del catalogo  nombre, cantidad, precio, disponiblidad
            int stock = Integer.parseInt(stockEnter);  // parseo la cantidad que se ingreso en la vista
            float price = Float.parseFloat(priceElement);  // parseo el precio que aparece en la vista
            data3.add(new Data3(nameProduct,stock,price));  // A esta lista introduzco el nombre la cantidad y el precio
            // En este map obtengo el precio que debe pagar el usuario por cada producto que le dio agregar trabajamos con la lista data3
            Map<String,Double> map1 = data3.stream().collect(Collectors.groupingBy(Data3::getNameElement,Collectors.summingDouble(x -> x.getValue()*x.getStockElement())));
            for (Map.Entry map:map1.entrySet()){
                double stockPush = calculateStockPush((String) map.getKey(),(double) map.getValue()); // calculo la cantidad de unidades por cada elemento en el mapa
                setData3Send((String) map.getKey(),(double) map.getValue(), stockPush); // le envio a setData3Send el nombre del producto , valor a pagar, cantidad de unidades
            }
            checkElementsExistsInArrayCar(data3send);  // agre
            map1.clear();
    }

    public Double calculateStockPush(String name ,Double price){
        Double elements = null;  // Esta funcion calcula la cantidad de unidades por cada producto
        for (DataElements e:dataElements){
            if (e.getNameElement().equalsIgnoreCase(name)){
                elements = price/e.getValue();
            }
        }
        return elements;
    }
    public void setData3Send(String name,double totalValue, double stockPush){
        boolean pass = data3send.stream().anyMatch(x-> x.getNameElement().equalsIgnoreCase(name));
        if (pass){// Valido si ese elemento ya existe en setData3Send si es asi actualizo la cantidad de unidades y el valor a pagar
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
        for (Data3 d:data3send){ // valido si los elementos de data3send estan en la lista del carrito recordar que allelemetsIncar
            boolean pass = allElementsIncar.stream().anyMatch(x-> x.getNameElement().equalsIgnoreCase(d.getNameElement())); // fue inicializado con la lista del carrito
            if (pass){                                                                                                      // osea esta lista (allElementsIncar) es una referencia
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
    public void initializeForRun(Laboratory laboratory, ModelFactoryController mfc){
        if (paintService==null){paintService = laboratory.getPaintServiceImpl();}  // inicializo todas las instancias del catalogo
        if (toiletService==null){toiletService=laboratory.getToiletServiceImpl();}  // para que pueda funcionar correctamente el programa
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
        if (data3 != null){            // limpio las listas que fueron utilizadas en el programa para que no se repita información
            data3.clear();             // cuando finalize la compra y quiera volver a agregar elementos
        }
        if (data3send != null){
            data3send.clear();
        }
    }




}
