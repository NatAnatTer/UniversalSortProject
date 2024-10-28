package org.universalsort.mapers;

import org.universalsort.model.Book;
import org.universalsort.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class BookMapper implements Mapper {
    @Override
    public List<Book> map(List<String> list) {
        List<Book> books = new ArrayList<>();
        for (String s : list) {
            String[] fields = Validator.convertString(s);
            Book book = Book.builder()
                    .author(fields[0])
                    .name(fields[1])
                    .pagesCount(Validator.returnIntValue(fields[2]))
                    .build();
            books.add(book);
        }
        return books;
    }
}