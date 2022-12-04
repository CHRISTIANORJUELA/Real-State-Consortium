package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.DTOs.Value;
import com.example.real_state_consortium.models.Receipt;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.services.FinallySellService;
import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.Persistence;
import com.example.real_state_consortium.utils.PrintMessage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class FinallySellimpl implements FinallySellService {
    private float amount = 0;
    ArrayList<Receipt> receipt = new ArrayList<>();
    ArrayList<String> receiptConverted = new ArrayList<>();

    public void finallySell(String nameClient, String nameAgent, String typeTarget, String numberTargetCredit, ArrayList<Data3> allElementsInCar, Structure structure) {
        ExecutorService ex = Executors.newFixedThreadPool(5);
        CompletableFuture.runAsync(this::initializeReceiptWithInformation,ex);
        double sumOfValuePriceCar;
        double sumValueOfStructure;
        if (allElementsInCar.size() > 0 && structure != null && structure.getTypeStructure() != null) {
            sumOfValuePriceCar = allElementsInCar.stream().map(x -> new Value(x.getValue())).collect(Collectors.summingDouble(Value::getValue));
            sumValueOfStructure = structure.getTotalPriceOfStructure();
            amount += sumOfValuePriceCar + sumValueOfStructure;
            receipt.add(new Receipt(nameAgent, nameClient, (ArrayList<Data3>) allElementsInCar.clone(), structure, amount, LocalDate.now(), true));
        } else if (allElementsInCar.size() > 0) {
            sumOfValuePriceCar = allElementsInCar.stream().map(x -> new Value(x.getValue())).collect(Collectors.summingDouble(Value::getValue));
            amount += sumOfValuePriceCar;
            receipt.add(new Receipt(nameAgent, nameClient, (ArrayList<Data3>) allElementsInCar.clone(), amount, LocalDate.now(), true));
        } else if (structure.getTypeStructure() != null) {
            sumValueOfStructure = structure.getTotalPriceOfStructure();
            amount += sumValueOfStructure;
            receipt.add(new Receipt(nameAgent, nameClient, structure, amount, LocalDate.now(), true));
        }
        CompletableFuture.runAsync(this::addAtReceiptConverted,ex).thenRun(() -> Persistence.SaveReceipt(receiptConverted));
    }

    private void initializeReceiptWithInformation() {
        try {
            CompletableFuture.runAsync(() -> receiptConverted = Persistence.loadReceipt());
        }catch (Exception e){
            PrintMessage.PrintMessageError("Error","No se pudo cargar los Datos");
        }
    }


    private void addAtReceiptConverted() {
        String content = "";
        receiptConverted.clear();
        for (Receipt r : receipt) {
            content += "\n" + r.getNameAgent() + " | " + r.getNameBuyer();
            if (r.getElementsAdded() != null) {
                for (Data3 rec : r.getElementsAdded()) {
                    content += " | " + rec.getNameElement() + " | " + rec.getStockElement() + "|" + rec.getValue();
                }
            }
            if (r.getStructure() != null) {
                content += " | " + r.getStructure().getTypeStructure() + " | " + r.getStructure().getFront() + " | " + r.getStructure().getBackground() + " | " + r.getStructure().getFloors() + " | " + r.getStructure().getSquareMeters() + " | " + r.getStructure().getPricePerMeter2() + " | " + r.getStructure().getExtractStructure() + " | " + r.getStructure();
            }
            content += r.getDaySell() + " | " + r.getPriceSell();
            receiptConverted.add(content);
            content = "";
        }
    }

    public ArrayList<Receipt> getReceiptFinal(){
        return receipt;
    }
    }
