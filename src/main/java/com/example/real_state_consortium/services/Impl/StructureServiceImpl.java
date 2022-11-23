package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.services.StructureService;
import com.example.real_state_consortium.utils.TypeStructure;
import java.util.ArrayList;
import java.util.List;
public class StructureServiceImpl implements StructureService {
   final short pricePerMeter = 1000;
   final int pricePerFloor = 50000;
   final short pricePerExtract = 30000;
   float totalPriceOfStructure = 0;
   Structure structureClass;
   List<Structure> structures;
   public void calculateStructure(ModelFactoryController mfc, float metersBackground, float meterFront, int floors, int extract, String stucture){
      if (structures==null){structures=new ArrayList<>();}
      if (structureClass==null){structureClass = new Structure();}
      if (structureClass.getTypeStructure()!=null){structureClass=null;}
      if (structureClass==null){new Structure();}
      float totalPriceExtract =extract*pricePerExtract;
      float metersSquare = (metersBackground*meterFront);
      float totalPriceMeter2 = metersSquare*pricePerMeter;
      float totalPriceFloor = floors*pricePerFloor;
      float totalPriceTypeStructure = 0;
      switch (stucture){
         case "Edificio":totalPriceTypeStructure = TypeStructure.BUILDING.getPriceStructure();break;
         case "Mansión": totalPriceTypeStructure = TypeStructure.MANSION.getPriceStructure();break;
         case "Casa": totalPriceTypeStructure = TypeStructure.HOUSE.getPriceStructure();break;
      }
      totalPriceOfStructure = totalPriceExtract+totalPriceMeter2+totalPriceFloor+totalPriceTypeStructure;
      structureClass = new Structure(stucture,floors,meterFront,metersBackground,extract,metersSquare,totalPriceMeter2,totalPriceOfStructure);
   }
   public void deleteStructureFalse(){
      structureClass = null;
   }

   public List<Structure> getStructures(){return structures;}

   public Structure getStructureClass(){return structureClass;}

   public void setNullStructureClassObject(){
      structureClass = null;
   }
}
