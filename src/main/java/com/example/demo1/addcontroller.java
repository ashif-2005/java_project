package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class addcontroller {

    @FXML
    private TextField name;

    @FXML
    void add(ActionEvent event) throws SQLException {
        String recipe_name = name.getText();
        if(recipe_name.isEmpty()){
            System.out.println("Enter the Credentilas correctly");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter the Credentilas correctly");
            alert.show();
        }
        else{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
            String sql = "select * from recipe where recipe_name=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, recipe_name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("User Already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Name Already Exist");
                alert.show();
            } else {
                String sql1 = "insert into recipe values (?)";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement1.setString(1, recipe_name);
                statement1.execute();
                System.out.println("Values inserted into table successfully");
                HelloApplication.stage_var.setScene(HelloApplication.recipe);
            }
        }
    }
}

