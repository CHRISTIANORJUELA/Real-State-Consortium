package com.example.real_state_consortium.services.Impl;

import com.example.real_state_consortium.DTOs.Name;
import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.services.ExercisesPracticeService;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ExercisesPracticeImpl implements ExercisesPracticeService {
    ArrayList<ValidateAgent> users = new ArrayList<>();
    List<Name> names;
    ArrayList<Name> nameReturn;
    List<Name> nameSort;
    Map<String,String> map1 = new HashMap<>();
    ValidateAgent ch1 = new ValidateAgent("Maria", "230");
    ValidateAgent ch2 = new ValidateAgent("Manuel", "820");
    ValidateAgent ch3 = new ValidateAgent("Camilo", "1100");
    ValidateAgent ch4 = new ValidateAgent("Pablo", "4230");

    public  void searchSubString(String subString, TextArea textArea){
        setUsers(users,ch1,ch2,ch3,ch4);
        textArea.clear();
        List<ValidateAgent> elementReturn = users.stream().filter(x -> x.getNameAgent().toLowerCase().contains(subString.toLowerCase())).limit(1).collect(Collectors.toList());
            if (elementReturn.size()==1){
                textArea.setText("El elemento es : "+elementReturn.get(0).getNameAgent());
            }else {
                textArea.setText("La subcadena no coincide con algun elemento");
            }
    }

    public void ChangeNameAtFruit(){
        // La clase Name es Un DTOs
        boolean pass = clearList(users);
        if (pass==false){
            setUsers(users,ch1,ch2,ch3,ch4);
            names = users.stream().map(x -> new Name(x.getNameAgent())).toList();
            nameReturn = new ArrayList<>(names);
        }else {
            if (nameReturn != null){
                nameReturn.clear();
            }
            names = users.stream().map(x -> new Name(x.getNameAgent())).toList();
            nameReturn = new ArrayList<>(names);
        }
    }

    public void sortNames(){
        setUsers(users,ch1,ch2,ch3,ch4);
        nameSort = users.stream().map(x -> new Name(x.getNameAgent())).sorted(Comparator.comparing(Name::getNamePerson)).toList();
    }

    public void addHash(String key,String value){
        //Pregunta *******
        /*Map<String,String> map1= users.stream().collect(Collectors.toMap(ValidateAgent::getNameAgent,ValidateAgent::getCode));
        System.out.println(map1);
         */
        ///Pregunta *******
        setUsers(users,ch1,ch2,ch3,ch4);
        checkNotNullMap1();
        if (!map1.containsKey(key)){
        map1.put(key,value);
        printWindowAdd();
        }else {String messaje = "Prueba con otra Clave porque este ya existe";printWindow(messaje);}

    }
    public boolean clearList(ArrayList<ValidateAgent> users){
        if (users == null){
            return false;
        } else if (users.size()>0) {
            return true;
        }
        return false;
    }

    public  void deleteHash(String key){
        setUsers(users,ch1,ch2,ch3,ch4);
        checkNotNullMap1();
        if (map1.containsKey(key)){map1.remove(key);}else {
            String message = "Este Valor No existe";
            printWindow(message);
        }
    }
    public void printHash(){
        setUsers(users,ch1,ch2,ch3,ch4);
        checkNotNullMap1();
        map1.forEach((k,v) -> System.out.println("Clave : "+k+" Valor "+v));
    }

    public void setUsers(ArrayList<ValidateAgent> users, ValidateAgent ch1, ValidateAgent ch2, ValidateAgent ch3, ValidateAgent ch4){
        if (users.size()==0){
            users.add(ch1);
            users.add(ch2);
            users.add(ch3);
            users.add(ch4);
        }
    }

    public void checkNotNullMap1(){
        if (map1.size()==0){
            map1 = setUpMap1(users);
        }
    }

    public Map<String, String> setUpMap1(ArrayList<ValidateAgent> users){
        return users.stream().collect(Collectors.toMap(ValidateAgent::getNameAgent, ValidateAgent::getCode));
    }

    public void printWindow(String message){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Mensaje");
        a.setHeaderText("Lo sentimos");
        a.setContentText(message);
        a.showAndWait();
    }

    public void printWindowAdd(){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Mensaje");
        a.setHeaderText("Operacion");
        a.setContentText("Exitosa");
        a.showAndWait();
    }

    public ArrayList<Name> returnArrayNames(){
        return nameReturn;
    }
    public List<Name> returnNameSort(){
        return nameSort;
    }
}
