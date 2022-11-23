package com.example.real_state_consortium.utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ElementsOfView {

    private Button button;
    private Label nameView;
    private Label disponiblilityView;
    private Label stockInView;
    private Label priceIntheView;

    public ElementsOfView(Button button,Label nameView, Label disponiblilityView, Label stockInView, Label priceIntheView){
        this.button = button;
        this.nameView = nameView;
        this.disponiblilityView = disponiblilityView;
        this.stockInView = stockInView;
        this.priceIntheView = priceIntheView;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Label getNameView() {
        return nameView;
    }

    public void setNameView(Label nameView) {
        this.nameView = nameView;
    }

    public Label getDisponiblilityView() {
        return disponiblilityView;
    }

    public void setDisponiblilityView(String disponiblilityView) {
        this.disponiblilityView.setText(disponiblilityView);
    }

    public Label getStockInView() {
        return stockInView;
    }

    public void setStockInView(String stockInView) {
        this.stockInView.setText(stockInView);
    }

    public Label getPriceIntheView() {
        return priceIntheView;
    }

    public void setPriceIntheView(Label priceIntheView) {
        this.priceIntheView = priceIntheView;
    }
}
