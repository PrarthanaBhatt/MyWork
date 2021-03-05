package com.prarthana.oopsisfun.abstraction;

public class AbstractMainClass {
    public static void main(String[] args) {
        BMW bmw = new BMW();
        bmw.start();
    }
}
class BMW extends Car{
    @Override
    void start() {
        System.out.println("BMW started..");
    }
}
class Audi extends Car{
    @Override
    void start() {
        System.out.println("Audi started..");
    }
}
abstract class Car{
    String brand;
    int price;

    abstract void start();
}