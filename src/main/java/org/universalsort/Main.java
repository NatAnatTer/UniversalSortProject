package org.universalsort;

import java.util.Scanner;

import org.universalsort.menu.SelectInputMethodMenu;
import org.universalsort.menu.SelectTypeMenu;

public class Main {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SelectTypeMenu selectTypeMenu = new SelectTypeMenu(scanner);
        selectTypeMenu.selectMenuOption();
        scanner.close();

    }
}