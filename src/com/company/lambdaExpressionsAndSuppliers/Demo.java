package com.company.lambdaExpressionsAndSuppliers;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Demo {
    public static void main(String[] args) {
        //parameter -> expression

        //In this example, the Supplier allows me to get the value of the time when I need it, rather than
            //at runtime.
        LocalDateTime dateTime = LocalDateTime.now();
        Supplier<LocalDateTime> dateSupplier = () -> LocalDateTime.now();

        System.out.println(dateTime);
        System.out.println(dateSupplier.get());

        System.out.println("Waiting for 3 seconds!");
        //Sleep for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(dateTime);
        System.out.println(dateSupplier.get());
    }
}
