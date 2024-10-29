package org.universalsort.service;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;
import org.universalsort.datatypes.BookDataType;
import org.universalsort.datatypes.CarDataType;
import org.universalsort.datatypes.RootCropDataType;
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

    private List<String> objects;
    private List<DataType> dataTypes;
    private List<Book> books;
    private List<Car> cars;
    private List<RootCrop> rootCrops;
    private Reader reader;

    ConsoleReader consoleReader = new ConsoleReader();
    FileReader fileReader = new FileReader();

    // RandomReader randomReader;
    RandomReader randomReader = new RandomReader();
    Repository repository;

    public ReadWriteService(Repository repository) {
        dataTypes = new ArrayList<>();
        books = new ArrayList<>();
        cars = new ArrayList<>();
        rootCrops = new ArrayList<>();
        this.dataTypes.add(new CarDataType());
        this.dataTypes.add(new BookDataType());
        this.dataTypes.add(new RootCropDataType());
        this.repository = repository;

    }

    public Map<DataType, List<String>> read(int readWhat, int readFrom) {
//        int dataType = readWhat;
//        if (readFrom == 1) {
//            DataType dt = dataTypes.get(dataType - 1);
//            List<String> lst = new ConsoleReader().readData(dataTypes.get(dataType - 1));
//            HashMap<DataType, List<String>> map = new HashMap<>();
//            map.put(dt, lst);
//            return map;
//        } else if (readFrom == 2) {
//            DataType dt = dataTypes.get(dataType - 1);
//            List<String> lst = new FileReader().readData(dataTypes.get(dataType - 1));
//            HashMap<DataType, List<String>> map = new HashMap<>();
//            map.put(dt, lst);
//            return map;
//        } else if (readFrom == 3) {
//            DataType dt = dataTypes.get(dataType - 1);
//            List<String> lst = new MokReader().readData(dataTypes.get(dataType - 1));
//            HashMap<DataType, List<String>> map = new HashMap<>();
//            map.put(dt, lst);
//            return map;
//        } else {
//            return new HashMap<>();
//        }
        return null;
    }


    public void readConsole() {
        repository.saveInputCollections(new ConsoleReader().readData(repository.getTypesOfData()));
        switch (repository.getTypesOfData()) {
            case BOOK -> new BookMapper(repository).map();
            case CAR -> new CarMapper(repository).map();
            case ROOT_CROP -> new RootCropMapper(repository).map();
        }
    }

    public void readFromFile() {
        repository.getTypesOfData();
        // fileReader.readData(DataType);
    }

    public void randomReader() {
        System.out.println("сгенерирована последовательность");
        ArrayList<Integer> arrayList = randomReader.getRandom(15);
        System.out.println(Arrays.asList(arrayList));
        repository.saveListInteger(arrayList);
        System.out.println(Collections.singletonList(repository.getListInteger()));
        // randomReader.getRandom();
    }

    public void FileWrite(TypesOfData typesOfData) throws IOException {
        Path path = Path.of( typesOfData + ".dat");
        System.out.println(path);
        if (typesOfData.equals(TypesOfData.INTEGER)){
            StringBuffer stringBuffer = new StringBuffer();
            for (Integer i : repository.getListInteger()){
                stringBuffer.append(i+";");
            }
            Files.writeString(path, stringBuffer);
        }else {
            StringBuffer stringBuffer = new StringBuffer();
            repository.getRepositoryByType(typesOfData).forEach((element) -> {
                stringBuffer.append(element.toString());
            });
            Files.writeString(path, stringBuffer);
        }

//        for (UserClassInterface e : repository.getRepositoryByType(typesOfData)) {
//            stringBuffer.append(e.toString());
//        }
//        repository.getRepositoryByType(typesOfData);
//        for (Object o : col) {
//            o.toString();
//        }
//        Files.writeString(path, .toString());



//
        //вызвать метод записи
    }
}