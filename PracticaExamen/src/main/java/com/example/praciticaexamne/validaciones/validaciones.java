package com.example.praciticaexamne.validaciones;

public class validaciones {

    public Boolean Validar(String nombre, String telefeno, String parentesco){
        if (nombre == null || nombre.isBlank()){
            System.out.println("El nombre es incorrecto");
            return false;
        }
        if (telefeno == null || telefeno.isBlank() || !telefeno.matches("\\d+") || telefeno.length() < 10){
            System.out.println("El numero telefonico es incorrecto");
            return false;
        }
        if (parentesco == null || parentesco.isBlank() ){
            System.out.println("El parentesco esta mal");
            return false;
        }
        return true;
    }

}
