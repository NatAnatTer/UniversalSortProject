package org.universalsort.readers;

import org.universalsort.data.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Формирует строковую последовательность случайных чисел
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

    public void getRandom(Repository repository){
        System.out.println("сгенерирована последовательность");
        ArrayList<Integer> arrayList = getRandom(15);
        System.out.println(Collections.singletonList(arrayList));
        repository.saveListInteger(arrayList);
        System.out.println(Collections.singletonList(repository.getListInteger()));
    }

}
