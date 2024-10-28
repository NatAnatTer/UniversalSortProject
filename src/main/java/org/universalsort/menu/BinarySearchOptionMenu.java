package org.universalsort.menu;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.service.SearchService;
import org.universalsort.service.SortService;

import java.util.Scanner;
import java.util.function.Predicate;

public class BinarySearchOptionMenu extends Menu {

    Repository repository;
    SearchService searchService;
    SortService sortService;


    public BinarySearchOptionMenu(Scanner scanner, Repository repository, SearchService searchService, SortService sortService) {
        super(scanner);
        this.repository = repository;
        this.searchService = searchService;
        this.sortService = sortService;
    }


    @Override
    public void showMenuOption() {

    }

    @Override
    public void selectMenuOption() {

        TypesOfData typeOfClass = repository.getTypesOfData();
        System.out.println("Введите поле из списка:");
        System.out.println(typeOfClass.getFields().keySet());
        String field = scanner.nextLine();
        if (!typeOfClass.getFields().keySet().contains(field) && typeOfClass != TypesOfData.INTEGER) {
            System.out.println("Данное поле не найдено");
            return;
        }
        System.out.println("Введите поисковой запрос");
        String value = scanner.nextLine();
        if (typeOfClass != TypesOfData.INTEGER) {
            if (typeOfClass.getFields().get(field).test(value)) {
                System.out.println("Введено недопустимое значение");
                return;
            }
        } else {
            if (!value.matches("[0-9]")) {
                System.out.println("Введено недопустимое значение");
                return;
            }
        }
        if(typeOfClass == TypesOfData.INTEGER){
            sortService.sort();
            searchService.binarySearchWithoutComparator(Integer.parseInt(value));
        }else {
            sortService.sort(field);
            searchService.binarySearch(field, value);
            Object result = searchService.binarySearch(field, typeOfClass);
            System.out.println(result);
        }

    }

}
