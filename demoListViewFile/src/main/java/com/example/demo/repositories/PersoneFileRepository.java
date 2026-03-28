package com.example.demo.repositories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersoneFileRepository {

    private final Path pathFile = Paths.get("data", "persons.csv");

    private void ensureFile() throws IOException {

        //Agregar para validar la  carpeta
        if(Files.notExists(pathFile)){
            Files.createFile(pathFile);
        }
    }

    public List<String> readAllLines() throws IOException {
        return Files.readAllLines(pathFile, StandardCharsets.UTF_8);
    }

    public void addNewLine(String line) throws IOException {
        ensureFile();
        Files.writeString(pathFile, line+System.lineSeparator(),
                StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public void saveFile(List<String> lines ) throws IOException {
        Files.write(pathFile, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
