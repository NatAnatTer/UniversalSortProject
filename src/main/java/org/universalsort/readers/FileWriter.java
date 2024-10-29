package org.universalsort.readers;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter implements Writer {

    @Override
    public void writeData(Repository repository) {
        try {
            Path path = Path.of(repository.getTypesOfData() + ".dat");
            System.out.println(path);
            if (repository.getTypesOfData().equals(TypesOfData.INTEGER)) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Integer i : repository.getListInteger()) {
                    stringBuffer.append(i).append(";");
                }
                Files.writeString(path, stringBuffer);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                repository.getRepositoryByType(repository.getTypesOfData()).
                        forEach((element) -> stringBuffer.append(element.toString()));
                Files.writeString(path, stringBuffer);
            }
            System.out.println("Данные успешно записаны в файл");
        } catch (IOException e) {
            System.out.println("Ошибка записи");
        }
    }
}
