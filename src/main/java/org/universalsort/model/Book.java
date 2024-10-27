package org.universalsort.model;

public class Book extends UserClass implements Comparable<Book> {
    private String author;
    private String name;
    private int pagesCount;

    private Book(Builder builder) {
        this.author = builder.author;
        this.name = builder.name;
        this.pagesCount = builder.pagesCount;
    }

    public Book() {

    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    @Override
    public int compareTo(Book book) {
        return this.author.compareTo(book.author);
    }

    public static class Builder {
        private String author;
        private String name;
        private int pagesCount;

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder pagesCount(int pagesCount) {
            this.pagesCount = pagesCount;
            return this;
        }

        public Book build() {
            Book book = null;
            if (validateEmployee()) {
                return book = new Book(this);
            } else {
                System.out.println("Sorry! Book objects can't be build without required details");
            }
            return book;
        }

        private boolean validateEmployee() {
            return (pagesCount <= 0 && name != null && name.trim().isEmpty() && author != null && !author.trim().isEmpty());
        }
    }
}