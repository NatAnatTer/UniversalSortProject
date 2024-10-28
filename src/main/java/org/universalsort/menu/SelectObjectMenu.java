package org.universalsort.menu;

import org.universalsort.data.Repository;
import org.universalsort.data.RepositoryImpl;
import org.universalsort.data.TypesOfData;
import org.universalsort.service.Validator;

import java.util.Scanner;

public class SelectObjectMenu extends Menu {
    private TypesOfData typesOfData;

    Repository repository;
    SelectInputMethodMenu selectInputMethodMenu;

    public SelectObjectMenu(Scanner scanner, Repository repository) {
        super(scanner);
        this.repository = repository;
    }




    @Override
    public void showMenuOption() {
        System.out.println("Выберите тип создаваемой коллекции: ");
        System.out.println("1. Автомобиль");
        System.out.println("2. Книга");
        System.out.println("3. Корнеплод");
        System.out.println("4. Вернуться к выбору способа ввода");
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
                case 1: typesOfData = TypesOfData.CAR;
                case 2: typesOfData = TypesOfData.BOOK;
                case 3: typesOfData = TypesOfData.ROOT_CROP;
                case 4:
                    selectInputMethodMenu.selectMenuOption();
                default:
                    System.out.printf("Неизвестная команда", command);
            }
            repository.saveTypesOfData(typesOfData); // данное меню записывает в репозиторий какой был выбарн тип объекта
        }
    }
}
