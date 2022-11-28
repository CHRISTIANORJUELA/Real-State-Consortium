package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.ValidateAgent;
import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.ChangeViewParticular;
import com.example.real_state_consortium.utils.UtilsMethods1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgentController implements Initializable {
    @FXML
    private TableColumn<String, ValidateAgent> clNameAgent;
    @FXML
    private TableColumn<String, ValidateAgent> clPassWordAgent;
    @FXML
    private TableView<ValidateAgent> tableAgents;

    @FXML
    private TextField tfSearch;
    @FXML
    private TextField tfNameAgent;
    @FXML
    private TextField tfPassWordAgent;

    @FXML
    private ObservableList<ValidateAgent> observableList;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      refreshTableAgent();
      clNameAgent.setCellValueFactory(new PropertyValueFactory<>("nameAgent"));
      clPassWordAgent.setCellValueFactory(new PropertyValueFactory<>("code"));
    }

    @FXML
    public void addAgent(MouseEvent event) {
      if (UtilsMethods1.validateIscampusStringIsTrue(tfNameAgent.getText()) && tfPassWordAgent.getText() != null){
          String name = tfNameAgent.getText();
          String passWord = tfPassWordAgent.getText();
          mfc.addAgent(name,passWord);
          refreshTableAgent();
      }
    }



    @FXML
    public void deleteAgent(MouseEvent event) {
        ValidateAgent agentSelect = tableAgents.getSelectionModel().getSelectedItem();
        tableAgents.getSelectionModel().select(-1);
        if (agentSelect != null){
           mfc.deleteAgentInTable(agentSelect);
           refreshTableAgent();
        }
    }

    public void select(MouseEvent e){
        ValidateAgent agentSelect = tableAgents.getSelectionModel().getSelectedItem();
        if (agentSelect != null){
            tfNameAgent.setText(agentSelect.getNameAgent());
            tfPassWordAgent.setText(agentSelect.getCode());
        }
    }



    @FXML
    public void modifyAgent(MouseEvent event) {
       ValidateAgent select = tableAgents.getSelectionModel().getSelectedItem();
       if (UtilsMethods1.validateIscampusStringIsTrue(tfNameAgent.getText()) && tfPassWordAgent.getText() != null  && select!= null){
           String name = tfNameAgent.getText();
           String passWord = tfPassWordAgent.getText();
           mfc.modifyAgents(select,name,passWord);
           refreshTableAgent();
       }
    }

    @FXML
    public void searchAgents(KeyEvent event) {
       String name = tfSearch.getText();
       if (name!=null){
           mfc.searchAgent(name);
           refreshTableFilter();
       }else {
           tableAgents.setItems(observableList);
       }
    }

    public void refreshTableAgent(){
        ArrayList<ValidateAgent> agentsTb = mfc.returnAgentsIntable();
        if (agentsTb.size()>0){
            observableList = FXCollections.observableArrayList();
            observableList.setAll(agentsTb);
            tableAgents.setItems(observableList);
            tableAgents.refresh();
        }
    }
    public void refreshTableFilter(){
        ArrayList<ValidateAgent> agentsAlreadyFilter = mfc.returnAgentsFilter();
        if (agentsAlreadyFilter.size()>0){
            ObservableList<ValidateAgent> observableListFilter = FXCollections.observableArrayList();
            observableListFilter.setAll(agentsAlreadyFilter);
            tableAgents.setItems(observableListFilter);
            tableAgents.refresh();
        }
    }

    @FXML
    public void goBack(MouseEvent e) throws IOException {
        ChangeViewGeneral.goBack(e);
    }


}
