package org.universalsort.menu;

import org.universalsort.Application;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

import java.util.Scanner;

public class SelectInputMethodMenu extends Menu {

    public SelectInputMethodMenu(Scanner scanner) {
        super(scanner);
    }

    private int objectType;

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    @Override
    public void showMenuOption() {
        System.out.println("Выберите действие:");
        System.out.println("1. Ввод данных из консоли");
        System.out.println("2. Ввод данных из файла");
        System.out.println("3. Заполнение полей классов случайными значениями");
        System.out.println("4. Вернуться назад");

    }

    @Override
    public void selectMenuOption() {
        boolean keepRunning = true;
        while (keepRunning) {
            showMenuOption();
            int command = Validator.returnMenuValue(scanner.nextLine(), 4);
            while (command == 0) {
                System.out.println("Неизвестная команда, введите цифру от 1 до 4");
                showMenuOption();
                command = Validator.returnMenuValue(scanner.nextLine(), 4);
            }
            switch (command) {
                case 1 :
                    application.inputData(objectType, 1);
                    //TODO сортировка, поиск
                    break;
                case 2 :
                    application.inputData(objectType, 2);
                    break;// создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 3 :

                    application.inputData(objectType, 3);
                    break;
                case 4 :
                    keepRunning = false;
                    break;
                default :
                    System.out.printf("Неизвестная команда", command);
            }
        }

    }

}

