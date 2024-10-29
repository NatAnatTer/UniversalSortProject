package org.universalsort.model.comparators;

import org.universalsort.model.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAuthor().toLowerCase().compareTo(o2.getAuthor().toLowerCase());
    }
}
