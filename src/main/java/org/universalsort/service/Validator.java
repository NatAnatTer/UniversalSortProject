package org.universalsort.service;

public class Validator {

    static final String TEST_CAR = "Car;300.5;Porsche;2021";
    static final String TEST_BOOK = "Book;Robert Martin;Clean Code;1993";
    static final String TEST_ROOTCROP = "Rootcrop;Potato;153.4;brown";
    static final String DELIMITER = ";";
    static final String INCORRECT_DATA = "Некорректный формат входных данных";
    static final String DELIMITER_NOT_CONTAINS = "Строка не содержит ни одного разделителя";

    public static String checkString(String string) {
        if (string == null || string == "") {
            System.out.println("Пустая строка, нечего парсить");
            return null;
        } else {
            int delimeterCount = string.length() - string.replace(DELIMITER, "").length();
            if (delimeterCount > 3) { //проверяем количество разделителей в строке
                System.out.println(INCORRECT_DATA);
                return null;
            } else if (!string.contains(DELIMITER)) { //проверяем наличие разделителя в строке
                System.out.println(DELIMITER_NOT_CONTAINS);
                return null;
            } else {

                try {
                    String str = string.substring(0, string.indexOf(DELIMITER));
                    if (str.equalsIgnoreCase("car") //проверяем наличие ключа в начале строки
                            || str.equalsIgnoreCase("book")
                            || str.equalsIgnoreCase("rootcrop")) {
                        return string.substring(string.indexOf(DELIMITER) + 1);

                    } else {
                        System.out.println(INCORRECT_DATA);
                        return null;
                    }
                } catch (Exception e) {
                    System.out.println(INCORRECT_DATA);
                    return null;
                }
            }

        }
    }

    public static String[] convertString(String string) {
        return string.split(DELIMITER);
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
// тестовые данные
    public static void main(String[] args) {
        System.out.println(checkString(null));
        System.out.println(checkString(TEST_CAR));
        System.out.println(checkString(TEST_BOOK));
        System.out.println(checkString(TEST_ROOTCROP));
        System.out.println(checkString("10000000000000000"));
        System.out.println(checkString("1000;0000;00000;0000"));
        System.out.println(checkString(";;;"));
        System.out.println(checkString(""));
        System.out.println(checkString("BoOk;12;www;zx;new"));
        System.out.println(checkString("BOOk;12;www;zx"));
    }
}

