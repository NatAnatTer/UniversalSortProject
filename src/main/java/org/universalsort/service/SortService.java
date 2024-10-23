package org.universalsort.service;

import org.universalsort.entity.Car;
import org.universalsort.entity.CarModelComparator;
import org.universalsort.entity.CarPowerComparator;

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


        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(1.7, "Model3", 2003));
        cars.add(new Car(1.7, "Model1", 2003));
        cars.add(new Car(1.9, "Model13", 2010));
        cars.add(new Car(2.7, "Model16", 2011));
        cars.add(new Car(1.4, "Model10", 2023));
        cars.add(new Car(2.6, "Model17", 2015));
        cars.add(new Car(3.7, "Model15", 2000));
        cars.add(new Car(1.5, "Model12", 2024));




        Comparator<Car> comp = new CarPowerComparator();
        System.out.println("sorted: " + sort(cars, comp));
        Comparator<Car> compMod = new CarModelComparator();
        System.out.println("sorted: " + sort(cars, compMod));

    }

 //   @SuppressWarnings("rawtypes")
    public static <E extends Comparable> Collection<E> sort(Collection<E> collection, Comparator<E> comparator) {

       List<E> coll = new ArrayList<>(collection);

        for(int s = collection.size()/2; s > 0; s /= 2){
            for(int i = s; i < collection.size(); i++){
                for(int j = i - s; j >= 0  && comparator.compare( coll.get(j),coll.get(j + s)) > 0; j -= s){ //coll.get(j).compareTo(coll.get(j + s)) > 0

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
