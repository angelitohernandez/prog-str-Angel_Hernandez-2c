package com.example.praciticaexamne.Contacto;

public class contacto {
    public String getNombre() {
        return Nombre;
    }

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public contacto(String nombre, String telefeno, String parentesco,int ide) {
        Nombre = nombre;
        Telefeno = telefeno;
        Parentesco = parentesco;
        id = ide;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;

    }

    public String getTelefeno() {
        return Telefeno;
    }

    public void setTelefeno(String telefeno) {
        Telefeno = telefeno;
    }

    public String getParentesco() {
        return Parentesco;
    }

    @Override
    public String toString() {
        return Nombre+"-"+Telefeno+"-"+Parentesco;
    }

    public void setParentesco(String parentesco) {
        Parentesco = parentesco;
    }




    public String Nombre;
    public String Telefeno;
    public String Parentesco;
}
