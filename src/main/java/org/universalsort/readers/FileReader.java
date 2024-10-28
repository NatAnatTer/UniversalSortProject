package org.universalsort.readers;

import org.universalsort.datatypes.DataType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader implements Reader{
    Path path;
    String classFields;
    @Override
    public List<String> readData(DataType dataType) throws IOException {
        if (Files.isReadable(Paths.get(dataType.getCurrentClass() + ".dat"))){
            path = Paths.get(dataType.getCurrentClass() + ".dat");
            System.out.println("Файл найден");
            //читаем из файла
            classFields = Files.readString(path);

            Pattern pattern = Pattern.compile(dataType.getCurrentClass() + ";");
            Matcher matcher = pattern.matcher(classFields);
            List<String> list = new ArrayList<String>();
            for (int i = 0; matcher.find(); i++) {
                list.add(matcher.group());
            }



        }else {
            System.out.println("Файл отсутствует");
            throw new IllegalArgumentException();
        }


        //преобразуем строку в лист строк
        return new ArrayList<>();
    }
}
