package com.example.real_state_consortium.services;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.services.Impl.Instances;
public interface AddAtCarService {
    void addElementInCar(ModelFactoryController mfc, Instances instances, String btn , String lbUnits, String lbDisponibility, String tfEnterStock, String lbPrice, String lbNameProduct);
    void  clearData();
}
