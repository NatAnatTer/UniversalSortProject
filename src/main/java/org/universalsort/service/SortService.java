package org.universalsort.service;


import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;

import java.util.*;


public class SortService {

    Repository repository;


    public SortService(Repository repository) {
        this.repository = repository;
    }

    public <T> Comparator<T> getComparator(String field) {
        TypesOfData thisTypeOfData = repository.getTypesOfData();
        return thisTypeOfData.getComparator(field);
    }

    public <E extends Comparable> void sort(String field) {
        Comparator<E> comparator = getComparator(field);
        TypesOfData dataType = repository.getTypesOfData();
        Collection<E> collection = dataType.getCollection(repository);
        List<E> arrayList = new ArrayList<>(collection);
        System.out.println(arrayList);
        for (int s = arrayList.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < arrayList.size(); i++) {
                for (int j = i - s; j >= 0 && comparator.compare(arrayList.get(j), arrayList.get(j + s)) > 0; j -= s) {
                    Collections.swap(arrayList, j, j + s);
                }
            }
        }
        System.out.println(arrayList);
        dataType.saveSortedCollection(arrayList, repository);
    }

    public <E extends Comparable> void sort() {
        TypesOfData dataType = repository.getTypesOfData();
        Collection<E> collection = dataType.getCollection(repository);
        List<E> arrayList = new ArrayList<>(collection);
        System.out.println(arrayList);
        for (int s = arrayList.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < arrayList.size(); i++) {
                for (int j = i - s; j >= 0 && arrayList.get(j).compareTo(arrayList.get(j + s)) > 0; j -= s) {
                    Collections.swap(arrayList, j, j + s);
                }
            }
        }
        System.out.println(arrayList);
        dataType.saveSortedCollection(arrayList, repository);
    }

    public <T extends Number & Comparable<T>> void sortEven() {
        TypesOfData dataType = repository.getTypesOfData();
        if(dataType != TypesOfData.INTEGER){
            System.out.println("Отсортирую коллекцию только целых чисел"); //TODO experiment of clases

        } else {
            Collection<T> collection = dataType.getCollection(repository);
            List<T> arrayList = new ArrayList<>(collection);
            System.out.println(arrayList);
            int index = 0;
            for (int s = (arrayList.size() + index) / 2; s > 0; s -= 1) {
                for (int i = s; i < arrayList.size(); i++) {
                    for (int j = i - s;
                         j >= 0
                                 && arrayList.get(j).compareTo(arrayList.get(j + s)) > 0
                                 && (Integer) arrayList.get(j) % 2 == 0
                                 && (Integer) arrayList.get(j + s) % 2 == 0;
                         j -= s) {
                        Collections.swap(arrayList, j, j + s);
                    }
                }

                if (s == 1 && !isSortedEven(arrayList)) {

                    s = collection.size();
                    if (index < collection.size() * 2) index += 1;
                }
            }

            System.out.println(arrayList);
            dataType.saveSortedCollection(arrayList, repository);
        }
    }

    public static <T> boolean isSortedEven(Collection<T> collectionSorted) {
        ArrayList<T> arrEven = new ArrayList<>(collectionSorted);
        int minSize = Integer.MIN_VALUE;

        for (int i = 0; i < arrEven.size() - 1; i++) {
            int element = (int) arrEven.get(i);

            if (element % 2 == 0) {
                if (element >= minSize) {
                    minSize = element;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
