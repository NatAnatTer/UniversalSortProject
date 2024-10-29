package org.universalsort.model.comparators;

import org.universalsort.model.Book;
import org.universalsort.model.RootCrop;

import java.util.Comparator;

public class RootCropWeightComparator implements Comparator<RootCrop> {
    @Override
    public int compare(RootCrop o1, RootCrop o2) {
        return Double.compare(o1.getWeight(), o2.getWeight());
    }
}
