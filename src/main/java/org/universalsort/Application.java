package org.universalsort;

import org.universalsort.service.ReadWriteService;
import org.universalsort.service.SortService;

public class Application {

    private final ReadWriteService readWriteService;
    private final SortService sortService;

    public Application(ReadWriteService readWriteService, SortService sortService){
        this.readWriteService = readWriteService;
        this.sortService = sortService;
    }

    public void inputData(){
        readWriteService.read();
    }

    public void sortData(){
        sortService.sort();
    }
}
