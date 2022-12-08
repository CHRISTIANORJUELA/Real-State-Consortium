package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.services.GymService;
import com.example.real_state_consortium.models.DataElements;

import java.util.ArrayList;

public class GymServiceImpl implements GymService {
    ArrayList<DataElements> dataElementsGym;
    public ArrayList<DataElements> initializeDataGym(){
        if (dataElementsGym == null){
            dataElementsGym = new ArrayList<>();
            dataElementsGym.add(new DataElements("Escalera",20, 10000f,"Disponible"));
            dataElementsGym.add(new DataElements("Leg Curl",15, 12000f,"Disponible"));
            dataElementsGym.add(new DataElements("Banco olimpico",10, 8000f,"Disponible"));
            dataElementsGym.add(new DataElements("Corredora",10, 13000f,"Disponible"));
            dataElementsGym.add(new DataElements("Prensa",11, 15000f,"Disponible"));
            dataElementsGym.add(new DataElements("Super fuerza 3000",15, 35000f,"Disponible"));
        }
        return dataElementsGym;
    }
}
