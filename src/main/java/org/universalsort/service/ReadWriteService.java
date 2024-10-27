package org.universalsort.service;

import org.universalsort.datatypes.DataType;
import org.universalsort.readers.ConsoleReader;
import org.universalsort.readers.FileReader;
import org.universalsort.readers.MokReader;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteService {

    public List<String> read(int reader, DataType dataType){
        if (reader == 1) {
            return new ConsoleReader().readData(dataType);
        } else if (reader == 2) {
            return new FileReader().readData(dataType);
        } else if (reader == 3) {
            return new MokReader().readData(dataType);
        } else {
            return new ArrayList<>();
        }
    }
}
