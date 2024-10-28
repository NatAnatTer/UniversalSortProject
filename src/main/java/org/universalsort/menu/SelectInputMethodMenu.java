package org.universalsort.menu;

import org.universalsort.Application;
import org.universalsort.data.Repository;
import org.universalsort.data.RepositoryImpl;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

import java.util.Scanner;

public class SelectInputMethodMenu extends Menu {


    private int objectType;

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }


    Repository repository;
    ReadWriteService readWriteService;
    SelectObjectMenu selectObjectMenu;


    public SelectInputMethodMenu(Scanner scanner, Repository repository) {
        super(scanner);
        this.repository = repository;
        this.readWriteService = new ReadWriteService(repository);
        this.selectObjectMenu = new SelectObjectMenu(scanner, repository);
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
                case 1:
                    selectObjectMenu.selectMenuOption();
                    readWriteService.readConsole();
                    //  application.inputData(objectType, 1);
                    //TODO сортировка, поиск
                    return;
                case 2:
                    selectObjectMenu.selectMenuOption();
                    readWriteService.readFromFile();
                    //application.inputData(objectType, 2);
                    return;// создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 3:
                    readWriteService.randomReader();
                    //application.inputData(objectType, 3);
                    return;
                case 4:
                    return;
                default:
                    System.out.printf("Неизвестная команда", command);
            }
        }

    }

}

