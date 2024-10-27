package org.universalsort.datatypes;

import org.universalsort.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDataType extends DataType {

    List<String> fileds;

    public BookDataType() {
        fileds = new ArrayList<>();
        fileds.add("Автор");
        fileds.add("Имя");
        fileds.add("Количество страниц");
    }

    @Override
    public void printFiledOrder() {
        StringBuilder stringBuilder = new StringBuilder("Порядок полей для чтения:");
        for (String f : fileds) {
            stringBuilder.append(f + " ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

    @Override
    public Class<Book> getCurrentClass() {
        return Book.class;
    }

    @Override
    public String getDescription() {
        return "Книга";
    }
}