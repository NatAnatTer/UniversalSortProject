package org.universalsort.menu;

import org.universalsort.service.Validator;

import java.util.Scanner;

public class StartMenu extends Menu {

    public StartMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void showMenuOption() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Ввод данных из консоли");
        System.out.println("2. Ввод данных из файла");
        System.out.println("3. Заполнение полей классов случайными значениями");
        System.out.println("4. Выйти из приложения");

    }

    @Override
    public void selectMenuOption() {
        boolean keepRunning = true;
//        Scanner scanner = new Scanner(System.in);
//        Application application = new Application(new ReadWriteService(), new SortService());
        while (keepRunning) {
            showMenuOption();
            int command = Validator.returnIntValue(scanner.nextLine(), 4);
            while (command == 0) {
                System.out.println("Неизвестная команда, введите цифру от 1 до 4");
                showMenuOption();
                command = Validator.returnIntValue(scanner.nextLine(), 4);
            }
            switch (command) {
                case 1 :
                    SelectTypeMenu selectTypeMenu = new SelectTypeMenu(scanner);
                    selectTypeMenu.selectMenuOption();
                    break;
                case 2 :
                    new SortingOptionMenu(scanner);
                    break;// создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 3 :
                    new BinarySearchOptionMenu(scanner);
                    break;
                case 4 :
                    keepRunning = false;
                    break;
                default :
                    System.out.printf("Неизвестная команда", command);
            }
        }
        System.out.println("Спасибо за пользование приложением.");
        System.out.println("До свидания.");
    }

}

