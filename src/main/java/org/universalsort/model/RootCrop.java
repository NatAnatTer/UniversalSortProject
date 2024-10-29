package org.universalsort.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RootCrop extends UserClass implements Comparable<RootCrop> {
    private final String type;
    private final double weight;
    private final String color;

    @Override
    public int compareTo(RootCrop rootCrop) {

        return  Double.compare(this.weight, rootCrop.weight);
    }

    @Override
    public String toString() {
        return type + ";" +
               weight + ";" +
               color;
    }

}