package com.company.inheritanceAndPolymorphism;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main (String[] args) {
        Dog bengie = new Dog("bengie.png", "Bengie", 7);
        Cat whiskers = new Cat("whiskers.png", "Whiskers", 4);
        Bird polly = new Bird("polly.png", "Polly", 3);
        bengie.makeSound();
        whiskers.makeSound();

        List<Animal> animals = new ArrayList<>();
        animals.add(bengie);
        animals.add(whiskers);
        animals.get(0).makeSound();

        //Its static type is Animal, but its dynamic type is Dog. This means it only has access to the methods
            //in Animal, however the behavior of those methods will be defined by Dog. So, I can't do
            //jenny.getAgeInHumanYears because that method isn't available to Animal, BUT if I do jenny.makeSound,
            //I get a woof, because that method is available to Animal and is then defined by Dog.
            //The main reason for making the static type be its superclass, is that its behavior can be
            //dynamically defined during runtime.
        Animal jenny = new Dog("jenny.png", "Jenny", 12);
        jenny.makeSound();
        //jenny.getAgeInHumanYears

        //Animal animal2 = new Animal() //Can't make an Animal directly because Animal is abstract

        //Can parameterize a list which only takes classes that implement IFly
        List<IFly> flyingPets = new ArrayList<>();
        flyingPets.add(polly);
        //flyingPets.add(bengie); //Can't add bengie because Dog doesn't implement IFly




    }

}
