package org.universalsort.menu;

import org.universalsort.data.RepositoryImpl;
import org.universalsort.data.TypesOfData;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.model.comparators.*;
import org.universalsort.service.SearchService;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

public class BinarySearchOptionMenu extends Menu{

    RepositoryImpl repository = new RepositoryImpl();
    SearchService service;

    Map<String, Comparator<Book>> bookFieldComparator = Map.of("author", new BookAuthorComparator(),
            "name", new BookNameComparator(),
            "pagesCount", new BookPagesCountComparator());
    Map<String, Comparator<Car>> carFieldComparator = Map.of("model", new CarModelComparator(),
            "power", new CarPowerComparator(),
            "productionYear", new CarProductionYearComparator());
    Map<String, Comparator<RootCrop>> rootCropFieldComparator = Map.of("color", new RootCropColorComparator(),
            "type", new RootCropTypeComparator(),
            "weight", new RootCropWeightComparator());

    public BinarySearchOptionMenu(Scanner scanner) {
        super(scanner);
    }


    @Override
    public void showMenuOption() {

    }

    @Override
    public void selectMenuOption() {

        TypesOfData typeOfClass = repository.getTypesOfData();
        System.out.println("Введите поле из списка");
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
        Object result = service.binarySearch(null, field, value, typeOfClass);
    }


}
