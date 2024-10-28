package org.universalsort.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Формирует строковую последовательность случайных чисел
 * метод статический
 * */
public class StrRndNmb {

    public static Integer[] getMasIntRnd(int length)throws NegativeArraySizeException{
        Integer[] integers = new Integer[length];
        for (int i = 0; i < length; i++) {
            integers[i] = (int) (Math.random() * 10);
        }
        return integers;
    }
    public static List<Integer> getListIntRnd(int length)throws NegativeArraySizeException{
        return new ArrayList<>(List.of(getMasIntRnd(length)));
    }

}
