package org.universalsort.model;

public class RootCrop extends UserClass implements Comparable<RootCrop> {
    private final String type;
    private final double weight;
    private final String color;

    public RootCrop(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(RootCrop rootCrop) {
        return this.type.compareTo(rootCrop.getType());
    }

    @Override
    public String toString() {
        return "RootCrop{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            RootCrop rootCrop = null;
            if (validateEmployee()) {
                return rootCrop = new RootCrop(this);
            } else {
                System.out.println("Sorry! RootCrop objects can't be build without required details");
            }
            return rootCrop;
        }

        private boolean validateEmployee() {
            return (weight >= 0 && type != null && !type.trim().isEmpty() && color != null && !color.trim().isEmpty());
        }
    }
}