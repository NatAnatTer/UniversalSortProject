package org.universalsort.readers;

import org.universalsort.datatypes.DataType;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public List<String> readData(DataType dataType) {
        List<String> list = new ArrayList<>();
        String inputString;
        dataType.printFiledOrder();
        System.out.println("Для прекращения ввода введите команду - stop");
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