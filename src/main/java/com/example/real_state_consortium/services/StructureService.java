package com.example.real_state_consortium.services;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Structure;

public interface StructureService {
    void calculateStructure(ModelFactoryController mfc, double metersBackground, double meterFront, int floors, int extract, String stucture);
    Structure getStructureClass();
    void setNullStructureClassObject();

}
