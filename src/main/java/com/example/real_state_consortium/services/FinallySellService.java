package com.example.real_state_consortium.services;

import com.example.real_state_consortium.models.Receipt;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.utils.Data3;
import com.example.real_state_consortium.utils.ElementsOfView;

import java.util.ArrayList;

public interface FinallySellService {

    void finallySell(String nameClient, String nameAgent , String typeTarget, String numberTargetCredit ,ArrayList<Data3>allElementsInCar,Structure structure);

    ArrayList<Receipt> getReceiptFinal();
}
