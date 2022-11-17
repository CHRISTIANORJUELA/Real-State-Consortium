module com.example.real_state_consortium {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires annotations;

    opens com.example.real_state_consortium to javafx.fxml;
    exports com.example.real_state_consortium;
    exports com.example.real_state_consortium.controllers;
    opens com.example.real_state_consortium.controllers to javafx.fxml;
    opens com.example.real_state_consortium.models to javafx.base;
    opens com.example.real_state_consortium.DTOs to javafx.base;
    opens com.example.real_state_consortium.utils to javafx.base;
}