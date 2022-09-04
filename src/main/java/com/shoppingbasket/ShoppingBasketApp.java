package com.shoppingbasket;

import com.shoppingbasket.service.ShoppingBasketImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
@SpringBootApplication
public class ShoppingBasketApp {

    public static void main(String[] args) {
        //Sample Example input that can be modified.
        String[] shoppingList = {"Apple", "Apple", "Orange", "Apple", "Pineapple", "Banana", "Orange", "Banana"};

        ConfigurableApplicationContext context = SpringApplication.run(ShoppingBasketApp.class, args);
        ShoppingBasketImpl shoppingBasket = context.getBean(ShoppingBasketImpl.class);
        shoppingBasket.addBasketItems(Arrays.asList(shoppingList));

        //Print out items in shopping basket
        System.out.println(shoppingBasket);

        //Print out total basket cost
        System.out.println(shoppingBasket.calculateTotalBasketCost());

        context.close();
    }
}
