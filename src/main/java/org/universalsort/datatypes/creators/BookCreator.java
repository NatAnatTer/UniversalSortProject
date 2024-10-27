package org.universalsort.datatypes.creators;

import org.universalsort.model.Book;

public class BookCreator extends Creator{
    @Override
    public Book createType() {
        return new Book();
    }
}
