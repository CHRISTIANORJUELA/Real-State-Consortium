package com.example.real_state_consortium.models;

import javafx.scene.control.ProgressBar;

import java.math.BigDecimal;

// Pregunta-- ******
public class Multitask extends Thread {
    private int slowness;
    private ProgressBar progressBar;
    private BigDecimal number;
    public Multitask(int slowness,ProgressBar progressBar){
        this.slowness = slowness;
        this.progressBar = progressBar;
        number = new BigDecimal(String.format("%.2f",0.0));
    }

    public void run(){
        try {
            while(number.doubleValue()<1){
                number = new BigDecimal(String.format("%.2f",number.doubleValue()+0.1));
                Thread.sleep(slowness);
                progressBar.setProgress(number.doubleValue());
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public int getSlowness() {return slowness;}

    public ProgressBar getProgressBar() {return progressBar;}

    public BigDecimal getNumber() {return number;}
}

