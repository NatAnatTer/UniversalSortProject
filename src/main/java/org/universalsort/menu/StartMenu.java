package org.universalsort.menu;

import org.universalsort.Application;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

import java.util.Scanner;

public class StartMenu extends Menu{

    public StartMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void showMenuOption() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Ввод данных");
        System.out.println("2. Сортировка");
        System.out.println("3. Поиск");
        System.out.println("4. Выйти из приложения");

    }

    @Override
    public void selectMenuOption() {boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        Application application = new Application(new ReadWriteService(), new SortService());
        while (keepRunning) {
            int numCmd = Validator.returnIntValue(scanner.nextLine());
            while (numCmd == 0) {
                System.out.printf("Введите цифру от 1 до 4");
                showMenuOption();
                numCmd = Validator.returnIntValue(scanner.nextLine());
            }
            switch (numCmd) {
                case 1 -> application.inputData();
                // case 2 -> application.sortData(); // создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 4 -> keepRunning = false;
                default -> System.out.printf("Неизвестная команда", numCmd);
            }
        }
        System.out.println("Спасибо за пользование приложением.");
        System.out.println("До свидания.");
    }

    }


}
