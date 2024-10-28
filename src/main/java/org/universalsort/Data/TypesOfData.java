package org.universalsort.Data;

import org.universalsort.service.Validator;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public enum TypesOfData {
    CAR (1, Map.of("power", value -> !value.isBlank(),
            "model", value -> !value.isBlank(),
    "productionYear", value -> !value.isBlank() && value.matches("[0-9]"))),
    BOOK (2, Map.of("int", value -> !value.isBlank() && value.matches("[0-9]"))),
    ROOT_CROP (3, Map.of("sdfsdf", value -> !String.valueOf(value).isBlank()));

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
