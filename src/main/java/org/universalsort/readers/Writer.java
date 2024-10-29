package org.universalsort.readers;

import org.universalsort.data.Repository;

import java.io.IOException;

public interface Writer {
    void writeData(Repository repository) throws IOException;
}
