package org.universalsort.menu;

import org.universalsort.data.Repository;
import org.universalsort.data.RepositoryImpl;
import org.universalsort.data.TypesOfData;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.model.comparators.*;
import org.universalsort.service.SearchService;
import org.universalsort.service.SortService;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class BinarySearchOptionMenu extends Menu{

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
        if(!typeOfClass.getFields().keySet().contains(field)) {
            System.out.println("Данное поле не найдено");
            return;
        }
        System.out.println("Введите поисковой запрос");
        String value = scanner.nextLine();
        if(typeOfClass.getFields().get(field).test(value)){
            System.out.println("Введено недопустимое значение");
            return;
        }

        Object result = searchService.binarySearch(null, field, value, typeOfClass);
    }


}
