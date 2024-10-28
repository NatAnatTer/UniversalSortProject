package org.universalsort.Data;

import org.universalsort.datatypes.DataType;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;

import java.util.ArrayList;
import java.util.Collection;

public class RepositoryImpl implements Repository {
    Collection<Book> listOfBooks = new ArrayList<>();
    Collection<Car> listOfCars = new ArrayList<>();
    Collection<RootCrop> listOfRootCrops = new ArrayList<>();
    Collection<String> listOfInputString = new ArrayList<>();

    DataType dataType = null;

    TypesOfData typesOfData;

    public TypesOfData getTypesOfData() {
        return typesOfData;
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
}
