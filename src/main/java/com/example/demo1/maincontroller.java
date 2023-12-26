package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class maincontroller {

    @FXML
    public static Label welcome_text;

    @FXML
    void logoutclicked(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.login_page);
    }

}
