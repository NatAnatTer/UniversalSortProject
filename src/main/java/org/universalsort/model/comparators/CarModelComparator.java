package org.universalsort.model.comparators;


import org.universalsort.model.Car;

import java.util.Comparator;

public class CarModelComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getModel().toLowerCase().compareTo(o2.getModel().toLowerCase());
    }
}
