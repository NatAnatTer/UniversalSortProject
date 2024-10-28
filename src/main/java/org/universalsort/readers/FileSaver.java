package org.universalsort.readers;

import org.universalsort.model.UserClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSaver implements Saving{

    @Override
    public void writeDataFile (List<UserClass> list) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        Path path = Path.of( list.get(0).getClassName() + ".dat");
        for (UserClass e : list) {
            stringBuffer.append(e.toString());
        }
        Files.writeString(path, stringBuffer.toString());
    }
}
