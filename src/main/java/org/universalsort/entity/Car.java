package org.universalsort.entity;

public class Car implements Comparable<Car>{
    double power;
    String model;
    int productionYear;

    public Car(double power, String model, int productionYear) {
        this.power = power;
        this.model = model;
        this.productionYear = productionYear;
    }

    @Override
    public int compareTo(Car o) {
       /*
        if(this.power > o.power){
            return 1;
        } else if (this.power < o.power) {
            return -1;
        } else return  0;
*/
        return Double.compare(this.power, o.power);

    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
              //  ", model='" + model + '\'' +
              //  ", productionYear=" + productionYear +
                '}';
    }
}
