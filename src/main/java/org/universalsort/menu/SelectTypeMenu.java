package org.universalsort.menu;

import org.universalsort.data.Repository;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

import java.io.IOException;
import java.util.Scanner;

public class SelectTypeMenu extends Menu {

    BinarySearchOptionMenu binarySearchOptionMenu;
    SelectInputMethodMenu selectInputMethodMenu;
    SortingOptionMenu sortingOptionMenu;
    Repository repository;
    ReadWriteService readWriteService;
    SortService sortService;


    public SelectTypeMenu(Scanner scanner, BinarySearchOptionMenu binarySearchOptionMenu,
                          SelectInputMethodMenu selectInputMethodMenu, SortingOptionMenu sortingOptionMenu,
                          Repository repository, SortService sortService, ReadWriteService readWriteService) {
        super(scanner);
        this.binarySearchOptionMenu = binarySearchOptionMenu;
        this.selectInputMethodMenu = selectInputMethodMenu;
        this.sortingOptionMenu = sortingOptionMenu;
        this.repository = repository;
        this.readWriteService = readWriteService;
        this.sortService = sortService;
    }


    @Override
    public void showMenuOption() {
        System.out.println("Выберите действие: для выбранного типа " + repository.getTypesOfData());
        System.out.println("1. Ввод данных");
        System.out.println("2. Сортировка");
        System.out.println("3. Поиск");
        System.out.println("4. Записать в файл");
        System.out.println("5. Выйти из приложения");
    }

    @Override
    public void selectMenuOption() {
        boolean keepRunning = true;
        while (keepRunning) {
            int command = Validator.checkMenuInput(SelectTypeMenu.this, scanner, 5);
            switch (command) {
                case 1:
                    selectInputMethodMenu.selectMenuOption();

                    break;
                case 2:
                    sortingOptionMenu.selectMenuOption();
                    break;
                case 3:
                    binarySearchOptionMenu.selectMenuOption();
                    break;
                case 4:
                    try {
                        readWriteService.fileWrite(repository.getTypesOfData());
                        System.out.println("Данные успешно записаны в файл");
                    } catch (IOException e) {
                        System.out.println("Ошибка записи");
                    }
                    break;
                case 5:
                    keepRunning = false;
                    break;
                default:
                    System.out.printf("Неизвестная команда", command);
            }


        }
        System.out.println("Спасибо за пользование приложением.");
        System.out.println("До свидания.");
    }
}
