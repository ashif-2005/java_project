package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class newcontroller {

    @FXML
    void back(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.recipe);
    }

}
