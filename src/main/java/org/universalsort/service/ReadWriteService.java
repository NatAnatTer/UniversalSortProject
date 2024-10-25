package org.universalsort.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Для получения полей класса необходимо:
 * 1 установить класс скоторым работаем
 * 2 осуществить чтение или запись
 * 3 получить поля класса в виде String методом getFields()
 * */
public class ReadWriteService {
    String  path = "";  //путь до файла
    String classFields; //поля класса

    //установка файла - класса с которым работаем и проверка на доступность файла
    public boolean setClassCollection(String classCollection){
        Path p = Paths.get(classCollection + ".dat");
        if (Files.isReadable(p)){
            path = classCollection + ".dat";
            return true;
        }
        return false;
    }
    //Получаем поля класса в виде строки
    public String getClassFields(){
        if (!classFields.isEmpty()){
            return classFields;
        }
        System.out.println("Отсутствует файл или не установлен путь");
        return classFields;
    }
    //Чтение из файла
    public void read(){
        if (!path.isEmpty()){
            try {
                classFields = Files.readString(Path.of(path));
            }catch (IOException e){
                e.printStackTrace();
            }catch (OutOfMemoryError out){
                out.printStackTrace();
            }catch (SecurityException se){
                se.printStackTrace();
            }
        }else {
            System.out.println("Отсутствует файл");
        }
    }
}
