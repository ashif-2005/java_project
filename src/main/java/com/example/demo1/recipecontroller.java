package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.recepe;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class recipecontroller {

    @FXML
    private TextField search;

    @FXML
    private Pane cardlayout;

    private List<recepe> recentlyAdded;
    private List<recepe> Maincourse;
    private List<recepe> Appetizer;
    private List<recepe> Dessert;
    private List<recepe> Search;
    private List<recepe> Beverage;
    private List<recepe> Recommendation;


    @FXML
    void searchonclick(ActionEvent event) throws SQLException, IOException {
        String searchText = search.getText();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql = "insert into search values (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,searchText);
        statement.execute();
        System.out.println("Values inserted into table successfully");
        removeitem();
        Search = new ArrayList<>(Search(searchText));
        for(int i=0;i<Search.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(Search.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }

    public void initialize() throws SQLException, IOException {
        removeitem();
        recentlyAdded = new ArrayList<>(recentlyAdded());
        for(int i=0;i<recentlyAdded.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));

            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(recentlyAdded.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }

    @FXML
    void first(ActionEvent event) throws SQLException, IOException {
        removeitem();
        recentlyAdded = new ArrayList<>(recentlyAdded());
        for(int i=0;i<recentlyAdded.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));

            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(recentlyAdded.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }
    private List<recepe> recentlyAdded() throws SQLException {
        List<recepe> l = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql = "select * from recipe";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        ResultSet resultSet1 = statement1.executeQuery();
        while(resultSet1.next()) {
            recepe data = new recepe();
            String name = resultSet1.getString("recipe_name");
            data.setText(name);
            l.add(data);
        }
        return l;
    }

    @FXML
    void beverages(ActionEvent event) throws IOException, SQLException {
        removeitem();
        Beverage = new ArrayList<>(Beverage());
        for(int i=0;i<Beverage.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(Beverage.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }

    @FXML
    void desserts(ActionEvent event) throws IOException, SQLException {
        removeitem();
        Dessert = new ArrayList<>(Dessert());
        for(int i=0;i<Dessert.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(Dessert.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }

    @FXML
    void onappetizers(ActionEvent event) throws SQLException, IOException {
        removeitem();
        Appetizer = new ArrayList<>(Appetizer());
        for(int i=0;i<Appetizer.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(Appetizer.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }

    @FXML
    void maincourse(ActionEvent event) throws SQLException, IOException {
        removeitem();
        Maincourse = new ArrayList<>(Maincourse());
        for(int i=0;i<Maincourse.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(Maincourse.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }
    void removeitem(){
        if(!cardlayout.getChildren().isEmpty()) {
            cardlayout.getChildren().clear();
        }
    }
    private List<recepe> Appetizer() throws SQLException {
        List<recepe> l = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql = "select * from starters";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        ResultSet resultSet1 = statement1.executeQuery();
        while(resultSet1.next()) {
            recepe data = new recepe();
            String name = resultSet1.getString("name");
            data.setText(name);
            l.add(data);
        }
        return l;
    }
    private List<recepe> Search(String txt) throws SQLException {
        List<recepe> l = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql = "select * from recipe where recipe_name like ?" ;
        PreparedStatement statement1 = connection.prepareStatement(sql);
        statement1.setString(1,"%"+txt+"%");
        ResultSet resultSet1 = statement1.executeQuery();
        while(resultSet1.next()) {
            recepe data = new recepe();
            String name = resultSet1.getString("recipe_name");
            data.setText(name);
            l.add(data);
        }
        return l;
    }
    private List<recepe> Dessert() throws SQLException {
        List<recepe> l = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql = "select * from desserts";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        ResultSet resultSet1 = statement1.executeQuery();
        while(resultSet1.next()) {
            recepe data = new recepe();
            String name = resultSet1.getString("name");
            data.setText(name);
            l.add(data);
        }
        return l;
    }
    private List<recepe> Beverage  () throws SQLException {
        List<recepe> l = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql = "select * from beverages";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        ResultSet resultSet1 = statement1.executeQuery();
        while(resultSet1.next()) {
            recepe data = new recepe();
            String name = resultSet1.getString("name");
            data.setText(name);
            l.add(data);
        }
        return l;
    }
    private List<recepe> Maincourse  () throws SQLException {
        List<recepe> l = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql = "select * from main_course";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        ResultSet resultSet1 = statement1.executeQuery();
        while(resultSet1.next()) {
            recepe data = new recepe();
            String name = resultSet1.getString("name");
            data.setText(name);
            l.add(data);
        }
        return l;
    }
    @FXML
    void logout(ActionEvent event) {
        HelloApplication.stage_var.setScene(HelloApplication.login_page);
    }
    @FXML
    void recommendation(ActionEvent event) throws SQLException, IOException {
        removeitem();
        Recommendation = new ArrayList<>(Recommendation());
        for(int i=0;i<Recommendation.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("card.fxml"));
            Pane cardbox = fxmlLoader.load();
            controller cardcontroller = fxmlLoader.getController();
            cardcontroller.setdata(Recommendation.get(i));
            cardlayout.getChildren().add(cardbox);
        }
    }
    private List<recepe> Recommendation() throws SQLException {
        List<recepe> l = new ArrayList<>();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe", "root", "Ashif@2005");
        String sql1 = "select * from search";
        PreparedStatement statement = connection.prepareStatement(sql1);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()) {
            String value = resultSet.getString("value");
            String sql = "select * from recipe where recipe_name like ?";
            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setString(1,"%"+value+"%");
            ResultSet resultSet1 = statement1.executeQuery();
            while (resultSet1.next()) {
                recepe data = new recepe();
                String name = resultSet1.getString("recipe_name");
                data.setText(name);
                l.add(data);
            }
        }
        return l;
    }}
