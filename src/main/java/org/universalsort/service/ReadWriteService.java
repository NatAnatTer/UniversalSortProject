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

//    private List<String> objects;
//    private List<DataType> dataTypes;
//    private List<Book> books;
//    private List<Car> cars;
//    private List<RootCrop> rootCrops;
//    private Reader reader;

    ConsoleReader consoleReader = new ConsoleReader();
    FileReader fileReader;

    FileWriter fileWriter = new FileWriter();
    RandomReader randomReader = new RandomReader();
    Repository repository;

    public ReadWriteService(Repository repository) {
//        dataTypes = new ArrayList<>();
//        books = new ArrayList<>();
//        cars = new ArrayList<>();
//        rootCrops = new ArrayList<>();
//        this.dataTypes.add(new CarDataType());
//        this.dataTypes.add(new BookDataType());
//        this.dataTypes.add(new RootCropDataType());
       this.repository = repository;

        fileReader = new FileReader(repository);

    }
//
//    public Map<DataType, List<String>> read(int readWhat, int readFrom) {
//
//        int dataType = readWhat;
//        if (readFrom == 1) {
//            DataType dt = dataTypes.get(dataType - 1);
//            List<String> lst = new ConsoleReader().readData(dataTypes.get(dataType - 1));
//            HashMap<DataType, List<String>> map = new HashMap<>();
//            map.put(dt, lst);
//            return map;
//        } else if (readFrom == 2) {
//            try{
//                DataType dt = dataTypes.get(dataType - 1);
//                List<String> lst = new FileReader(repository).readData(dataTypes.get(dataType - 1));
//                HashMap<DataType, List<String>> map = new HashMap<>();
//                map.put(dt, lst);
//                return map;
//            }catch (IOException e){
//                e.printStackTrace();
//                System.out.println("Ошибка чтения");
//            }
//
//        } else if (readFrom == 3) {
//            DataType dt = dataTypes.get(dataType - 1);
//            List<String> lst = new MokReader().readData(dataTypes.get(dataType - 1));
//            HashMap<DataType, List<String>> map = new HashMap<>();
//            map.put(dt, lst);
//            return map;
//        }
//            return new HashMap<>();
//
//    }


//    public void readConsole() {
//        repository.getTypesOfData();
//        //save result to repository
//        //  consoleReader.readData(DataType);
//        // mapper


    public void readConsole() {
        TypesOfData typeOfData = repository.getTypesOfData();
        repository.saveInputCollections(new ConsoleReader().readData(typeOfData));
        switch (typeOfData) {
            case BOOK -> new BookMapper(repository).map();
            case CAR -> new CarMapper(repository).map();
            case ROOT_CROP -> new RootCropMapper(repository).map();
        }
    }


    public void readFromFile()  {
        fileReader.readData(repository);
    }

    public void randomReader() {
        System.out.println("сгенерирована последовательность и выбран тип INTEGER" );
        repository.saveTypesOfData(TypesOfData.INTEGER);
        ArrayList<Integer> arrayList = randomReader.getRandom(15);
        System.out.println(Arrays.asList(arrayList));
        repository.saveListInteger(arrayList);
        System.out.println(Collections.singletonList(repository.getListInteger()));
    }

    public void fileWrite(TypesOfData typesOfData) throws IOException {
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


//
        //вызвать метод записи
    }
}