package org.universalsort;

import org.universalsort.data.RepositoryImpl;
import org.universalsort.datatypes.DataType;
import org.universalsort.menu.*;
import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.model.UserClass;
import org.universalsort.service.MapperService;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;

import java.util.*;

public class Application {

    private SelectTypeMenu menu;
    private final ReadWriteService readWriteService;
    private final SortService sortService;
    private final MapperService mapperService;
    private List<? extends UserClass> objects;
    private DataType dataType;

    private RepositoryImpl repository = new RepositoryImpl();

    public Application(){
        Scanner scanner = new Scanner(System.in);
        this.menu = new SelectTypeMenu(scanner, new BinarySearchOptionMenu(scanner), new SelectInputMethodMenu(scanner, repository), new SortingOptionMenu(scanner), repository);
        this.readWriteService = new ReadWriteService(repository);
        this.sortService = new SortService();
        this.mapperService = new MapperService();
    }

    public void start(){menu. selectMenuOption();}

    public <E> Collection<E> inputData(int objectType, int readType) {
        Map<DataType, List<String>> list = readWriteService.read(objectType, readType);
        dataType = (DataType) list.keySet().toArray()[0];
        objects = mapperService.map((DataType) list.keySet().toArray()[0], list.get(dataType));
        int a = 1;

        //repository save
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