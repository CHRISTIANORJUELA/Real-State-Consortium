package com.example.real_state_consortium.controllers;


import com.example.real_state_consortium.services.Impl.AddAtCarImpl;
import com.example.real_state_consortium.services.Impl.Laboratory;
import com.example.real_state_consortium.utils.ElementsOfView;
import com.example.real_state_consortium.utils.ExtractNodes;
import com.example.real_state_consortium.utils.UtilsMethods1;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class StartElementsOfController {
    static Label lbUnits;
    static Label lbDisponibility;
    static TextField tfEnterStock;
    static Label lbPrice;
    static Label lbNameProduct;

    public static ModelFactoryController mfc = ModelFactoryController.getInstance();
    public static Laboratory laboratory = new Laboratory();
    public static void firstStep(Button button){
        loadInformationOfView(button);
        if (UtilsMethods1.validateIscampusNumberIsTrue(tfEnterStock.getText())){
            System.out.println("Nombre"+lbNameProduct.getText());
            System.out.println("Cantidad"+lbUnits.getText());
            System.out.println("Disponible"+lbDisponibility.getText());
            System.out.println("Precio"+lbPrice.getText());
            System.out.println("Cantidad entrada "+tfEnterStock.getText());
            String idBtn = button.getId();
            String units = lbUnits.getText();
            String disponibility = lbDisponibility.getText();
            String stockEnter = tfEnterStock.getText();
            String price = lbPrice.getText();
            String nameProduct = lbNameProduct.getText();
            if (UtilsMethods1.validateSecondEnter(units,disponibility,stockEnter)){
                ArrayList<ElementsOfView> elementsOfViews = mfc.getElementsInTheView();
                UtilsMethods1.validateElementsView(elementsOfViews,button,lbUnits,lbDisponibility,tfEnterStock,lbPrice,lbNameProduct);
                mfc.addElementIncarr(mfc,laboratory,idBtn,units,disponibility,stockEnter,price,nameProduct);
            }
    }
}
   public static void loadInformationOfView(Button button){
    AnchorPane an = (AnchorPane) button.getParent();
    ArrayList<Node> nodeArrayList = new ArrayList<>();
    ArrayList<Node> nodes;
    nodes = returnNode(an,nodeArrayList);
    Optional<Node> nodeStock = nodes.stream().filter(x->x.getId().contains("lbStock")).findFirst();
    nodeStock.ifPresent(node -> lbUnits = (Label) node);
    Optional<Node> nodedisponibylity = nodes.stream().filter(x->x.getId().contains("lbDisponibylity")).findFirst();
    nodedisponibylity.ifPresent(node -> lbDisponibility = (Label) node);
    Optional<Node> nodeTfStock = nodes.stream().filter(x->x.getId().contains("tfUnits")).findFirst();
    nodeTfStock.ifPresent(node -> tfEnterStock = (TextField) node);
    Optional<Node> lbpri =nodes.stream().filter(x->x.getId().contains("lbPrice")).findFirst();
    lbpri.ifPresent(node -> lbPrice = (Label) node);
    Optional<Node> nodename = nodes.stream().filter(x->x.getId().contains("nameProduct")).findFirst();
    nodename.ifPresent(node -> lbNameProduct = (Label) node);
      nodes.clear();
    }

    public  static ArrayList<Node> returnNode(AnchorPane an,ArrayList<Node> nodeArrayList){
        nodeArrayList.clear();
        ExtractNodes ex= (anchorPane)->{
            for (int i=0;i<anchorPane.getChildren().size();i++){
                if (anchorPane.getChildren().get(i).getId()!=null){
                    nodeArrayList.add(anchorPane.getChildren().get(i));
                }
            }
            return nodeArrayList;
        };
        return ex.cathchNode(an);
    }



}
