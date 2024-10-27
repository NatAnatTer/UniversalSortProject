package org.universalsort.model.comparators;

import org.universalsort.model.Book;

import java.util.Comparator;

public class BookPagesCountComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getPagesCount(), o2.getPagesCount());
    }
}
