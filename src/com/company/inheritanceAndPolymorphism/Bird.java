package com.company.inheritanceAndPolymorphism;

public class Bird extends Animal implements IPettable, IFly{
    //Can only extend one class, but implement as many as you want


    public Bird(String picture, String name, int age) {
        super(picture, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " just chirped!");
    }

    @Override
    public void fly() { //must be implemented because of IFly interface
        System.out.println(this.name + " is flying!");
    }

    @Override
    public void pet() { //must be implemented because of IPettable interface
        System.out.println("Gently petted " + this.name);
    }
}
