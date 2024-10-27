package org.universalsort.menu;

import java.util.Scanner;

public abstract class Menu {

    protected Scanner scanner;
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    // Метод для отображения меню
    public abstract void showMenuOption();

    // Метод для выбора опции
    public abstract void selectMenuOption();

//TODO получаем коллекцию с объектами, тип объекта и передаем в другие методы
}
