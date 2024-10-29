package org.universalsort.readers;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader implements Reader {
    Path path;
    StringBuffer classFields = new StringBuffer();
    Repository repository;

    ArrayList<String> stringArrayList = new ArrayList<>();
    public FileReader(Repository repository) {
        this.repository = repository;
    }


    @Override
    public List<String> readData(TypesOfData dataType) {

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


    public void readData(Repository repository)  {
        TypesOfData typesOfData = repository.getTypesOfData();
        try {
            if (Files.isReadable(Paths.get(typesOfData + ".dat"))) {
                path = Paths.get(typesOfData + ".dat");
                System.out.println("Файл найден");
                //читаем из файла
                System.out.println(path);
                classFields.append(Files.readString(path));
                ArrayList<Integer> integerArrayList = new ArrayList<>();
                if (typesOfData.equals(TypesOfData.INTEGER)) {
                    //у нас полседовательность чисел
                    System.out.println("находится в файле: " + classFields);
                    System.out.println("записываем в репозиторий");
                    int a = 0;
                    int b;
                    while (a < classFields.length()) {
                        b = classFields.indexOf(";", a);
                        integerArrayList.add(Integer.valueOf(classFields.substring(a, b)));
                        a = b + 1;
                    }
                    repository.saveListInteger(integerArrayList);
                    System.out.println("разбор и запись произведены");
                } else {
//                    String[] lines = classFields.toString().split("\n");
//                    for(String line: lines){
//                        String[] elements = line.split(",");
//                        System.out.println(Arrays.toString(elements));
//                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int index = 0;
                    while (index < classFields.length()) {
                        int a = classFields.indexOf(typesOfData.toString(), index);
                        int b = classFields.indexOf(typesOfData.toString(), index + 1);
                        stringBuilder.append(classFields.substring(a, b));
                        index++;
                    }


                    Pattern pattern = Pattern.compile(typesOfData + ";");
                    Matcher matcher = pattern.matcher(classFields);
                    List<String> list = new ArrayList<String>();
                    for (int i = 0; matcher.find(); i++) {
                        list.add(matcher.group());
                    }


                }
            }


        } catch (IOException e) {
            System.out.println("ошибка чтения из файла");
        }
    }


}
