package org.universalsort.data;

import java.util.Map;
import java.util.function.Predicate;

public enum TypesOfData {
    CAR (1, Map.of("power", value -> !value.isBlank() && value.matches("/^[0-9]+(\\.[0-9]+)?$"),
            "model", value -> !value.isBlank(),
    "productionYear", value -> !value.isBlank() && value.matches("[0-9]"))),
    BOOK (2, Map.of("author", value -> !value.isBlank(),
            "name", value -> !value.isBlank(),
            "pagesCount", value -> !value.isBlank() && value.matches("[0-9]"))),

    ROOT_CROP (3, Map.of("type", value -> !value.isBlank(),
            "weight", value -> !value.isBlank() && value.matches("/^[0-9]+(\\.[0-9]+)?$"),
            "color", value -> !value.isBlank() && value.matches("[0-9]")));

    int indexOfType;
    Map<String, Predicate<String>> fields;

    TypesOfData(int indexOfType, Map<String, Predicate<String>> fields) {
        this.indexOfType = indexOfType;
        this.fields = fields;
    }

    public Map<String, Predicate<String>> getFields() {
        return fields;
    }
}
