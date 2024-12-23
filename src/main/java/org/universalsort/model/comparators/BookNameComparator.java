package org.universalsort.model.comparators;

import org.universalsort.model.Book;

import java.util.Comparator;

public class BookNameComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}
