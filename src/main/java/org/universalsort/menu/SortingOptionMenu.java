package org.universalsort.menu;

import org.universalsort.data.Repository;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

import java.util.Scanner;

public class SortingOptionMenu extends Menu{

    Repository repository;
    SortService sortService;

    public SortingOptionMenu(Scanner scanner, Repository repository, SortService sortService) {
        super(scanner);
        this.repository = repository;
        this.sortService = sortService;
    }

    @Override
    public void showMenuOption() {
        System.out.println("Выберите действие: ");
        System.out.println("1. Обычная сортировка");
        System.out.println("2. Сортировка только четных чисел");
        System.out.println("5. Вернуться назад");
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

            switch (command) {
                case 1:
                    ;
                    break;
                case 2:
                   // sortingOptionMenu.selectMenuOption();
//                    select.setObjectType(2);
//                    select.selectMenuOption();
                    break;// создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
                case 3:
                   // binarySearchOptionMenu.selectMenuOption();
//                    select.setObjectType(3);
//                    select.selectMenuOption();
                    break;
                case 4:
                   // readWriteService.FileWrite();
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
