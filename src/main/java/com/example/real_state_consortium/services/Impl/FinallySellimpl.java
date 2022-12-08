package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.DTOs.Value;
import com.example.real_state_consortium.models.Receipt;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.services.FinallySellService;
import com.example.real_state_consortium.models.Data3;
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
        ExecutorService ex = Executors.newFixedThreadPool(5);                        //Inicializo el Ejecutor
        CompletableFuture.runAsync(this::initializeReceiptWithInformation,ex);               //Con el CompletableFuture mando a llamar la funcion initializeReceiptWithInformation
        double sumOfValuePriceCar;                                                           // Mientras el programa sigue corriendo
        double sumValueOfStructure;
        if (allElementsInCar.size() > 0 && structure != null && structure.getTypeStructure() != null) { // Valido si hay una estructura y tambiem elementos en carrito para obtener el monto total de la compra
            sumOfValuePriceCar = allElementsInCar.stream().map(x -> new Value(x.getValue())).collect(Collectors.summingDouble(Value::getValue));
            sumValueOfStructure = structure.getTotalPriceOfStructure();
            amount += sumOfValuePriceCar + sumValueOfStructure;
            receipt.add(new Receipt(nameAgent, nameClient, (ArrayList<Data3>) allElementsInCar.clone(), structure, amount, LocalDate.now(), true));
        } else if (allElementsInCar.size() > 0) {   // Valido si solo hay elementos en el carrito para obtener el monto total de la compra
            sumOfValuePriceCar = allElementsInCar.stream().map(x -> new Value(x.getValue())).collect(Collectors.summingDouble(Value::getValue));
            amount += sumOfValuePriceCar;
            receipt.add(new Receipt(nameAgent, nameClient, (ArrayList<Data3>) allElementsInCar.clone(), amount, LocalDate.now(), true));
        } else if (structure.getTypeStructure() != null) {  // Valido si solo hay una estructur para obtener el monto total de la compra
            sumValueOfStructure = structure.getTotalPriceOfStructure();
            amount += sumValueOfStructure;
            receipt.add(new Receipt(nameAgent, nameClient, structure, amount, LocalDate.now(), true));
        }
        //Primero lleno el ReceiptConverted con los datos que halla en el Recibo luego cuando finalize esa tarea mando a llamar a SaveReceipt para que comienze el proceso para guardar el el ReceiptConvert en el archivo txt
        CompletableFuture.runAsync(this::addAtReceiptConverted,ex).thenRun(() -> Persistence.SaveReceipt(receiptConverted));
    }

    private void initializeReceiptWithInformation() {
        try {
            // El receiptConverted es la lista que voy a usar para la persistencia y se recarga con los datos del Archivo txt
            CompletableFuture.runAsync(() -> receiptConverted = Persistence.loadReceipt());
        }catch (Exception e){
            PrintMessage.PrintMessageError("Error","No se pudo cargar los Datos");
        }
    }


    private void addAtReceiptConverted() {
        String content = "";           // Esta funcion lo que hace es pasar los datos del receipt al receiptConvert
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
