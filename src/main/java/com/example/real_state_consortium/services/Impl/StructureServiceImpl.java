package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.controllers.ModelFactoryController;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.services.StructureService;
import com.example.real_state_consortium.utils.TypeStructure;
import java.util.ArrayList;
import java.util.List;
public class StructureServiceImpl implements StructureService {
   private final short pricePerMeter = 10000;
   private final int pricePerFloor = 2250000;
   private final int pricePerExtract = 100000;
   private float totalPriceOfStructure = 0;
   private Structure structureClass;

   public void calculateStructure(ModelFactoryController mfc, float metersBackground, float meterFront, int floors, int extract, String stucture){
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

   public Structure getStructureClass(){return structureClass;}
   public void setNullStructureClassObject(){
      structureClass = null;
   }
}
