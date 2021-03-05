package com.prarthana.oopsisfun.encapsulation;

public class EncapsulationIntro {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setPrice(31000);
        System.out.println(l1.getPrice());
    }
     public void doWork(){
        System.out.println("working working");
    }

}
class Laptop{
    int ram;
    private int price;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        //check if user is an admin
        boolean isAdmin = true;
        if(!isAdmin){
            System.out.println("You can't set price");
        }else{
            this.price = price;
        }

    }
}
