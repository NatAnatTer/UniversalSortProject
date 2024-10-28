package org.universalsort.readers;

import org.universalsort.datatypes.DataType;
import org.universalsort.model.UserClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterFile {

    public static void writeDataFile (List<UserClass> list, DataType dataType) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        Path path = Path.of( dataType + ".dat");
        for (UserClass e : list) {
            stringBuffer.append(e.toString());
        }
        Files.writeString(path, stringBuffer.toString());
    }
}
