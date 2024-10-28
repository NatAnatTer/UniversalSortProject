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

//TODO сделать метод, который сравнит каждый тип и выдает результат или передавать в данный метод созданный объект с заполненным поелм при вводе
    public  <T extends Comparable<T>> T binarySearch(T element, String field, String value, TypesOfData type) {
        List<T> sortList = new ArrayList<>(repository.getRepositoryByType(type));
        Comparator<T> comparator = getComparator(field, repository.getTypesOfData());
        int left = 0;

        int right = sortList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            T obj = sortList.get(mid);
            int result =  comparator.compare(obj, element);//obj.compareTo(element);
            if (result == 0) {
                return obj;
            } else if (result > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }

    public <E> Comparator<E> getComparator(String field, TypesOfData typesOfData){

        Map<String, Comparator<Book>> bookFieldComparator = Map.of("author", new BookAuthorComparator(),
                "name", new BookNameComparator(),
                "pagesCount", new BookPagesCountComparator());
        Map<String, Comparator<Car>> carFieldComparator = Map.of("model", new CarModelComparator(),
                "power", new CarPowerComparator(),
                "productionYear", new CarProductionYearComparator());
        Map<String, Comparator<RootCrop>> rootCropFieldComparator = Map.of("color", new RootCropColorComparator(),
                "type", new RootCropTypeComparator(),
                "weight", new RootCropWeightComparator());

      return switch (typesOfData){
            case CAR -> (Comparator<E>) carFieldComparator.get(field);
            case BOOK -> (Comparator<E>) bookFieldComparator.get(field);
            case ROOT_CROP ->  (Comparator<E>) rootCropFieldComparator.get(field);
        };

    }
}
