package com.example.demo.controllers;

import com.example.demo.services.PersonaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
//import java.lang.classfile.Label;

import java.util.List;

public class AppController {
    @FXML
    private Label labelS;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtedad;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonaService service = new PersonaService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                String[] parts = newValue.split("-");
                txtname.setText(parts[0]);
                txtemail.setText(parts[1]);
                txtedad.setText(parts[2]);
            }
        });
        loadFromFile();
    }


    @FXML
    public void onDelete(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtname.getText();
            String email = txtemail.getText();
            String edad = txtedad.getText();
            service.delete(index,name,email,edad);
            loadFromFile();
            txtname.clear();
            txtemail.clear();
            txtedad.clear();
            labelS.setText("Se Elimino correctamente");
        } catch (IllegalArgumentException e) {
            labelS.setText("Hubo un error en el archivo"+e.getMessage());
        } catch (Exception e){
            labelS.setText("Hubo un error en los datos"+e.getMessage());
        }
    }

    @FXML
    public void onUpdate(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();
            String name = txtname.getText();
            String email = txtemail.getText();
            String edad = txtedad.getText();
            service.update(index,name,email,edad);
            loadFromFile();
            txtname.clear();
            txtemail.clear();
            txtedad.clear();
            labelS.setText("Se actualizo correctamente");
        } catch (IllegalArgumentException e) {
            labelS.setText("Hubo un error en el archivo"+e.getMessage());
        } catch (Exception e){
            labelS.setText("Hubo un error en los datos"+e.getMessage());
        }
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public  void onAddPerson(){
        try {
            String name = txtname.getText();
            String email = txtemail.getText();
            String edad = txtedad.getText();
            service.addPerson(name,email,edad);
            labelS.setText("El Usuario se a creado Correctamente");
            labelS.setStyle("-fx-text-fill: green");
            txtname.clear();
            txtemail.clear();
            txtedad.clear();
            loadFromFile();
        } catch (IOException e) {
            labelS.setText("Error "+e.getMessage());
            labelS.setStyle("-fx-text-fill:red");
        } catch (IllegalArgumentException e) {
            labelS.setText("Error de datos "+e.getMessage());
            labelS.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll(items);
            labelS.setText("Datos cargados Exitosamente");
            labelS.setStyle("-fx-text-fill:green");
        } catch (IOException e) {
            labelS.setText("Error: "+e.getMessage());
            labelS.setStyle("-fx-text-fill:red");
        }
    }
}