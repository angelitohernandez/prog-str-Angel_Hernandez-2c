package com.example.demo.services;

import com.example.demo.repositories.PersoneFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonaService {

    PersoneFileRepository repo = new PersoneFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines  = repo.readAllLines();

        List<String> result = new ArrayList<>();

        for (String line : lines){
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            String edad = parts[2];

            result.add(name+"-"+email+"-"+edad);

        }
        return result;
    }

    public void delete(int index, String name, String email, String edad) throws IOException{
        validate(name, email, Integer.parseInt(edad));
        List<String> listaOriginal =repo.readAllLines();
        List<String> cleanLine = new ArrayList<>();
        for (String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLine.add(line); //Le pasamos la linea que esta corectal
            }
        }
        cleanLine.remove(index);
        repo.saveFile(cleanLine);
    }

    public void update(int index, String name, String email, String edad) throws IOException {
        validate(name, email, Integer.parseInt(edad));
        List<String> listaOriginal =repo.readAllLines();
        List<String> cleanLine = new ArrayList<>();
        for (String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLine.add(line); //Le pasamos la linea que esta buena
            }
        }
        cleanLine.set(index, name+","+ email+","+edad);
        repo.saveFile(cleanLine);
    }

    public void addPerson(String name, String email, String edad) throws IOException {
        validate(name,email,Integer.parseInt(edad));
        repo.addNewLine(name+","+email+","+edad);
    }

    private void validate(String name, String email, int edad){
        if(name==null || name.isBlank() || name.length() <3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em = (email == null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }
        if (edad < 17 || edad < 0 ){
            throw new IllegalArgumentException("La edad no es valida");
        }
    }
}