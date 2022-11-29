package com.company.inheritanceAndPolymorphism;

public class Dog extends Animal implements IPettable{
    public static final int dogToHumanYearMultiplier = 7;

    public Dog(String picture, String name, int age) {
        super(picture, name, age);
    }

    public int getAgeInHumanYears() {
        return this.age * Dog.dogToHumanYearMultiplier;
    }

    public static void outputDog(Dog dog) {
        System.out.println(dog.name + " " + dog.age);
    }

    @Override
    public void makeSound() { //must be implemented since makeSound is inherited from Animal
        System.out.println(this.name + " just woofed!");
    }

    @Override
    public void pet() {
        System.out.println(this.name + " had his belly scratched");
    }
}
