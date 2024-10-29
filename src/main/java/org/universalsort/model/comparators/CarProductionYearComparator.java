package org.universalsort.model.comparators;

import org.universalsort.model.Car;

import java.util.Comparator;

public class CarProductionYearComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Double.compare(o1.getProductionYear(), o2.getProductionYear());
    }
}
