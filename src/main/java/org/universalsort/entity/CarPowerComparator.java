package org.universalsort.entity;

import java.util.Comparator;

public class CarPowerComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Double.compare(o1.power, o2.power);
    }
}
