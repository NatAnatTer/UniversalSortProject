package org.universalsort.data;

import org.universalsort.datatypes.DataType;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;

import java.util.Collection;

public interface Repository {



    public void saveBookCollections(Collection<Book> book);
    public Collection<Book> getBookCollection();

    public void saveCarCollections(Collection<Car> car);
    public Collection<Car> getCarCollection();

    public void saveRootCropCollections(Collection<RootCrop> rootCrop);
    public Collection<RootCrop> getRootCropCollection();

    public void saveInputCollections(Collection<String> input);
    public Collection<String> getInputCollection();

    public <T> Collection<T> getRepositoryByType(TypesOfData type);

    public TypesOfData getTypesOfData();

    public void saveTypesOfData(TypesOfData typeOfData);

    public Collection<Integer> getListInteger();

    public void saveListInteger(Collection<Integer> list);

}
