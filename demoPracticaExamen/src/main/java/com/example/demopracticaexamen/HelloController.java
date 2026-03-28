package com.example.demopracticaexamen;

import com.example.demopracticaexamen.Contacto.Contacto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;

public class HelloController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtParentesco;
    @FXML private ListView<Contacto> listViewContactos;
    @FXML private Label lblEstado;

    private Contacto[] misContactos = new Contacto[100];
    private int contador = 0;

    @FXML
    protected void onAgregarClick() {
        String n = txtNombre.getText().trim();
        String t = txtTelefono.getText().trim();
        String p = txtParentesco.getText().trim();

        if (validar(n, t, p)) {
            if (buscarIndice(n) != -1) {
                notificar("Error: El nombre ya existe", false);
            } else if (contador < misContactos.length) {
                misContactos[contador++] = new Contacto(n, t, p);
                refrescar();
                onLimpiarClick();
                notificar("¡Contacto guardado correctamente!", true);
            }
        }
    }

    @FXML
    protected void onBuscarClick() {
        int i = buscarIndice(txtNombre.getText().trim());
        if (i != -1) {
            txtTelefono.setText(misContactos[i].getTelefono());
            txtParentesco.setText(misContactos[i].getParentesco());
            notificar("Contacto localizado", true);
        } else {
            notificar("No se encontró ese nombre", false);
        }
    }

    @FXML
    protected void onActualizarClick() {
        int i = buscarIndice(txtNombre.getText().trim());
        if (i != -1) {
            String t = txtTelefono.getText().trim();
            if (t.length() == 10) {
                misContactos[i].setTelefono(t);
                misContactos[i].setParentesco(txtParentesco.getText().trim());
                refrescar();
                notificar("Datos actualizados correctamente", true);
            } else {
                notificar("Error: Teléfono debe tener 10 dígitos", false);
            }
        } else {
            notificar("Error: El nombre no existe", false);
        }
    }

    @FXML
    protected void onEliminarClick() {
        int i = buscarIndice(txtNombre.getText().trim());
        if (i != -1) {
            for (int j = i; j < contador - 1; j++) {
                misContactos[j] = misContactos[j + 1];
            }
            misContactos[--contador] = null;
            refrescar();
            onLimpiarClick();
            notificar("Contacto eliminado exitosamente", true);
        }
    }

    @FXML
    protected void onLimpiarClick() {
        txtNombre.clear();
        txtTelefono.clear();
        txtParentesco.clear();
        lblEstado.setText("");
    }

    private int buscarIndice(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (misContactos[i].getNombre().equalsIgnoreCase(nombre)) return i;
        }
        return -1;
    }

    private void refrescar() {
        ArrayList<Contacto> temp = new ArrayList<>();
        for (int i = 0; i < contador; i++) {
            temp.add(misContactos[i]);
        }
        listViewContactos.setItems(FXCollections.observableArrayList(temp));
    }

    private boolean validar(String n, String t, String p) {
        if (n.isEmpty() || t.isEmpty() || p.isEmpty()) {
            notificar("Error: Todos los campos son obligatorios", false);
            return false;
        }
        if (t.length() != 10 || !t.matches("\\d+")) {
            notificar("Error: Teléfono inválido (10 números)", false);
            return false;
        }
        return true;
    }

    private void notificar(String msg, boolean exito) {
        lblEstado.setText(msg);
        lblEstado.setStyle("-fx-text-fill: " + (exito ? "#27ae60" : "#c0392b") + ";");
    }
}