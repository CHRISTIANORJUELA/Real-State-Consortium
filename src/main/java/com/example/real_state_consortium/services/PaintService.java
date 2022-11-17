package com.example.real_state_consortium.services;

import com.example.real_state_consortium.utils.DataElements;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public interface PaintService {
    void addElementCar(Label lbUnits, Label lbDisponibility, TextField tfEnterStock, Label lbPrice, Label lbNameProduct);
    ArrayList<DataElements> initializeDataPaint();
}
