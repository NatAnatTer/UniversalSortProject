package org.universalsort.service;

import org.universalsort.entity.Car;

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

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(1.7, "Model1", 2003));
        cars.add(new Car(1.9, "Model3", 2010));
        cars.add(new Car(2.7, "Model6", 2011));
        cars.add(new Car(1.4, "Model10", 2023));
        cars.add(new Car(2.6, "Model17", 2015));
        cars.add(new Car(3.7, "Model15", 2000));
        cars.add(new Car(1.5, "Model12", 2024));

        sort(cars);

        Car car1 = new Car(1.7, "Model1", 2003);
        Car car2 = new Car(2.7, "Model1", 2003);

        System.out.println("sorted: " + sort(cars));

    }

    @SuppressWarnings("rawtypes")
    public static <E extends Comparable> Collection<E> sort(Collection<E> collection) {

       List<E> coll = new ArrayList<>(collection);

        for(int s = collection.size()/2; s > 0; s /= 2){
            for(int i = s; i < collection.size(); i++){
                for(int j = i - s; j >= 0  && coll.get(j).compareTo(coll.get(j + s)) > 0; j -= s){
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
