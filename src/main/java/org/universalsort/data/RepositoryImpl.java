package org.universalsort.data;

import org.universalsort.datatypes.DataType;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RepositoryImpl implements Repository {
    //Collection<Book> listOfBooks = new ArrayList<>();
    Collection<Book> listOfBooks = List.of( //TODO mock
            Book.builder().name("W").author("Vasilisa").pagesCount(10).build(),
            Book.builder().name("O").author("Petya").pagesCount(30).build(),
            Book.builder().name("A").author("Vasya").pagesCount(5).build(),
            Book.builder().name("C").author("Misha").pagesCount(50).build());
   // Collection<Car> listOfCars = new ArrayList<>();
   Collection<Car> listOfCars = List.of(
           Car.builder().power(1.2).productionYear(2024).model("A").build(),
           Car.builder().power(1.5).productionYear(2020).model("D").build(),
           Car.builder().power(1.1).productionYear(2018).model("W").build(),
           Car.builder().power(1.8).productionYear(2022).model("C").build(),
           Car.builder().power(2.3).productionYear(2010).model("Q").build(),
           Car.builder().power(1.0).productionYear(2024).model("O").build(),
           Car.builder().power(1.4).productionYear(2024).model("I").build()
   );
    Collection<RootCrop> listOfRootCrops = new ArrayList<>();

 //   Collection<Integer> listInteger = new ArrayList<>();

    Collection<Integer> listInteger = List.of(3, 7, 3, 2, 6, 1, 8, 4, 0,5 ,8 ,9, 6);
    Collection<String> listOfInputString = new ArrayList<>();
    TypesOfData typesOfData = TypesOfData.CAR;

    public void clearTypeOfData() {
        typesOfData = null;
    }

    public void clearListOfBooks() {
        listOfBooks.clear();
    }

    public void clearListOfCars() {
        listOfCars.clear();
    }

    public void clearListOfRootCrop() {
        listOfRootCrops.clear();
    }

    public void clearListOfInteger() {
        listInteger.clear();
    }

    public Collection<Integer> getListInteger() {
        return this.listInteger;
    }

    public void saveListInteger(Collection<Integer> list) {
        this.listInteger = list;
    }

    public TypesOfData getTypesOfData() {
        return typesOfData;
    }

    public void saveTypesOfData(TypesOfData typeOfData) {
        this.typesOfData = typeOfData;
    }

    @Override
    public void saveBookCollections(Collection<Book> book) {
        this.listOfBooks = book;
    }

    @Override
    public Collection<Book> getBookCollection() {
        return listOfBooks;
    }

    @Override
    public void saveCarCollections(Collection<Car> car) {
        this.listOfCars = car;
    }

    @Override
    public Collection<Car> getCarCollection() {
        return listOfCars;
    }

    @Override
    public void saveRootCropCollections(Collection<RootCrop> rootCrop) {
        this.listOfRootCrops = rootCrop;
    }

    @Override
    public Collection<RootCrop> getRootCropCollection() {
        return listOfRootCrops;
    }

    @Override
    public void saveInputCollections(Collection<String> input) {
        this.listOfInputString = input;
    }

    @Override
    public Collection<String> getInputCollection() {
        return listOfInputString;
    }

    @Override
    public <T> Collection<T> getRepositoryByType(TypesOfData type) {
        switch (type.indexOfType) {
            case 1:
                return (Collection<T>) listOfCars;
            case 2:
                return (Collection<T>) listOfBooks;
            case 3:
                return (Collection<T>) listOfRootCrops;
            case 4:
                return (Collection<T>) listInteger;
        }
        return null;
    }
}
