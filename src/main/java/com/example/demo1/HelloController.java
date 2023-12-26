package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HelloController {

    @FXML
    void adminonclick(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.admin_page);
    }

    @FXML
    void useronclick(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.login_page);
    }

}
