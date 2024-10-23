package org.universalsort.service;

import java.util.*;



public class SortService<E> {

    public static void main(String[] args) {


        Random random = new Random(34);
        ArrayList<Integer> collection = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            collection.add(random.nextInt(100));
        }

        for (int i : collection) {
            System.out.print(i + ", ");
        }
        System.out.println();
       // sort(collection);



    }

    @SuppressWarnings("rawtypes")
    public <E extends Comparable> Collection<E> sort(Collection<E> collection) {

       List<E> coll = new ArrayList<>(collection);

        for(int s = collection.size()/2; s > 0; s /= 2){//определяем шаг для прохода путем деления предыдущего шага на 2 TODO опэкспериментировать с делением на 1,247 и вообще с шагом
            for(int i = s; i < collection.size(); i++){
                for(int j = i - s; j >= 0  && coll.get(j).compareTo(coll.get(j + s)) > 0; j -= s){
                    //для кастомных классов compareTo() collection.get(j).compareTo(collection.get(j + s)) < 0

                    Collections.swap(coll, j, j + s);
                }
            }
            for (E ind: collection) {
                System.out.print(ind + ", ");
            }
            System.out.println();
        }
        return coll;
    }


}
