package com.prarthana.oopsisfun.abstraction;

public  class InterfaceMainClass implements MyCar,Person{
    public static void main(String[] args) {
        InterfaceMainClass obj = new InterfaceMainClass();
        obj.startCar();
//        obj.walk();
    }


    @Override
    public void startCar() {
        System.out.println("MyCar is starting..");
    }

    @Override
    public void walk() {
        System.out.println("walk...");
    }
}
interface MyCar{
    void startCar();
}
interface Person{
    void walk();
}
