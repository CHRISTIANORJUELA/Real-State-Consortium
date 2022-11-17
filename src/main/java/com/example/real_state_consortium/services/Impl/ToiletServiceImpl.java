package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.services.ToiletService;

import java.util.ArrayList;

public class ToiletServiceImpl implements ToiletService {

    ArrayList<DataElements> dataElementsToilet;
    public ArrayList<DataElements> initializeDataToilet(){
        if (dataElementsToilet == null){
            dataElementsToilet = new ArrayList<>();
            dataElementsToilet.add(new DataElements("Baño 1",45, 20000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño 2",20, 32000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño 3",30, 24500f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño 4",20, 45000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño 5",20, 49000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño 6",20, 69000f,"Disponible"));
        }
        return dataElementsToilet;
    }
}
