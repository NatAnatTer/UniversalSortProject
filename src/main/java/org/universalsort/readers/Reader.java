package org.universalsort.readers;

import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.DataType;

import java.io.IOException;
import java.util.List;

public interface Reader  {
    List<String> readData(TypesOfData dataType)throws IOException ;
}
