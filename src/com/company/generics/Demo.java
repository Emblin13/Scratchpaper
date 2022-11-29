package com.company.generics;

public class Demo {

    //The second parameter, Y, can be specified as any data type that extends Number.
    Pair<Integer, Float> pair = new Pair<>(20, 2f);

    //The code below doesn't work because String does not extend Number
    //Pair<Integer, String> pair2 = new Pair<>(20, "chirpy");
}
