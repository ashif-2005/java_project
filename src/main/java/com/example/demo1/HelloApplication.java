package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage_var;
    public static Scene register_page;
    public static Scene main_page;
    public static Scene login_page;
    public static Scene admin_page;
    public static Scene forget_password;
    public static Scene recipe;
    public static Scene add;
    public static Scene new1;
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("forget.fxml"));
        FXMLLoader fxmlLoader5 = new FXMLLoader(HelloApplication.class.getResource("recipe.fxml"));
        FXMLLoader fxmlLoader6 = new FXMLLoader(HelloApplication.class.getResource("add.fxml"));
        FXMLLoader fxmlLoader7 = new FXMLLoader(HelloApplication.class.getResource("new.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Scene scene1 = new Scene(fxmlLoader1.load());
        Scene scene2 = new Scene(fxmlLoader2.load());
        Scene scene3 = new Scene(fxmlLoader3.load());
        Scene scene4 = new Scene(fxmlLoader4.load());
        Scene scene5 = new Scene(fxmlLoader5.load());
        Scene scene6 = new Scene(fxmlLoader6.load());
        Scene scene7 = new Scene(fxmlLoader7.load());

        stage_var = stage;
        login_page = scene2;
        register_page = scene1;
        admin_page = scene3;
        forget_password = scene4;
        recipe = scene5;
        add = scene6;
        new1 = scene7;

        stage.setTitle("");


        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}