package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import com.example.real_state_consortium.utils.UtilsMethods1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class StructureController implements Initializable {
    @FXML
    private ChoiceBox<Integer> chFloors = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> chExtract;
    @FXML
    private ChoiceBox<String> chStructure;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField tfMetersBackground;
    @FXML
    private TextField tfMetersFront;
    private ArrayList<Integer> numsChFloors = new ArrayList<>();
    private ArrayList<String> nameStructures = new ArrayList<>(List.of(new String[]{"Mansión", "Edificio", "Casa"}));
    private ArrayList<Integer> extractStructure = new ArrayList<>();
    private Structure structureClass = new Structure();
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i=1;i<=500;i++){numsChFloors.add(i);}
        for (int i=1;i<=10;i++){extractStructure.add(i);}
        chFloors.getItems().addAll(numsChFloors);
        chStructure.getItems().setAll(nameStructures);
        chExtract.getItems().setAll(extractStructure);
    }

    public void calculateItems(ActionEvent e){
        if (tfMetersBackground.getText() != null && tfMetersFront.getText() != null && chFloors.getValue() != null && chExtract.getValue() != null && chStructure.getValue() != null){
            if (UtilsMethods1.validateIsCampusDecimalIstrue(tfMetersBackground.getText()) && UtilsMethods1.validateIsCampusDecimalIstrue(tfMetersFront.getText())){
                double metersBackground = Double.parseDouble(tfMetersBackground.getText());
                double meterFront = Double.parseDouble(tfMetersFront.getText());
                int floors = chFloors.getValue();
                int extract = chExtract.getValue();
                String stucture = chStructure.getValue();
                mfc.calculateStructure(mfc,metersBackground,meterFront,floors,extract,stucture);
                printInTextArea();
            }
        }
    }
    public void printInTextArea(){
        Locale.setDefault(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        textArea.setText("");
        this.structureClass = mfc.getStructureClass();
        String message = "Tipo de estructura : "+structureClass.getTypeStructure()+"\n"+
                "Cantidad de Pisos: "+structureClass.getFloors()+"\n"+
                "Metros de Frente : "+structureClass.getFront()+"\n"+
                "Metros de Fondo : "+structureClass.getBackground()+"\n"+
                "Extracto de la/el: "+structureClass.getTypeStructure()+" "+structureClass.getExtractStructure()+"\n"+
                "Metros cuadrados de la edificacíon : "+decimalFormat.format(structureClass.getSquareMeters())+"\n"+
                "Precio por metro cuadrado : "+decimalFormat.format(structureClass.getPricePerMeter2())+"\n"+
                "Valor a Pagar :  "+decimalFormat.format(structureClass.getTotalPriceOfStructure());
        textArea.setWrapText(true);
        textArea.setText(message);
    }

    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }

    public void watchCatalog(MouseEvent e)  throws IOException{
        ChangeViewParticular.watchCatalog(e);
    }
    public void finallySell(MouseEvent e)throws IOException{
        ChangeViewParticular.finallySell(e);
    }

    public void watchCar(MouseEvent e) throws IOException{
        ChangeViewGeneral.watchCar(e);
    }


}
