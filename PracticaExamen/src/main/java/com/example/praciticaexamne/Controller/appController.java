package com.example.praciticaexamne.Controller;

import com.example.praciticaexamne.Contacto.contacto;
import com.example.praciticaexamne.validaciones.validaciones;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



public class appController {

    validaciones validar = new validaciones();
    public int id=0;

    @FXML
    private ComboBox<String> parentestos;

    @FXML
    private TextField nombre;

    @FXML
    private TextField telefono;

    @FXML
    private Label Mensaje;

    @FXML
    private TextField buscarCon;


    @FXML
    private ListView<contacto> listaContactos;

    private ObservableList<contacto> contactos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        String[] parentescos = {
                "Padre", "Madre", "Hermano", "Hermana",
                "Abuelo", "Abuela", "Tío", "Tía"
        };

        parentestos.getItems().addAll(parentescos);

        listaContactos.setItems(contactos);

    }

    public void actualizar(){
        String buscarC = buscarCon.getText();
        String Nombre = nombre.getText();
        String Telefono = telefono.getText();
        String Parentesco = parentestos.getValue();

        Boolean v = validar.Validar(Nombre,Telefono,Parentesco);
        if (v == true){
            for (contacto c: contactos){
                if (buscarC.equals(c.getNombre())){
                    int IDE = c.getId();
                    contacto NuevoContaco = new contacto(Nombre,Telefono,Parentesco,IDE);
                    contactos.set(IDE,NuevoContaco);
                    buscarCon.clear();
                    nombre.clear();
                    telefono.clear();
                    parentestos.setValue(null);
                }
            }
        } else {
            Mensaje.setText("Error en los datos");
        }

    }
    public void agregar(){
        boolean valido = false;
        String Nombre = nombre.getText();
        String Telefono = telefono.getText();
        String Parentesco = parentestos.getValue();
        for (contacto c: contactos){
            if (Nombre.equals(c.getNombre())) {
                Mensaje.setText("Nombre repetidos");
                return;
            }
        }
        Boolean v = validar.Validar(Nombre,Telefono,Parentesco);
        if (v == true){
            contacto NuevoContaco = new contacto(Nombre,Telefono,Parentesco,id);
            contactos.add(NuevoContaco);
            nombre.clear();
            telefono.clear();
            parentestos.setValue(null);
            Mensaje.setText("");
            valido = true;
            id++;
        }
        if (!valido){
            Mensaje.setText("Error en los datos");
            Mensaje.setStyle("-fx-text-fill: red");
        }


    }
    public void eliminar(){
        String Nombre = nombre.getText();
        for (contacto c: contactos){
            if (Nombre.equals(c.getNombre())){
                contactos.remove(c);
                nombre.clear();
                telefono.clear();
                parentestos.setValue(null);
                buscarCon.clear();
                break;
            }
        }
    }
    public void buscar(){
        boolean encontrado =  false;
        String Nombre = buscarCon.getText();
        for (contacto c: contactos){
            if (Nombre.equals(c.getNombre())){
                buscarCon.setText(c.getNombre());
                nombre.setText(c.getNombre());
                telefono.setText(c.getTelefeno());
                parentestos.setValue(c.getParentesco());
                Mensaje.setText("");
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            Mensaje.setText("Numero no encontrado :(");
            Mensaje.setStyle("-fx-text-fill: red");
        }
    }
    public void limpiar(){
        buscarCon.clear();
        nombre.clear();
        telefono.clear();
        parentestos.setValue(null);
    }

}