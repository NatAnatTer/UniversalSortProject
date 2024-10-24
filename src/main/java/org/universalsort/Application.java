package org.universalsort;

import org.universalsort.datatypes.BookDataType;
import org.universalsort.datatypes.CarDataType;
import org.universalsort.datatypes.DataType;
import org.universalsort.datatypes.RootCropDataType;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.model.UserClass;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private final ReadWriteService readWriteService;
    private final SortService sortService;
    private List<String> objects;
    private List<DataType> dataTypes;
    private List<Book> books;
    private List<Car> cars;
    private List<RootCrop> rootCrops;

    public Application(ReadWriteService readWriteService, SortService sortService){
        this.readWriteService = readWriteService;
        this.sortService = sortService;
        dataTypes = new ArrayList<>();
        books = new ArrayList<>();
        cars = new ArrayList<>();
        rootCrops = new ArrayList<>();
        this.dataTypes.add(new BookDataType());
        this.dataTypes.add(new CarDataType());
        this.dataTypes.add(new RootCropDataType());
    }

    public List<String> getObjects() {
        return objects;
    }

    public void inputData(){
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
//        System.out.println("2. Машины");
//        System.out.println("3. Корнеплод");
//        System.out.println("4. Отмена");
        int dataType = new Scanner(System.in).nextInt();
        DataType dataType1 = dataTypes.get(dataType - 1);
        objects = readWriteService.read(numCmd, dataType1);
        for (String object : objects) {
            String[] fields = object.split(" ");
            if (dataTypes.get(dataType - 1).getCurrentClass() == Book.class) {
                Book book = new Book.Builder().author(fields[0]).name(fields[1]).pagesCount(Integer.parseInt(fields[2])).build();
            } else if (dataTypes.get(dataType - 1).getCurrentClass() == Car.class) {
                Car car = new Car.Builder().power(Double.parseDouble(fields[0])).model(fields[1]).productionYear(Integer.parseInt(fields[2])).build();
            } else if (dataTypes.get(dataType - 1).getCurrentClass() == RootCrop.class) {
                RootCrop rootCrop = new RootCrop.Builder().type(fields[0]).weight(Double.parseDouble(fields[1])).color(fields[2]).build();
            }

        }
    }

    public void sortData(){
        sortService.sort();
    }
}