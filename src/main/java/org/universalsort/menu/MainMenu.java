package org.universalsort.menu;

import java.util.Scanner;

public class MainMenu extends Menu {

    BinarySearchOptionMenu binarySearchOptionMenu;


    public MainMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void showMenuOption() {
        System.out.println("Выберите operation: ");
        System.out.println("1. Автомобиль");
        System.out.println("2. Книга");
        System.out.println("3. Корнеплод");
        System.out.println("4. Выйти из приложения");

    }

    @Override
    public void selectMenuOption() {
        switch (){
            case 1 -> binarySearchOptionMenu.selectMenuOption();
        }
    }
}
