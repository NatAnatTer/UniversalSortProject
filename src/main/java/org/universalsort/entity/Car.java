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
        return Double.compare(this.power, o.power);
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                '}' + '\n';
    }

    public double getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}


