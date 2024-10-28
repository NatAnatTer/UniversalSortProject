package org.universalsort.menu;

import org.universalsort.Application;
import org.universalsort.data.Repository;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        System.out.println("Выберите действие: ");
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
            showMenuOption();
            int command = Validator.returnMenuValue(scanner.nextLine(), 4);//TODO перенести логику в отдельный метод
            while (command == 0) {
                showMenuOption();
                command = Validator.returnMenuValue(scanner.nextLine(), 4);
            }
          //  SelectInputMethodMenu select = new SelectInputMethodMenu(scanner, repository);
//            if(!menuConfig.containsKey(command)){
//                System.out.println("Неизвестная команда, введите цифру от 1 до 4");
//            } else {
//                menuConfig.get(command).selectMenuOption();
//            }
            switch (command) {
                case 1:
                    selectInputMethodMenu.selectMenuOption();
                    break;
                case 2:
                    sortingOptionMenu.selectMenuOption();
//                    select.setObjectType(2);
//                    select.selectMenuOption();
                    break;// создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 3:
                    binarySearchOptionMenu.selectMenuOption();
//                    select.setObjectType(3);
//                    select.selectMenuOption();
                    break;
                case 4:
                    readWriteService.FileWrite();
                    System.out.println("Данные успешно записаны в файл");
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
