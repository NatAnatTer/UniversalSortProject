package org.universalsort.readers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Формирует строковую последовательность случайных чисел
 * метод статический
 * */
public class RandomReader {
    public Integer[] getMasIntRnd(int length)throws NegativeArraySizeException{
        Integer[] integers = new Integer[length];
        for (int i = 0; i < length; i++) {
            integers[i] = (int) (Math.random() * 10);
        }
        return integers;
    }
    public ArrayList<Integer> getRandom(int length)throws NegativeArraySizeException{
        return new ArrayList<>(List.of(getMasIntRnd(length)));
    }

}
