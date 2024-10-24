package org.universalsort.model;

public class Car extends UserClass implements Comparable<Car> {
    private final double power;
    private final String model;
    private final int productionYear;

    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.productionYear = builder.productionYear;
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

    @Override
    public int compareTo(Car car) {
        return this.model.compareTo(car.getModel());
    }

    public static class Builder {
        private  double power;
        private  String model;
        private  int productionYear;

        public Builder power(double power) {
            this.power = power;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder productionYear(int productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Car build() {
            Car car = null;
            if (validateEmployee()) {
                return car = new Car(this);
            } else {
                System.out.println("Sorry! Car objects can't be build without required details");
            }
            return car;
        }

        private boolean validateEmployee() {
            return (power <= 0 && productionYear <= 0 && model != null && !model.trim().isEmpty());
        }
    }
}