package org.universalsort.service;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.DataType;
import org.universalsort.mapers.BookMapper;
import org.universalsort.mapers.CarMapper;
import org.universalsort.mapers.RootCropMapper;
import org.universalsort.model.*;
import org.universalsort.readers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReadWriteService {

    FileReader fileReader;
    RandomReader randomReader = new RandomReader();
    Repository repository;

    public ReadWriteService(Repository repository) {
        this.repository = repository;
        fileReader = new FileReader(repository);

    }


    public void readConsole() {
        TypesOfData typeOfData = repository.getTypesOfData();
        repository.saveInputCollections(new ConsoleReader().readData(typeOfData));
        switch (typeOfData) {
            case BOOK -> new BookMapper(repository).map();
            case CAR -> new CarMapper(repository).map();
            case ROOT_CROP -> new RootCropMapper(repository).map();
        }
    }


    public void readFromFile() {
        fileReader.readData(repository);
    }

    public void randomReader() {
        System.out.println("сгенерирована последовательность и выбран тип INTEGER");
        repository.saveTypesOfData(TypesOfData.INTEGER);
        ArrayList<Integer> arrayList = randomReader.getRandom(15);
        System.out.println(Arrays.asList(arrayList));
        repository.saveListInteger(arrayList);
        System.out.println(Collections.singletonList(repository.getListInteger()));
    }

    public void fileWrite(TypesOfData typesOfData) throws IOException {
        Path path = Path.of(typesOfData + ".dat");
        System.out.println(path);
        if (typesOfData.equals(TypesOfData.INTEGER)) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Integer i : repository.getListInteger()) {
                stringBuffer.append(i + ";");
            }
            Files.writeString(path, stringBuffer);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            repository.getRepositoryByType(typesOfData).forEach((element) -> {
                stringBuffer.append(element.toString());
            });
            Files.writeString(path, stringBuffer);
        }


//
        //вызвать метод записи
    }
}