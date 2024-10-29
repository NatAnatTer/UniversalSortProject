package org.universalsort.datatypes;

import org.universalsort.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDataType extends DataType {

    List<String> fileds;

    public CarDataType() {
        fileds = new ArrayList<>();
        fileds.add("Мощность");
        fileds.add("Модель");
        fileds.add("Год производства");
    }

    @Override
    public void printFiledOrder() {
        StringBuilder stringBuilder = new StringBuilder("Порядок полей для чтения:");
        for (String f : fileds) {
            stringBuilder.append(f + " ");
        }
        System.out.println(stringBuilder.toString().trim());
        System.out.println("Введите значения полей через ;");
    }

    @Override
    public Class<Car> getCurrentClass() {
        return Car.class;
    }

    @Override
    public String getDescription() {
        return "Машина";
    }
}
