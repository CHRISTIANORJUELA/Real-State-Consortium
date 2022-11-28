package com.example.real_state_consortium.controllers;

import com.example.real_state_consortium.models.Multitask;
import com.example.real_state_consortium.utils.ChangeViewGeneral;
import com.example.real_state_consortium.utils.UtilsMethodsOfThread;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadExercisesController {
    @FXML
    private ProgressBar prBar1;
    @FXML
    private ProgressBar prbar2;
    @FXML
    private ProgressBar prbar3;
    @FXML
    private ProgressBar prbar4;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    private BigDecimal number = new BigDecimal(String.format("%.2f",0.0));
    @FXML
    void runThread(MouseEvent event) {
        //No puedo Usar el Model Factory para enlazar con unservivio Impl porque los ProgressBar
        //Son tecnologia de Javafx y no puedo juntar estas dos tecnologias.
       if (UtilsMethodsOfThread.comprobateAnyStringIsNullAndOnlyContainNumeber(tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText())){
           int speed1 = Math.round(Integer.parseInt(tf1.getText()));
           int speed2 = Math.round(Integer.parseInt(tf2.getText()));
           int speed3 = Math.round(Integer.parseInt(tf3.getText()));
           int speed4 = Math.round(Integer.parseInt(tf4.getText()));
           Multitask m1 = new Multitask(speed1,prBar1);
           Multitask m2 = new Multitask(speed2,prbar2);
           Multitask m3 = new Multitask(speed3,prbar3);
           Multitask m4 = new Multitask(speed4,prbar4);
           m1.start();
           m2.start();
           m3.start();
           m4.start();
       }
    }
    @FXML
    public void runCompletablefuture(MouseEvent e){
        if (UtilsMethodsOfThread.comprobateAnyStringIsNullAndOnlyContainNumeber(tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText())){
            int speed1 = Math.round(Integer.parseInt(tf1.getText()));
            int speed2 = Math.round(Integer.parseInt(tf2.getText()));
            int speed3 = Math.round(Integer.parseInt(tf3.getText()));
            int speed4 = Math.round(Integer.parseInt(tf4.getText()));
            ExecutorService ex = Executors.newFixedThreadPool(4);
            CompletableFuture.runAsync(()->progress(prBar1,speed1),ex);
            CompletableFuture.runAsync(()-> progress(prbar2,speed2),ex);
            CompletableFuture.runAsync(()-> progress(prbar3,speed3),ex);
            CompletableFuture.runAsync(()->progress(prbar4,speed4),ex);
        }
    }
    private void progress(ProgressBar prbar, int value) {
            while(number.doubleValue()<1){
                number = new BigDecimal(String.format("%.2f",number.doubleValue()+0.1));
                try {
                    Thread.sleep(value* 5L);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
                prbar.setProgress(number.doubleValue());
            }
    }
    @FXML
    public void restartCar(MouseEvent e) {
        prBar1.setProgress(0);
        prbar2.setProgress(0);
        prbar3.setProgress(0);
        prbar4.setProgress(0);
        number = BigDecimal.valueOf(0);
    }
    @FXML
    public void goBack(MouseEvent e) throws IOException{
        ChangeViewGeneral.goBack(e);
    }

}
