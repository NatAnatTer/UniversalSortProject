package org.universalsort.service;


import java.util.*;


public class SortService {

    public <E extends Comparable> Collection<E> sort(Collection<E> collection, Comparator<E> comparator) {

        List<E> arrayList = new ArrayList<>(collection);

        for (int s = arrayList.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < arrayList.size(); i++) {
                for (int j = i - s; j >= 0 && comparator.compare(arrayList.get(j), arrayList.get(j + s)) > 0; j -= s) {
                    Collections.swap(arrayList, j, j + s);
                }
            }
        }
        return arrayList;
    }

    public <E extends Comparable> Collection<E> sort(Collection<E> collection) {

        List<E> ArrayList = new ArrayList<>(collection);

        for (int s = ArrayList.size() / 2; s > 0; s /= 2) {
            for (int i = s; i < ArrayList.size(); i++) {
                for (int j = i - s; j >= 0 && ArrayList.get(j).compareTo(ArrayList.get(j + s)) > 0; j -= s) {
                    Collections.swap(ArrayList, j, j + s);
                }
            }
        }
        return ArrayList;
    }

    public static <T extends Number & Comparable<T>> Collection<T> sortEven(Collection<T> collection) {
        List<T> arrayList = new ArrayList<>(collection);
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
                if(index < collection.size()*2)  index += 1;
            }
        }
        return arrayList;
    }
    public static <T> boolean isSortedEven(Collection<T> collectionSorted){
        ArrayList<T> arrEven = new ArrayList<>(collectionSorted);
        int minSize =  Integer.MIN_VALUE;

        for(int i = 0; i < arrEven.size() -1;  i++){
            int element = (int)arrEven.get(i);

            if(element % 2 == 0){
                if (element >= minSize){
                    minSize = element;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
