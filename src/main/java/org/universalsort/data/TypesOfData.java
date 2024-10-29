package org.universalsort.data;

import org.universalsort.model.Book;
import org.universalsort.model.Car;
import org.universalsort.model.RootCrop;
import org.universalsort.model.comparators.*;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;

public enum TypesOfData {
    CAR (1, Map.of("power", value -> !value.isBlank() && value.matches("[0-9]+(\\.[0-9]+)?$"),
            "model", value -> !value.isBlank(),
    "productionYear", value -> !value.isBlank() && value.matches("[0-9]+"))),
    BOOK (2, Map.of("author", value -> !value.isBlank(),
            "name", value -> !value.isBlank(),
            "pagesCount", value -> !value.isBlank() && value.matches("[0-9]+"))),

    ROOT_CROP (3, Map.of("type", value -> !value.isBlank(),
            "weight", value -> !value.isBlank() && value.matches("[0-9]+(\\.[0-9]+)?$"),
            "color", value -> !value.isBlank())),
    INTEGER(4,Map.of());

    public static final String INT_REGEXP = "[0-9]+";
    public static final String DOUBLE_REGEXP = "[0-9]+(\\.[0-9]+)?$";

    int indexOfType;
    Map<String, Predicate<String>> fields;

    TypesOfData(int indexOfType, Map<String, Predicate<String>> fields) {
        this.indexOfType = indexOfType;
        this.fields = fields;
    }

    public Map<String, Predicate<String>> getFields() {
        return fields;
    }


    public <E> Comparator<E> getComparator(String field){

        Map<String, Comparator<Book>> bookFieldComparator = Map.of("author", new BookAuthorComparator(),
                "name", new BookNameComparator(),
                "pagesCount", new BookPagesCountComparator());
        Map<String, Comparator<Car>> carFieldComparator = Map.of("model", new CarModelComparator(),
                "power", new CarPowerComparator(),
                "productionYear", new CarProductionYearComparator());
        Map<String, Comparator<RootCrop>> rootCropFieldComparator = Map.of("color", new RootCropColorComparator(),
                "type", new RootCropTypeComparator(),
                "weight", new RootCropWeightComparator());

        return switch (this){
            case CAR -> (Comparator<E>) carFieldComparator.get(field);
            case BOOK -> (Comparator<E>) bookFieldComparator.get(field);
            case ROOT_CROP ->  (Comparator<E>) rootCropFieldComparator.get(field);
            case INTEGER -> null;
        };

    }

    public <V> Collection<V> getCollection(Repository repository) {

        return switch (this) {
            case BOOK -> (Collection<V>) repository.getBookCollection();
            case CAR -> (Collection<V>) repository.getCarCollection();
            case ROOT_CROP -> (Collection<V>) repository.getRootCropCollection();
            case INTEGER -> (Collection<V>) repository.getListInteger();
        };
    }

    public <V> void saveSortedCollection(Collection<V> collection, Repository repository) {
       // TypesOfData thisTypeOfData = repository.getTypesOfData();
        switch (this) {
            case BOOK -> repository.saveBookCollections((Collection<Book>) collection);
            case CAR -> repository.saveCarCollections((Collection<Car>) collection);
            case ROOT_CROP -> repository.saveRootCropCollections((Collection<RootCrop>) collection);
            case INTEGER -> repository.saveListInteger((Collection<Integer>) collection);
        }
        ;
    }
}
