package org.universalsort.service;


import java.util.*;


public class SortService {


    public <E extends Comparable> Collection<E> sort(Collection<E> collection, Comparator<E> comparator) {

       List<E> coll = new ArrayList<>(collection);

        for(int s = collection.size()/2; s > 0; s /= 2){
            for(int i = s; i < collection.size(); i++){
                for(int j = i - s; j >= 0  && comparator.compare( coll.get(j),coll.get(j + s)) > 0; j -= s){
                    Collections.swap(coll, j, j + s);
                }
            }
            for (E ind: coll) {
                System.out.print(ind + ", ");
            }
            System.out.println();
        }
        return coll;
    }


    public <E extends Comparable> Collection<E> sort(Collection<E> collection) {

        List<E> coll = new ArrayList<>(collection);

        for(int s = collection.size()/2; s > 0; s /= 2){
            for(int i = s; i < collection.size(); i++){
                for(int j = i - s; j >= 0  &&  coll.get(j).compareTo(coll.get(j + s)) > 0; j -= s){
                    Collections.swap(coll, j, j + s);
                }
            }
            for (E ind: coll) {
                System.out.print(ind + ", ");
            }
            System.out.println();
        }
        return coll;
    }
}
