package org.universalsort.service;
/**
 * Формирует строковую последовательность случайных чисел
 * метод статический
 * */
public class StrRndNmb {
    private static final String[] defMass = {"1", "2", "3"};
    public static String[] getStrRndNmb(int length){
        try {
            String[] str = new String[length];
            for (int i = 0; i < length; i++) {
                str[i] = String.valueOf((int) (Math.random() * 10));
            }
            return str;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Размер массива меньше 0 возврат дефолтного массива");
        return defMass;
    }

}
