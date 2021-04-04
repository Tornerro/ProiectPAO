package Tigari;

import Produs.Produs;

public class Tigari extends Produs {
    private String brand;

    public Tigari(String nume, Integer pret, String brand) {
        super(nume, pret);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Tigari{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
