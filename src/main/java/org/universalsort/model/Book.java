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

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", pagesCount=" + pagesCount +
                '}';
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
            boolean pageCounts = pagesCount >= 0;
            boolean nameNull = name != null;
            boolean nameEmpty = !name.trim().isEmpty();
            boolean authorNull = author != null;
            boolean authorEmpty = !author.trim().isEmpty();
            return (pageCounts && nameNull && nameEmpty && authorNull && authorEmpty);
        }
    }
}