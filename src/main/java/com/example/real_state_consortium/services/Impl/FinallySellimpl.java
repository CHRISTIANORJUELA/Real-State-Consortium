package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.DTOs.Value;
import com.example.real_state_consortium.models.Receipt;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.services.FinallySellService;
import com.example.real_state_consortium.utils.Data3;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FinallySellimpl implements FinallySellService {
    private float amount = 0;
    ArrayList<Receipt> receipt = new ArrayList<>();
    public void finallySell(String nameClient, String nameAgent , String typeTarget, String numberTargetCredit ,ArrayList<Data3>allElementsInCar,Structure structure ){
        double sumOfValuePriceCar;
        double sumValueOfStructure;
        if (allElementsInCar.size()>0 && structure != null && structure.getTypeStructure()!=null){
            sumOfValuePriceCar = allElementsInCar.stream().map(x->new Value(x.getValue())).collect(Collectors.summingDouble(Value::getValue));
            sumValueOfStructure = structure.getTotalPriceOfStructure();
            amount += sumOfValuePriceCar+sumValueOfStructure;
            receipt.add(new Receipt(nameAgent,nameClient,(ArrayList<Data3>) allElementsInCar.clone(),structure,amount, LocalDate.now(),true));
        }else if (allElementsInCar.size()>0){
            sumOfValuePriceCar = allElementsInCar.stream().map(x->new Value(x.getValue())).collect(Collectors.summingDouble(Value::getValue));
            System.out.println("sss"+sumOfValuePriceCar);
            amount += sumOfValuePriceCar;
            receipt.add(new Receipt(nameAgent,nameClient, (ArrayList<Data3>) allElementsInCar.clone(),amount, LocalDate.now(),true));
        } else if (structure.getTypeStructure() != null) {
            sumValueOfStructure = structure.getTotalPriceOfStructure();
            amount+=sumValueOfStructure;
            receipt.add(new Receipt(nameAgent,nameClient,structure,amount, LocalDate.now(),true));
        }
    }



    public ArrayList<Receipt> getReceiptFinal(){
        return receipt;
    }
}
