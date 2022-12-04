package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.services.ToiletService;
import java.util.ArrayList;

public class ToiletServiceImpl implements ToiletService {
    ArrayList<DataElements> dataElementsToilet;
    public ArrayList<DataElements> initializeDataToilet(){
        if (dataElementsToilet == null){
            dataElementsToilet = new ArrayList<>();
            dataElementsToilet.add(new DataElements("Baño calido",45, 20000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño full Compact",20, 32000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño estilo crema",30, 24500f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño moderno",20, 45000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño en Granito Testra",20, 49000f,"Disponible"));
            dataElementsToilet.add(new DataElements("Baño en nogal Levante",20, 69000f,"Disponible"));
        }
        return dataElementsToilet;
    }
}
