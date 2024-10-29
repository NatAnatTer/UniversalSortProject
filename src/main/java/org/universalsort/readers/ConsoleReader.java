package org.universalsort.readers;

import org.universalsort.data.TypesOfData;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public List<String> readData(TypesOfData dataType) {
        List<String> list = new ArrayList<>();
        System.out.println("Формат строки:");
        System.out.println(dataType.getListOfFieldName());
        System.out.println("Введите stop для прекращения ввода");
        String inputString;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("stop")) {
                break;
            } else if (Validator.checkString(inputString) != null) {
                list.add(inputString);
            }
        }
        System.out.println(list);
        return list;
    }
}