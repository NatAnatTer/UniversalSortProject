package org.universalsort.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Book extends UserClass implements Comparable<Book> {
    private String author;
    private String name;
    private int pagesCount;

    @Override
    public int compareTo(Book book) {
        return Integer.compare(this.pagesCount, book.pagesCount);
    }

    @Override
    public String toString() {
        return author  + ";" +
               name + ";" +
               pagesCount + "\n";
    }

}