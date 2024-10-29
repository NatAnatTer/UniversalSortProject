package org.universalsort.service;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.model.comparators.*;

import java.util.*;

public class SearchService {
    private final Repository repository;

    public SearchService(Repository repository) {
        this.repository = repository;
    }


    public  <T, E extends Comparable<T>> T binarySearch(String field, E value) { //add
        TypesOfData type = repository.getTypesOfData();
            List<T> sortList = new ArrayList<>(repository.getRepositoryByType(type));
            T element = getElement(field, value);
            Comparator<T> comparator = type.getComparator(field);
           // List<T> result = new ArrayList<>();//new

        //
            int left = 0;

            int right = sortList.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                T obj = sortList.get(mid);
                int result = comparator.compare(obj, element);
                if (result == 0) {
                    System.out.println("Искомое значение найдено");
                    return obj;
                } else if (result > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        System.out.println("Искомое значение не найдено");
        return null;
    }

    public  Integer binarySearchWithoutComparator(Integer value) {
        TypesOfData type = repository.getTypesOfData();
        List<Integer> sortList = new ArrayList<>(repository.getRepositoryByType(type));
        Integer element = value;
        int left = 0;

        int right = sortList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Integer obj = sortList.get(mid);
            int result = obj.compareTo(element);
            if (result == 0) {
                System.out.println("Искомое значение найдено");
                return obj;
            } else if (result > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Искомое значение не найдено");
        return null;
    }

    public <T, E> T getElement(String field, E value) {
        TypesOfData typeOfData = repository.getTypesOfData();
        T object = null;
        String str = "";
        Double d = 0.0;
        Integer i = 0;
        if (str.getClass().equals(value.getClass())) {
            str = (String) value;
        } else if (d.getClass().equals(value.getClass())) {
            d = (Double) value;
        } else if (i.getClass().equals(value.getClass())) {
            i = (Integer) value;
        } else {
            i = 0;
        }


        switch (typeOfData) {
            case CAR -> {
                String model;
                double power;
                int productionYear;
                if (field.equalsIgnoreCase("model")) model = str;
                else model = null;
                if (field.equalsIgnoreCase("power")) power = d;
                else power = 0.0;
                if (field.equalsIgnoreCase("power")) productionYear = i;
                else productionYear = 0;
                object = (T) Car.builder()
                        .model(model)
                        .power(power)
                        .productionYear(productionYear).build();
            }
            case BOOK -> {
                String author;
                String name;
                int pagesCount;
                if (field.equalsIgnoreCase("author")) author = str;
                else author = null;
                if (field.equalsIgnoreCase("name")) name = str;
                else name = null;
                if (field.equalsIgnoreCase("pagesCount")) pagesCount = i;
                else pagesCount = 0;
                object = (T) Book.builder()
                        .author(author)
                        .name(name)
                        .pagesCount(pagesCount).build();
            }
            case ROOT_CROP -> {
                String type;
                double weight;
                String color;
                ;
                if (field.equalsIgnoreCase("type")) type = str;
                else type = null;
                if (field.equalsIgnoreCase("weight")) weight = d;
                else weight = 0.0;
                if (field.equalsIgnoreCase("color")) color = str;
                else color = null;
                object = (T) RootCrop.builder()
                        .type(type)
                        .weight(weight)
                        .color(color).build();
            }
            case INTEGER -> object = (T) value;
        }
        return object;

    }


}
