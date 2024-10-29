package org.universalsort.readers;

import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.DataType;

import java.util.List;

public class FileReader implements Reader{
    @Override
    public List<String> readData(TypesOfData dataType) {
        throw new IllegalArgumentException();
    }
}
