package org.universalsort.mapers;

import org.universalsort.model.Car;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;

//public class CarMapper implements Mapper {
//    @Override
//    public List<Car> map(List<String> list) {
//        List<Car> cars = new ArrayList<>();
//        for (String s : list) {
//            String[] fields = Validator.convertString(s);
//            Car car = Car.builder()
//                    .power(Validator.returnDoubleValue(fields[0]))
//                    .model(fields[1])
//                    .productionYear(Validator.returnIntValue(fields[2]))
//                    .build();
//            cars.add(car);
//        }
//        return cars;
//    }
//}