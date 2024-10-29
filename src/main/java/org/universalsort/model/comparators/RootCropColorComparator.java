package org.universalsort.model.comparators;

import org.universalsort.model.Book;
import org.universalsort.model.RootCrop;

import java.util.Comparator;

public class RootCropColorComparator implements Comparator<RootCrop> {
    @Override
    public int compare(RootCrop o1, RootCrop o2) {
        return o1.getColor().toLowerCase().compareTo(o2.getColor().toLowerCase());
    }
}
