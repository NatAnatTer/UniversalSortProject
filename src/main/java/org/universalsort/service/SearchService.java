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


    public  <T extends Comparable<T>> T binarySearch(String field, T value) {
        TypesOfData type = repository.getTypesOfData();
      //  if(type == TypesOfData.INTEGER){
          //  binarySearchWithoutComparator(Integer.parseInt((String) value));
       // } else {
            List<T> sortList = new ArrayList<>(repository.getRepositoryByType(type));
            T element = getElement(field, value);
            Comparator<T> comparator = type.getComparator(field);
            int left = 0;

            int right = sortList.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                T obj = sortList.get(mid);
                int result = comparator.compare(obj, element);
                if (result == 0) {
                    return obj;
                } else if (result > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
       // }
        return null;
    }

    public  Integer binarySearchWithoutComparator(Integer value) {
        TypesOfData type = repository.getTypesOfData();
        List<Integer> sortList = new ArrayList<>(repository.getRepositoryByType(type));
        Integer element = value;
        System.out.println(value + "=" +element);
        int left = 0;

        int right = sortList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Integer obj = sortList.get(mid);
            System.out.println("MID = " + obj);
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

        switch (typeOfData) {
            case CAR -> {
                String model;
                double power;
                int productionYear;
                if (field.equalsIgnoreCase("model")) model = (String) value;
                else model = null;
                if (field.equalsIgnoreCase("power")) power = (double) value;
                else power = 0.0;
                if (field.equalsIgnoreCase("power")) productionYear = (int) value;
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
                if (field.equalsIgnoreCase("author")) author = (String) value;
                else author = null;
                if (field.equalsIgnoreCase("name")) name = (String) value;
                else name = null;
                if (field.equalsIgnoreCase("pagesCount")) pagesCount = (int) value;
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
                if (field.equalsIgnoreCase("type")) type = (String) value;
                else type = null;
                if (field.equalsIgnoreCase("weight")) weight = (double) value;
                else weight = 0.0;
                if (field.equalsIgnoreCase("color")) color = (String) value;
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
