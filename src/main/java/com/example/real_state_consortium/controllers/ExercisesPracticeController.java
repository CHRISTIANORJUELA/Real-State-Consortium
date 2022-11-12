package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.DTOs.Name;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.*;

public class ExercisesPracticeController implements Initializable {
    @FXML
    private TextField tfSubString;


    @FXML
    private TextField tfKeyAdd;

    @FXML
    private TextField tfKeyDelete;


    @FXML
    private TextField tfValueAdd;

    @FXML
    private TextArea textArea;

    @FXML
    private TableColumn<Name, String> clNamePerson;

    @FXML
    private TableColumn<Name, String> clNameSort;

    @FXML
    private TableView<Name> tableName;

    @FXML
    private TableView<Name> tableSort;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void initialize(URL url, ResourceBundle rbs){
        clNamePerson.setCellValueFactory(new PropertyValueFactory<>("namePerson"));
        clNameSort.setCellValueFactory(new PropertyValueFactory<>("namePerson"));
    }
    @FXML
    void searchSubString(ActionEvent event) {
        String subString = tfSubString.getText();
       if (subString != ""){
           mfc.searchSubString(subString,textArea);
       }
    }

    @FXML
    void changeAtNames(ActionEvent event) {
       mfc.ChangeNameAtFruit();
       refreshTable1();
    }

    public void refreshTable1(){
        ArrayList<Name> names = mfc.returnArrayNames();
        ObservableList<Name> obs1 = FXCollections.observableArrayList();
        obs1.setAll(names);
        tableName.setItems(obs1);
        tableName.refresh();
    }

    public void sort(){
        mfc.sortNames();
        refreshTable2();
    }

    public void refreshTable2(){
        List<Name> nameSort = mfc.returnNameSort();
        ObservableList<Name> obsNameSort = FXCollections.observableArrayList();
        obsNameSort.setAll(nameSort);
        tableSort.setItems(obsNameSort);
        tableSort.refresh();
    }

    @FXML
    public void addHash(ActionEvent event) {
        String key = tfKeyAdd.getText();
        String value = tfValueAdd.getText();
        if (key!="" && value!=""){
            mfc.addHash(key,value);
        }
    }


    @FXML
    public void deleteHash(ActionEvent event) {
        String key = tfKeyDelete.getText();
        if (key!=""){
            mfc.deleteHash(key);
        }
    }

    @FXML
    public void printHash(ActionEvent event) {
       mfc.printHash();
    }



}
