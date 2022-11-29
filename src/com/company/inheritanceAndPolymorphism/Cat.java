package com.company.inheritanceAndPolymorphism;

public class Cat extends Animal implements IPettable{

    public Cat(String picture, String name, int age) {
        super(picture, name, age);
    }

    @Override
    public void makeSound() { //must be implemented since makeSound is inherited from Animal
        System.out.println(this.name + " just meowed!");
    }

    @Override
    public void pet() { //must be implemented because of IPettable interface
        System.out.println("Petted " + this.name + " exactly 4 times (1 times too many)");
    }
}
