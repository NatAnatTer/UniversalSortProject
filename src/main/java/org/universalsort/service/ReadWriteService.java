package org.universalsort.service;

import org.universalsort.datatypes.BookDataType;
import org.universalsort.datatypes.CarDataType;
import org.universalsort.datatypes.RootCropDataType;
import org.universalsort.datatypes.DataType;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.readers.ConsoleReader;
import org.universalsort.readers.FileReader;
import org.universalsort.readers.MokReader;
import org.universalsort.readers.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadWriteService {

    private List<String> objects;
    private List<DataType> dataTypes;
    private List<Book> books;
    private List<Car> cars;
    private List<RootCrop> rootCrops;
    private Reader reader;

    public ReadWriteService() {
        dataTypes = new ArrayList<>();
        books = new ArrayList<>();
        cars = new ArrayList<>();
        rootCrops = new ArrayList<>();
        this.dataTypes.add(new BookDataType());
        this.dataTypes.add(new CarDataType());
        this.dataTypes.add(new RootCropDataType());
    }

    public Map<DataType,List<String>> read(){
        System.out.println("Выберите генерацию объектов в массиве:");
        System.out.println("1. Чтение из консоли");
        System.out.println("2. Чтение из файла");
        System.out.println("3. Генерация произвольеных чисел");
        System.out.println("4. Отмена");
        int numCmd = new Scanner(System.in).nextInt();
        System.out.println("Укажите тип данных:");
        for (int i = 0; i < dataTypes.size(); i++) {
            System.out.println((i + 1) + "." + dataTypes.get(i).getDescription());
        }
        int dataType = new Scanner(System.in).nextInt();
        if (numCmd == 1) {
            DataType dt = dataTypes.get(dataType - 1);
            List<String> lst = new ConsoleReader().readData(dataTypes.get(dataType - 1));
            HashMap<DataType, List<String>> map = new HashMap<>();
            map.put(dt,lst);
            return map;
        } else if (numCmd == 2) {
            DataType dt = dataTypes.get(dataType - 1);
            List<String> lst = new FileReader().readData(dataTypes.get(dataType - 1));
            HashMap<DataType, List<String>> map = new HashMap<>();
            map.put(dt,lst);
            return map;
        } else if (numCmd == 3) {
            DataType dt = dataTypes.get(dataType - 1);
            List<String> lst = new MokReader().readData(dataTypes.get(dataType - 1));
            HashMap<DataType, List<String>> map = new HashMap<>();
            map.put(dt,lst);
            return map;
        } else {
            return new HashMap<>();
        }
    }
}