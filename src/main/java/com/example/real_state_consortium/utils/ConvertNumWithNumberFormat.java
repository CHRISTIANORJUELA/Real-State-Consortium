package com.example.real_state_consortium.utils;

import com.example.real_state_consortium.models.Data3;
import javafx.collections.ObservableList;

import java.util.ArrayList;

@FunctionalInterface
public interface ConvertNumWithNumberFormat {
    int convert(ObservableList<Data3> obs, ArrayList<Data3> list);
}
