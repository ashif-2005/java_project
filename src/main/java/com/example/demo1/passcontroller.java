package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

public class passcontroller {

    @FXML
    private PasswordField pass;

    @FXML
    private TextField user;

    @FXML
    void confirmonclick(ActionEvent event) throws SQLException {
        String User = user.getText();
        String Pass = pass.getText();
        if(User.isEmpty() || Pass.isEmpty()){
            System.out.println("Enter the Credentilas correctly");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter the Credentilas correctly");
            alert.show();
        }
        else {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
            String sql = "select * from user where username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, User);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("User Already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Name Already Exist");
                alert.show();
            } else {
                String sql1 = "update user set password=? where user_name=?";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement1.setString(1, User);
                statement1.setString(2, Pass);
                statement1.execute();
                System.out.println("Values updated into table successfully");
                HelloApplication.stage_var.setScene(HelloApplication.recipe);
            }
        }
        HelloApplication.stage_var.setScene(HelloApplication.login_page);
    }
}

