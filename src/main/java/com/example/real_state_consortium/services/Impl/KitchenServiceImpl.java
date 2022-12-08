package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.services.KitchenService;
import com.example.real_state_consortium.models.DataElements;
import java.util.ArrayList;

public class KitchenServiceImpl implements KitchenService {
    ArrayList<DataElements> dataElementsKitchen;
    public ArrayList<DataElements> initializeDataKitchen(){
        if (dataElementsKitchen == null){
            dataElementsKitchen = new ArrayList<>();
            dataElementsKitchen.add(new DataElements("Cocina integral Plateada",45, 20000f,"Disponible"));
            dataElementsKitchen.add(new DataElements("Cocina Roja Moderna",20, 32000f,"Disponible"));
            dataElementsKitchen.add(new DataElements("Cocina Integral Mediana",30, 24500f,"Disponible"));
            dataElementsKitchen.add(new DataElements("Cocina moderna estilo europeo",20, 45000f,"Disponible"));
            dataElementsKitchen.add(new DataElements("Cocina moderna  en marmol marfil",20, 49000f,"Disponible"));
            dataElementsKitchen.add(new DataElements("Cocina grande en marmol zilicio",20, 69000f,"Disponible"));
        }
        return dataElementsKitchen;
    }
}
