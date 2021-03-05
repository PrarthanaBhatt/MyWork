package com.prarthana.oopsisfun;

import com.prarthana.oopsisfun.encapsulation.EncapsulationIntro;

public class MyMainClass {
    public static void main(String[] args) {

//        Person p1 = new Person();
//        p1.name = "Prarthana";
//        p1.walk();
//        p1.walk(200);
//        p1.eating();
//
//        Person p2 = new Person(26,"Rohini");
////        p2.name = "Rohini";
//        p2.walk();
//        p2.eating();

//        System.out.println(Person.count);


        Developer developer = new Developer(23,"Prarthana");
        developer.doWork();
        developer.walk(500);

        EncapsulationIntro encapsulationIntro = new EncapsulationIntro();
        encapsulationIntro.doWork();
    }
}

class Developer extends Person{

    public Developer(int age, String name) {
        super(age, name);
    }

    //run-time polymorphism
    void walk(int cnt){
        System.out.println("Developer "+name + " is Walking " + cnt + " steps.");
    }
}
class Person{
    int age;
    protected String name;

    static int count;

//    public Person(){
//        count++;
//        System.out.println("Creating an Object");
//    }

    public Person(int age, String name){
//        this();
        this.name = name;
        this.age = age;
    }
//    public Person(int newAge, String newName){
//        this();
//        name = newName;
//        age = newAge;
//    }

    //compile time polymorphism
     void walk(){
        System.out.println(name + " is Walking..");
    }

     void walk(int cnt){
        System.out.println(name + " is Walking" + cnt + " steps.");
    }

     void eating(){
        System.out.println(name + " is Eating..");
    }

    void doWork(){
        System.out.println(name +" is working..");
    }


}