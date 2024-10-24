package org.universalsort;

import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;

import java.util.Collection;
import java.util.Comparator;

public class Application {

    private final ReadWriteService readWriteService;
    private final SortService sortService;

    public Application(ReadWriteService readWriteService, SortService sortService) {
        this.readWriteService = readWriteService;
        this.sortService = sortService;
    }

    public void inputData() {
        readWriteService.read();
    }

    public <E extends Comparable> void sortData(Collection<E> collection) {
        sortService.sort(collection);
    }

    public <E extends Comparable> void sortData(Collection<E> collection, Comparator<E> comparator) {
        sortService.sort(collection, comparator);
    }

}
