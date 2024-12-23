package org.universalsort.service;

import org.universalsort.menu.Menu;

import java.util.Scanner;

public final class Validator {

    static final String DELIMITER = ";";
    static final String INCORRECT_DATA = "Некорректный формат входных данных";
    static final String DELIMITER_NOT_CONTAINS = "Строка не содержит ни одного разделителя";

    public static String checkString(String string) {
        if (string == null || string == "") {
            System.out.println("Пустая строка, нечего парсить");
            return null;
        } else {
            int delimiterCount = string.length() - string.replace(DELIMITER, "").length();
            if (delimiterCount != 2) { //проверяем количество разделителей в строке
                System.out.println(INCORRECT_DATA);
                return null;
            } else if (!string.contains(DELIMITER)) { //проверяем наличие разделителя в строке
                System.out.println(DELIMITER_NOT_CONTAINS);
                return null;
            } else {
                return string;
            }
        }
    }


    public static String[] convertString(String string) {
        return string.replace("[", "").replace("]", "").split(DELIMITER);
    }


    public static Integer returnIntValue(String string) {
        int i = 0;
        try {
            i = Integer.parseInt(string);
        } catch (NumberFormatException e) {
        }
        return i;
    }


    public static Double returnDoubleValue(String string) {
        Double d = 0.0;
        try {
            d = Double.parseDouble(string);
        } catch (NumberFormatException e) {
        }
        return d;

    }

    public static int checkMenuInput(Menu menu, Scanner scanner, int count) {

        int command = 0;
        int i = 0;
        while (command == 0) {
            menu.showMenuOption();
            command = returnIntValue(scanner.nextLine());
            if (command > 0 && command <= count) {
                i = command;
            } else {
                System.out.printf("Неизвестная команда, введите цифру от 1 до %s%n", count);
                command = 0;
            }
        }
        return i;
    }
}

