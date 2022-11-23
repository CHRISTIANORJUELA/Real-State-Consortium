package com.example.real_state_consortium.services;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Structure;

import java.util.List;

public interface StructureService {
    void calculateStructure(ModelFactoryController mfc, float metersBackground, float meterFront, int floors, int extract, String stucture);

    void deleteStructureFalse();

    List<Structure> getStructures();

    Structure getStructureClass();

    void setNullStructureClassObject();

}
