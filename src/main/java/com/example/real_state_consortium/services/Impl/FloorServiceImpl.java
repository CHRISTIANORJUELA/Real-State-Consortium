package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.services.FloorService;
import com.example.real_state_consortium.models.DataElements;

import java.util.ArrayList;

public class FloorServiceImpl implements FloorService {
    ArrayList<DataElements> dataElementsFloor;
    public ArrayList<DataElements> initializeDataFloor(){
        if (dataElementsFloor == null){
            dataElementsFloor = new ArrayList<>();
            dataElementsFloor.add(new DataElements("Marmol Cielo",50, 4000f,"Disponible"));
            dataElementsFloor.add(new DataElements("Marmol Crema",35, 3200f,"Disponible"));
            dataElementsFloor.add(new DataElements("Marmol Alice",15, 2200f,"Disponible"));
            dataElementsFloor.add(new DataElements("Marmol Emperador claro",10, 9000f,"Disponible"));
            dataElementsFloor.add(new DataElements("Marmol Luminisus",18, 10000f,"Disponible"));
            dataElementsFloor.add(new DataElements("Marmol Nieve",11, 15000f,"Disponible"));
        }
        return dataElementsFloor;
    }
}
