package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.services.StructureService;
import com.example.real_state_consortium.utils.TypeStructure;
public class StructureServiceImpl implements StructureService {
   private final int pricePerMeter = 100000;
   private final int pricePerFloor = 300000;
   private final int pricePerExtract = 200000;
   private double totalPriceOfStructure = 0;
   private Structure structureClass;
   public void calculateStructure(ModelFactoryController mfc, double metersBackground, double meterFront, int floors, int extract, String stucture){
      if (structureClass==null){structureClass = new Structure();}
      if (structureClass.getTypeStructure()!=null){structureClass=null;}
      if (structureClass==null){new Structure();}
      double totalPriceExtract =extract*pricePerExtract;
      double metersSquare = (metersBackground*meterFront);
      double totalPriceMeter2 = metersSquare*pricePerMeter;
      double totalPriceFloor = floors*pricePerFloor;
      double totalPriceTypeStructure = 0;
      switch (stucture){
         case "Edificio":totalPriceTypeStructure = TypeStructure.BUILDING.getPriceStructure();break;
         case "Mansión": totalPriceTypeStructure = TypeStructure.MANSION.getPriceStructure();break;
         case "Casa": totalPriceTypeStructure = TypeStructure.HOUSE.getPriceStructure();break;
      }
      totalPriceOfStructure = totalPriceExtract+totalPriceMeter2+totalPriceFloor+totalPriceTypeStructure;
      structureClass = new Structure(stucture,floors,meterFront,metersBackground,extract,metersSquare,totalPriceMeter2,totalPriceOfStructure);
   }

   public Structure getStructureClass(){return structureClass;}
   public void setNullStructureClassObject(){
      structureClass = null;
   }
}
