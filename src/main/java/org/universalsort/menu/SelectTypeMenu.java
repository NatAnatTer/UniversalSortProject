package org.universalsort.menu;

import org.universalsort.Application;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;
import org.universalsort.service.Validator;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SelectTypeMenu extends Menu {



    public SelectTypeMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void showMenuOption() {
        System.out.println("Выберите тип создаваемой коллекции: ");
        System.out.println("1. Автомобиль");
        System.out.println("2. Книга");
        System.out.println("3. Корнеплод");
        System.out.println("4. Выйти из приложения");

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
//            SelectInputMethodMenu select = new SelectInputMethodMenu(scanner);
//            if(!menuConfig.containsKey(command)){
//                System.out.println("Неизвестная команда, введите цифру от 1 до 4");
//            } else {
//                menuConfig.get(command).selectMenuOption();
//            }
//            switch (command) {
//                case 1:
//                    select.setObjectType(1);
//                    select.selectMenuOption();
//                    break;
//                case 2:
//                    select.setObjectType(2);
//                    select.selectMenuOption();
//                    break;// создаем диалог с пользователем, в котором спрашиваем 1. Поиск, 2. Сортировка, 3. сохранить коллекцию в файл
//                case 3:
//                    select.setObjectType(3);
//                    select.selectMenuOption();
//                    break;
//                case 4:
//                    keepRunning = false;
//                    break;
//                default:
//                    System.out.printf("Неизвестная команда", command);
//            }


        }
        System.out.println("Спасибо за пользование приложением.");
        System.out.println("До свидания.");
    }
}
