package org.universalsort.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Car extends UserClass implements Comparable<Car> {
    private final double power;
    private final String model;
    private final int productionYear;

    @Override
    public int compareTo(Car car) {

        return Integer.compare(this.productionYear, car.productionYear);
    }

    @Override
    public String toString() {
        return "Car;" +
                power + ";" +
                model + ";" +
                productionYear + ";";
    }
}