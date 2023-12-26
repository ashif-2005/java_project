package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.recepe;

public class controller {
    @FXML
    private ImageView img;

    @FXML
    private Text txt;
    void setdata(recepe data){
        txt.setText(data.getText());
    }
    @FXML
    private Label lbl;
    int i = 0;
    public void initialize(){
        String str = String.valueOf(i);
        lbl.setText(str);
    }
    @FXML
    void like(ActionEvent event) {
        ++i;
        String str = String.valueOf(i);
        lbl.setText(str);
    }

    @FXML
    void view(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.new1);
    }
}
