package org.universalsort;

import org.universalsort.data.RepositoryImpl;
import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.DataType;
import org.universalsort.menu.*;
import org.universalsort.model.UserClass;
import org.universalsort.service.MapperService;
import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SearchService;
import org.universalsort.service.SortService;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Application {

    private SelectTypeMenu menu;
    private final ReadWriteService readWriteService;
    private final SortService sortService;
    private final MapperService mapperService;
    private final SearchService searchService;

    private RepositoryImpl repository = new RepositoryImpl();

    public Application() {
        Scanner scanner = new Scanner(System.in);
        this.readWriteService = new ReadWriteService(repository);
        this.sortService = new SortService(repository);
        this.mapperService = new MapperService(repository);
        this.searchService = new SearchService(repository);
        this.menu = new SelectTypeMenu(scanner, new BinarySearchOptionMenu(scanner, repository, searchService, sortService),
                new SelectInputMethodMenu(scanner, repository, readWriteService, new SelectObjectMenu(scanner, repository)), new SortingOptionMenu(scanner, repository, sortService),
                repository, sortService, readWriteService);

    }

    public void start() {
        menu.selectMenuOption();
    }

}