package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class admincontroller {

    @FXML
    private TextField pass;

    @FXML
    private TextField user;
    @FXML
    void adminlogin(ActionEvent event) throws SQLException {
        String userText = user.getText();
        String passText = pass.getText();
        if(userText.isEmpty() || passText.isEmpty()){
            System.out.println("Enter the Credentials correctly");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Enter the Credentials correctly");
            alert.show();
        }
        else{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
            String sql = "select * from admindata where username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userText);
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("User Dose Not Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Does Not Exist");
                alert.show();
            }
            else {
                String sql1 = "select password from person where username=?";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement.setString(1, userText);
                ResultSet resultSet1 = statement.executeQuery();
                while (resultSet1.next()) {
                    String pas = resultSet1.getString("password");
                    if (pas.equals(passText)) {
                        HelloApplication.stage_var.setScene(HelloApplication.add);
                    } else {
                        System.out.println("Invalid UserName or Password");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Invalid UserName or Password");
                        alert.show();
                    }
                }
            }
        }
    }

    @FXML
    void forget_pass(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.forget_password);
    }

}
