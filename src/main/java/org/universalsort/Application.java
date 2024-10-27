package org.universalsort;

import org.universalsort.datatypes.DataType;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.model.UserClass;
import org.universalsort.service.MapperService;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;

import java.util.*;

public class Application {

    private final ReadWriteService readWriteService;
    private final SortService sortService;
    private final MapperService mapperService;
    private List<? extends UserClass> objects;
    private DataType dataType;
    private List<Book> books;
    private List<Car> cars;
    private List<RootCrop> rootCrops;

    public Application(ReadWriteService readWriteService, SortService sortService){
        this.readWriteService = readWriteService;
        this.sortService = sortService;
        this.mapperService = new MapperService();
    }

    public <E> Collection<E> inputData(){ //TODO передавать тип объекта и способ чтения
        Map<DataType, List<String>> list = readWriteService.read();
        dataType = (DataType) list.keySet().toArray()[0];
        objects = mapperService.map((DataType) list.keySet().toArray()[0], list.get(dataType));
        int a = 1;
        List<E> returnList  = new ArrayList<>();
        //TODO mapper
        return returnList;
    }

    public <E extends Comparable> void sortData(Collection<E> collection) {
        sortService.sort(collection);
    }

    public <E extends Comparable> void sortData(Collection<E> collection, Comparator<E> comparator) {
        sortService.sort(collection, comparator);
    }
}