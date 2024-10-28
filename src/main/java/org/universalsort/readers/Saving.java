package org.universalsort.readers;

import org.universalsort.model.UserClass;

import java.io.IOException;
import java.util.List;

public interface Saving {
    void writeDataFile(List<UserClass> list) throws IOException;
}
