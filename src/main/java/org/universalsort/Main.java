package org.universalsort;

import java.util.Scanner;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

public class Main {

//    private static final String WRONG_COMMAND = "Неизвестный номер команды %s%n";

    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application(new ReadWriteService(), new SortService());
        while (keepRunning) {
            showStartMenu();
            int numCmd = Validator.returnIntValue(scanner.nextLine());
            while (numCmd == 0) {
                System.out.printf(WRONG_COMMAND, "введите цифру от 1 до 4");
                showStartMenu();
                numCmd = Validator.returnIntValue(scanner.nextLine());
            }
            switch (numCmd) {
                case 1 -> application.inputData();
                // case 2 -> application.sortData(); // создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 4 -> keepRunning = false;
                default -> System.out.printf(WRONG_COMMAND, numCmd);
            }
        }
        System.out.println("Спасибо за пользование приложением.");
        System.out.println("До свидания.");
    }

    static void showStartMenu() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Ввод данных");
        System.out.println("2. Сортировка");
        System.out.println("3. Поиск");
        System.out.println("4. Выйти из приложения");
    }
    static void showInputMenu() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Ввод данных из консоли");
        System.out.println("2. Ввод данных из файла");
        System.out.println("3. Заполнение полей классов случайными значениями");
        System.out.println("4. Выйти из приложения");

    }
}