package org.universalsort.readers;

import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.DataType;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public List<String> readData(TypesOfData dataType) {
        List<String> list = new ArrayList<>();
        System.out.println("Формат строки:");
        StringBuilder sb = new StringBuilder();
        for(String s : dataType.getFields().keySet()) {
            sb.append(s).append(";");
        }
        sb.substring(sb.length() - 1);
        System.out.println(sb.toString());
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