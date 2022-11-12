package com.example.real_state_consortium.services;

import com.example.real_state_consortium.DTOs.Name;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public interface ModelFactoryService {
    void searchSubString(String subString, TextArea textArea);
    void ChangeNameAtFruit();

    ArrayList<Name> returnArrayNames();

    void sortNames();

    List<Name> returnNameSort();

    void addHash(String key, String value);

    void deleteHash(String key);

    void printHash();
}
