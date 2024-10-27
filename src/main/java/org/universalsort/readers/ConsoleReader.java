package org.universalsort.readers;

import org.universalsort.datatypes.DataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader implements Reader {
    @Override
    public List<String> readData(DataType dataType) {
        List<String> list = new ArrayList<>();
        String author;
        String name;
        int pageCount;
        dataType.printFiledOrder();
        System.out.println("Для прекращения ввода. Введите команду - stop");
        while (true) {
            author = new Scanner(System.in).nextLine();
            if (author.equalsIgnoreCase("stop")) {
                break;
            }
            name = new Scanner(System.in).nextLine();
            if (name.equalsIgnoreCase("stop")) {
                break;
            }
            pageCount = new Scanner(System.in).nextInt();
            StringBuilder sb = new StringBuilder().append(author).append(" ").append(name).append(" ").append(pageCount);
            list.add(sb.toString());
        }
        System.out.println(list);
        return list;
    }
}