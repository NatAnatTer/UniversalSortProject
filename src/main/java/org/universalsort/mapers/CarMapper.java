package org.universalsort.mapers;

import org.universalsort.data.Repository;
import org.universalsort.model.Car;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class CarMapper implements Mapper {

    Repository repository;
    public CarMapper(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void map() {
        List<Car> cars = new ArrayList<>();
        List<String > list = (List<String>) repository.getInputCollection();
        for (String s : list) {
            String[] fields = Validator.convertString(s);
            Car car = Car.builder()
                    .power(Validator.returnDoubleValue(fields[0]))
                    .model(fields[1])
                    .productionYear(Validator.returnIntValue(fields[2]))
                    .build();
            cars.add(car);
        }
        repository.saveCarCollections(cars);
    }
}