package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.*;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
    private ArrayList<String> nameTypeTarget = new ArrayList<>(List.of(new String[]{"Visa","Mastercard","American Express"}));
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      namesAgent = new ArrayList<>();
      namesAgent = mfc.returnAgentsIntable(mfc.getAgents());         // a la coleccion namesAgent le agrego los agentes registrados
      if (namesAgent.size()>0){                       // Para que se pueda realizar la compra
          for (ValidateAgent v:namesAgent){
              chNameAgent.getItems().addAll(v.getNameAgent());   // lleno el choiceBox correspondiente con los nombres de los agentes
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
              if (checkAnswerIsTrue(structure,allElementsInCar)){             // Valido si almenos hay una estructura o un elemento en el carrito
                  uploadCar(allElementsInCar,elementsIntheViewCar);                                                                                // Reduzco la cantidad
                  mfc.finallySell(nameClient, nameAgent,typeTarget, numberTargetCredit,allElementsInCar,structure);                                                      //Mando los datos al servicio para realizar la compta
                  ArrayList<Receipt> receipt = mfc.getReceiptFinal();         // Obtego el recibo del FinallySellService (Puede tener ya sea las 2 cosas (Estrucrura y elementos en el carrito ) o solamente una de esas dos )
                  showMessageSell(receipt);                                   // Con esta función Imprimo el Recibo
                  allElementsInCar.clear();                                   // De la linea 61 a la 63 limpio la lista del carrito , la estructura y otras listas que halla usado
                  mfc.clearData();
                  mfc.setNullStructureClassObject();
              }else {
                  PrintMessage.printMessage("Gracias","Fue un gusto contar contigo");
              }
          }
    }

    public  void showMessageSell(ArrayList<Receipt> receipt){
        Locale.setDefault(Locale.US);
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        int index = receipt.size()-1;
        Receipt re = receipt.get(index);
        String message = "";
        message += "Nombre del Cliente : "+re.getNameBuyer()+"\n"+
                    "\n"+
                    "Nombre del agente : "+re.getNameAgent()+"\n"+
                     "\n"+
                    "Fecha de la venta : "+re.getDaySell();
        if (re.getElementsAdded() != null){                                            //Valido si el recibo contiene elementos del carrito
            ArrayList<Data3> printElementsAdded = re.getElementsAdded();               //Si esto es haci imprimo lo que contenga
            for (Data3 r: printElementsAdded){
                message += "\n"+" Nombre : "+r.getNameElement()+"\n"+
                            "\n"+
                           "Cantidad del Elemento : "+r.getStockElement()+"\n"+
                            "\n"+
                           "Valor : "+decimalFormat.format(r.getValue())+"\n";
            }
        }
        if (re.getStructure() != null){                                                        //Valido si el recibo contiene una estructura
          Structure printstructure =re.getStructure();                                         // Si es imprimo lo que contenga
          message += "\n"+"Tipo de Estructura : "+printstructure.getTypeStructure()+"\n"+
                      "\n"+
                      "Metros de Frente : "+printstructure.getFront()+"\n"+
                      "\n"+
                      "Metros de Fondo : "+printstructure.getBackground()+"\n"+
                      "\n"+
                      "Metros cuadrados : "+printstructure.getSquareMeters()+"\n"+
                      "\n"+
                       "Precio por metro cuadrado : "+decimalFormat.format(printstructure.getPricePerMeter2())+
                       "\n"+
                       "Precio de la/el "+printstructure.getTypeStructure()+" : "+decimalFormat.format(printstructure.getTotalPriceOfStructure());
        }
        message += "\n"+"Precio total de la compra : "+decimalFormat.format(re.getPriceSell());
        textArea.setText("");
        textArea.setWrapText(true);
        textArea.setText(message);
        PrintMessage.printMessage("Felicidades","su compra fue realiza exitosamente");
    }

    public void uploadCar(ArrayList<Data3> allElementsInCar, ArrayList<ElementsOfView> elementsIntheViewCar){
        int stock;
        System.out.println("Antes : ");
        allElementsInCar.forEach(x-> System.out.println("cantidad : "+x.getStockElement()+" valor "+x.getValue()));
        elementsIntheViewCar.forEach(x-> System.out.println(" Nombre : "+x.getNameView().getText()+" cantidad : "+x.getStockInView().getText()+" valor : "+x.getPriceIntheView().getText()));
        for (Data3 a :allElementsInCar){                                               // Recorro los elementos del Carrito y tambiem la lista que
            for (ElementsOfView e : elementsIntheViewCar){                             // contiene la informacion de los elementos que han sido agregados al Carrito
                if (a.getNameElement().equalsIgnoreCase(e.getNameView().getText())){   // Hago esto para actualizar las unidades de las vistas
                    if (a.getStockElement()>=Integer.parseInt(e.getStockInView().getText())){
                        a.setStockElement(Integer.parseInt(e.getStockInView().getText()));
                        a.setValue(a.getStockElement()*Integer.parseInt(e.getPriceIntheView().getText()));
                        e.getStockInView().setText("0");
                        e.getDisponiblilityView().setText("Sin unidades");
                    }else {
                        stock = Integer.parseInt(e.getStockInView().getText())-a.getStockElement();
                        e.getStockInView().setText(String.valueOf(stock));
                        a.setValue(a.getStockElement()*Integer.parseInt(e.getPriceIntheView().getText()));
                        if (Integer.parseInt(e.getStockInView().getText())==0){e.getDisponiblilityView().setText("Sin unidades");}
                    }
                }
            }
        }
        System.out.println("Despues : ");
        allElementsInCar.forEach(x-> System.out.println("cantidad : "+x.getStockElement()+" valor "+x.getValue()));
        elementsIntheViewCar.forEach(x-> System.out.println(" Nombre : "+x.getNameView().getText()+" cantidad : "+x.getStockInView().getText()+" valor : "+x.getPriceIntheView().getText()));
    }

    public boolean checkAnswerIsTrue(Structure structure, ArrayList<Data3> allElementsInCar){
        if (allElementsInCar.size()>0 && structure != null){    // Valido si el usuario a cctizado una estructura o agregado elementos al carrito
            if (structure.getTypeStructure() != null){
                return PrintMessage.ComfirmationSell("Realizar la compra","Desea realizar la compra de los elementos del Carrito y Hacer la compra de su predio");
            }
        }else if (allElementsInCar.size()>0){   // Valido si el usuario solo ha ingresado elementos en el carrito
            return PrintMessage.ComfirmationSell("Realizar Compra","Desea Realizar la compra de los Elementos del Carrito");
        }else if (structure.getTypeStructure()!=null){  // Valido si el usuario solo ha cotizado una estructura
            return PrintMessage.ComfirmationSell("Desea Realizar la compra","Desea Realizar la compra de su Predio");
        }
        return false;
    }

    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }
    public void watchCar(MouseEvent e) throws IOException {
        ChangeViewGeneral.watchCar(e);
    }
    public void quoteProperty(MouseEvent e) throws IOException{
        ChangeViewParticular.quoteProperty(e);
    }
    public void watchCatalog(MouseEvent e) throws IOException{
        ChangeViewParticular.watchCatalog(e);
    }


}
