package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.DataElements;
import com.example.real_state_consortium.services.PaintService;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class PaintServiceImpl implements PaintService {

    ArrayList<DataElements> dataElementsPaint;

    public ArrayList<DataElements> initializeDataPaint(){
        if (dataElementsPaint == null){
            dataElementsPaint = new ArrayList<>();
            dataElementsPaint.add(new DataElements("Amarillo Piña",20, 3400f,"Disponible"));
            dataElementsPaint.add(new DataElements("Azul Zafiro",30, 4200f,"Disponible"));
            dataElementsPaint.add(new DataElements("Rojo Cereza",15, 7000f,"Disponible"));
            dataElementsPaint.add(new DataElements("Blanco Crema",10, 8500f,"Disponible"));
            dataElementsPaint.add(new DataElements("Beige",10, 10000f,"Disponible"));
            dataElementsPaint.add(new DataElements("Pintura Marmolada",10, 20000f,"Disponible"));
        }
        return dataElementsPaint;
    }
}
