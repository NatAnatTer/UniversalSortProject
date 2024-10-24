package org.universalsort.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteService {
    String classFields = ""; //поля класса в виде строки
    public String read(String typeClass){

        try {
            Path path = Paths.get(typeClass + ".dat");
            classFields = Files.readString(path);

        }catch (Exception e){
            e.printStackTrace();
        }
        return classFields;
    }
}
