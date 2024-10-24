package org.universalsort;

import java.util.Scanner;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;

public class Main {

    public static void main(String[] args) {
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application(new ReadWriteService(), new SortService());
        while (keepRunning) {
            showMenu();
            int numCmd = scanner.nextInt();
            switch (numCmd){
                case 1 -> application.inputData();
               // case 2 -> application.sortData(); // создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 4 -> keepRunning = false;
                default -> System.out.printf("Неизвестный номер команды %s%n", numCmd);
            }
        }
        System.out.println("Спасибо за пользование приложением.");
        System.out.println("До свидания.");
    }

    static void showMenu() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Ввод данных");
        System.out.println("2. Сортировка");
        System.out.println("3. Поиск");
        System.out.println("4. Выйти из приложения");
    }
}