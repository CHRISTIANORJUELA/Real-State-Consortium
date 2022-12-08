package com.example.real_state_consortium.services;

import com.example.real_state_consortium.models.Data3;
import com.example.real_state_consortium.utils.ElementsOfView;
import java.util.ArrayList;

public interface CarService {
    ArrayList<ElementsOfView> getElementsInTheView();
    ArrayList<Data3> getListAllElementsCar();
}
