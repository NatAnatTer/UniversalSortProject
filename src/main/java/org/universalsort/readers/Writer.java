package org.universalsort.readers;

import org.universalsort.datatypes.DataType;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface Writer {
    void writeData(List<Collection> collectionList) throws IOException;
}
