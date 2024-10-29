package org.universalsort.menu;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.DataType;
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
        System.out.println("1. Обычная сортировка"); //TODO добавить проверку что есть тип данных и коллекция чтобы не падала программа TypesOfData.getCollection(org.universalsort.data.Repository)" because "dataType" is null
        System.out.println("2. Сортировка только четных чисел");
        System.out.println("3. Вернуться назад");
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
                    if(repository.getTypesOfData() != null) {
                        sortService.sort();
                    } else {
                        System.out.println("Необходимо сначала ввести данные");
                        return;
                    }
                    break;
                case 2:
                    if(repository.getTypesOfData() != null) {
                        sortService.sortEven();
                    } else {
                        System.out.println("Необходимо сначала ввести данные");
                        return;
                    }

                    break;
                case 3:
                    return;
                default:
                    System.out.printf("Неизвестная команда", command);
            }
        }
    }
}
