package org.universalsort.readers;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.DataType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader{
    Path path;
    StringBuffer classFields = new StringBuffer();
    Repository repository;
    ArrayList<String> stringArrayList = new ArrayList<>();
    public FileReader(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<String> readData(DataType dataType)  throws IOException{

        try {
            if (Files.isReadable(Paths.get(repository.getTypesOfData() + ".dat"))) {
                path = Paths.get(repository.getTypesOfData() + ".dat");
                System.out.println("Файл найден");
                //читаем из файла
                System.out.println(path);
                classFields.append(Files.readString(path));
                ArrayList<Integer> integerArrayList = new ArrayList<>();
                int a = 0;
                int b;
                if (repository.getTypesOfData().equals(TypesOfData.INTEGER)) {
                    //у нас полседовательность чисел
                    System.out.println("находится в файле: " + classFields);
                    System.out.println("записываем в репозиторий");
                    while (a < classFields.length()){
                        b = classFields.indexOf(";", a );
                        integerArrayList.add(Integer.valueOf(classFields.substring(a, b)));
                        a = b + 1;
                    }
                    for (Integer integer : integerArrayList) {
                        stringArrayList.add(integer.toString());
                    }

                }else {

                    while (a < classFields.length()) {

                        b = classFields.indexOf(";", a );
                        if (b == -1){
                            b = classFields.length();
                        }
                        stringArrayList.add(classFields.substring(a, b));
                        a = b + 1;
                    }
                    for(String s: stringArrayList){
                        System.out.print(s + " ");
                    }
                    System.out.println("\n");
                }
            }
        }catch (IOException e){
            System.out.println("ошибка чтения из файла");
        }
        return stringArrayList;
    }


    public void readData(Repository repository) {

        try {
            if (Files.isReadable(Paths.get(repository.getTypesOfData() + ".dat"))) {
                path = Paths.get(repository.getTypesOfData() + ".dat");
                System.out.println("Файл найден");
                //читаем из файла
                System.out.println(path);
                classFields.append(Files.readString(path));
                ArrayList<Integer> integerArrayList = new ArrayList<>();
                int a = 0;
                int b ;
                if (repository.getTypesOfData().equals(TypesOfData.INTEGER)) {
                    //у нас полседовательность чисел
                    System.out.println("находится в файле: " + classFields);
                    System.out.println("записываем в репозиторий");
                    while (a < classFields.length()){
                        b = classFields.indexOf(";", a );
                        integerArrayList.add(Integer.valueOf(classFields.substring(a, b)));
                        a = b + 1;
                    }
                    repository.saveListInteger(integerArrayList);
                    System.out.println("разбор и запись произведены");
                }else {
                    ArrayList<String> stringArrayList = new ArrayList<>();
                    while (a < classFields.length()) {

                        b = classFields.indexOf(";", a );
                        if (b == -1){
                            b = classFields.length();
                        }
                        stringArrayList.add(classFields.substring(a, b));
                        a = b + 1;
                    }
                    for(String s: stringArrayList){
                        System.out.print(s + " ");
                    }
                    System.out.println("\n");
                }
            }
        }catch (IOException e){
            System.out.println("ошибка чтения из файла");
        }
    }
}
