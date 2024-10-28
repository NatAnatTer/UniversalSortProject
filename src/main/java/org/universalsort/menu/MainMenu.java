package org.universalsort.menu;

import java.util.Scanner;
//TODO - удалить
public class MainMenu extends Menu {

    BinarySearchOptionMenu binarySearchOptionMenu;


    public MainMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void showMenuOption() {
        System.out.println("Выберите действие: ");
        System.out.println("1. Ввод данных");
        System.out.println("2. Сортировка");
        System.out.println("3. Поиск");
        System.out.println("4. Выйти из приложения");

    }

    @Override
    public void selectMenuOption() {

//        switch (){
//            case 1 -> binarySearchOptionMenu.selectMenuOption();
//        }
    }
}
