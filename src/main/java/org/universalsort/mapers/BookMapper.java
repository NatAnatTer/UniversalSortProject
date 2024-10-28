package org.universalsort.mapers;

import org.universalsort.data.Repository;
import org.universalsort.model.Book;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class BookMapper implements Mapper {

    Repository repository;
    public BookMapper(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void map() {
        List<Book> books = new ArrayList<>();
       List<String > list = (List<String>) repository.getInputCollection();
        for (String s : list) {
            String[] fields = Validator.convertString(s);
            Book book = Book.builder()
                    .author(fields[0])
                    .name(fields[1])
                    .pagesCount(Validator.returnIntValue(fields[2]))
                    .build();
            books.add(book);
        }
        repository.saveBookCollections(books);
       // return books;
    }
}