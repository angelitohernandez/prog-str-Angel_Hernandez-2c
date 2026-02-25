package com.example.demojavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FormController {
    @FXML
    private  TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtEdad;

    @FXML
    private Label lblResultado;

    public void onValidate(ActionEvent event){
        String nombre = txtNombre.getText() == null ? "" : txtNombre.getText();
        String correo = txtCorreo.getText() == null ? "" : txtCorreo.getText();
        String edad = txtNombre.getText() == null ? "" : txtEdad.getText();

        List<String> errores = new ArrayList<>(); //Listado de Strings

        if (nombre.trim().isEmpty() || nombre.isBlank() || nombre.length()<3){
            errores.add("El nombre es incorrecto");

        }
        if (correo.trim().isEmpty() || correo.isBlank() || !correo.contains("@") || !correo.contains(".")){
            errores.add("El correo es incorrecto, ingresa un correo valido");

        }

        try {
            int edadValida= Integer.parseInt(edad);
            if (edadValida<0 || edadValida>120 ){
                errores.add("La edad esta fuera de rango");
            }
        } catch (Exception e) {
            errores.add("El dato no es numerico");

        }
        if (errores.isEmpty()){
            lblResultado.setText("Los datos son correctos");
            lblResultado.setStyle("-fx-text-fill: green");

        }else{
            String datos="";
            for (String dato : errores){
                datos+=dato;
            }
            lblResultado.setText(datos);
            lblResultado.setStyle("-fx-text-fill: red");
        }
    }
}
