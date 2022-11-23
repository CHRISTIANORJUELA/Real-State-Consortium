package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.Receipt;
import com.example.real_state_consortium.models.Structure;
import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FinallySellController implements Initializable {
    @FXML
    private ChoiceBox<String> chNameAgent;
    @FXML
    private ChoiceBox<String> chTypeTarget;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfNumTargetCredit;
    ArrayList<ElementsOfView> elementsIntheViewCar;
    private ArrayList<ValidateAgent> namesAgent;
    private ArrayList<String> nameTypeTarget = new ArrayList<String>(List.of(new String[]{"Visa","Mastercard","American Express"}));
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      namesAgent = new ArrayList<>();
      namesAgent = mfc.returnAgentsIntable();
      if (namesAgent.size()>0){
          for (ValidateAgent v:namesAgent){
              chNameAgent.getItems().addAll(v.getNameAgent());
          }
      }
      chTypeTarget.getItems().addAll(nameTypeTarget);
    }
    @FXML
    private void btnFinallySell(ActionEvent e) {
          String nameClient = tfName.getText();
          String nameAgent = chNameAgent.getValue();
          String typeTarget = chTypeTarget.getValue();
          String numberTargetCredit = tfNumTargetCredit.getText();
          ArrayList<Data3> allElementsInCar = mfc.getListAllElementsCar();
          elementsIntheViewCar = mfc.getElementsInTheView();
          Structure structure = mfc.getStructureClass();
          if (UtilsMethods1.makeSurePassIsTrue( nameClient,nameAgent,typeTarget,numberTargetCredit,allElementsInCar,structure)){
              if (checkAnswerIsTrue(structure,allElementsInCar)){
                  uploadCar(allElementsInCar,elementsIntheViewCar);
                  mfc.finallySell(nameClient, nameAgent,typeTarget, numberTargetCredit,allElementsInCar,structure);
                  ArrayList<Receipt> receipt = mfc.getReceiptFinal();
                  showMessageSell(receipt);
                  allElementsInCar.clear();
                  mfc.clearData();
                  mfc.setNullStructureClassObject();
              }else {
                  PrintMessage.printMessage("Gracias","Fue un gusto contar contigo");
              }
          }
    }

    public  void showMessageSell(ArrayList<Receipt> receipt){
        int index = receipt.size()-1;
        Receipt re = receipt.get(index);
        String message = "";
        message += "Nombre del Cliente : "+re.getNameBuyer()+"\n"+
                    "Fecha de la venta : "+re.getDaySell();
        if (re.getElementsAdded() != null){
            ArrayList<Data3> printElementsAdded = re.getElementsAdded();
            for (Data3 r: printElementsAdded){
                message += "\n"+" Nombre : "+r.getNameElement()+"\n"+
                            "\n"+
                           "Cantidad del Elemento : "+r.getStockElement()+"\n"+
                            "\n"+
                           "Valor : "+r.getValue()+"\n";
            }
        }
        if (re.getStructure() != null){
          Structure printstructure =re.getStructure();
          message += "\n"+"Tipo de Estructura : "+printstructure.getTypeStructure()+"\n"+
                      "\n"+
                      "Metros de Frente : "+printstructure.getFront()+"\n"+
                      "\n"+
                      "Metros de Fondo : "+printstructure.getBackground()+"\n"+
                      "\n"+
                      "Metros cuadrados "+printstructure.getSquareMeters()+"\n";
        }
        message += "\n"+"Precio total de la compra : "+re.getPriceSell();
        textArea.setText("");
        textArea.setWrapText(true);
        textArea.setText(message);
        PrintMessage.printMessage("Felicidades","su compra fue realiza exitosamente");
    }

    public void uploadCar(ArrayList<Data3> allElementsInCar, ArrayList<ElementsOfView> elementsIntheViewCar){
        int stock;
        for (ElementsOfView e :elementsIntheViewCar){
            for (Data3 a : allElementsInCar){
                if (a.getNameElement().equalsIgnoreCase(e.getNameView().getText())){
                    if (a.getStockElement()>=Integer.parseInt(e.getStockInView().getText())){
                        a.setStockElement(Integer.parseInt(e.getStockInView().getText()));
                        e.getStockInView().setText("0");
                        e.getDisponiblilityView().setText("Sin unidades");
                    }else {
                        stock = Integer.parseInt(e.getStockInView().getText())-a.getStockElement();
                        e.getStockInView().setText(String.valueOf(stock));
                        a.setStockElement(stock);
                        if (Integer.parseInt(e.getStockInView().getText())==0){e.getDisponiblilityView().setText("Sin unidades");}
                    }
                }
                a.setValue(a.getStockElement()*Integer.parseInt(e.getPriceIntheView().getText()));
            }
        }
    }

    public boolean checkAnswerIsTrue(Structure structure, ArrayList<Data3> allElementsInCar){
        if (allElementsInCar.size()>0 && structure != null){
            if (structure.getTypeStructure() != null){
                return PrintMessage.ComfirmationSell("Realizar la compra","Desea realizar la compra de los elementos del Carrito y Hacer la compra de su predio");
            }
        }else if (allElementsInCar.size()>0){
            return PrintMessage.ComfirmationSell("Realizar Compra","Desea Realizar la compra de los Elementos del Carrito");
        }else if (structure.getTypeStructure()!=null){
            return PrintMessage.ComfirmationSell("Desea Realizar la compra","Desea Realizar la compra de su Predio");
        }
        return false;
    }
    @FXML
    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }

}
