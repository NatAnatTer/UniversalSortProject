package org.universalsort.data;

import org.universalsort.datatypes.DataType;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RepositoryImpl implements Repository {
    Collection<Book> listOfBooks = new ArrayList<>();
    Collection<Car> listOfCars = new ArrayList<>();
    Collection<RootCrop> listOfRootCrops = new ArrayList<>();

    Collection<Integer> listInteger = new ArrayList<>();
    Collection<String> listOfInputString = new ArrayList<>();
    TypesOfData typesOfData;

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
