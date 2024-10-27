package org.universalsort.mapers;

import org.universalsort.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarMapper implements Mapper {
    @Override
    public List<Car> map(List<String> list) {
        List<Car> cars = new ArrayList<>();
        for (String s : list) {
            String[] fields = s.split(" ");
            Car car = Car.builder().power(Double.parseDouble(fields[0])).model(fields[1]).productionYear(Integer.parseInt(fields[2])).build();
            cars.add(car);
        }
        return cars;
    }
}