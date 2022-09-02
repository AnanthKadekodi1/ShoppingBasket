package com.shoppingbasket;
import com.shoppingbasket.invoice.ShoppingBasketInvoice;
import com.shoppingbasket.service.ShoppingBasket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShoppingBasketAppTest {

    public ShoppingBasket shoppingBasketCart;
    @Before
    public void setUp(){
        shoppingBasketCart = new ShoppingBasket();
    }

    @Test
    public void whenNoItemsThenZero() {
        shoppingBasketCart.addBasketItems(Collections.emptyList());
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(0);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreInvalidItem(){
        List<String> fruits = Arrays.asList("Plum");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(0);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreIfEmptyItemPresent(){
        List<String> fruits = Arrays.asList("Orange", " ");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(32);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfTwoApples(){
        List<String> fruits = Arrays.asList("Apple", "Apple");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(12);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfThreeApples(){
        List<String> fruits = Arrays.asList("Apple", "Apple", "Apple");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(24);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfFourApples(){
        List<String> fruits = Arrays.asList("Apple", "Apple", "Apple", "Apple");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(24);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfTwoBanana(){
        List<String> fruits = Arrays.asList("Banana", "Banana");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(102);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfThreeBanana(){
        List<String> fruits = Arrays.asList("Banana", "Banana", "Banana");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(102);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreSpaceBetweenTwoFruits(){
        List<String> fruits = Arrays.asList("Banana", " ", "Banana");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(102);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreCaseSensitiveInput() {
        List<String> fruits = Arrays.asList("Banana", " ", "Banana");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(102);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validateApplePrice() {
        List<String> fruits = Arrays.asList("Apple");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(12);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validateOrangePrice() {
        List<String> fruits = Arrays.asList("Orange");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(32);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validateBananaPrice() {
        List<String> fruits = Arrays.asList("Banana");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(51);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePineApplePrice() {
        List<String> fruits = Arrays.asList("Pineapple");
        shoppingBasketCart.addBasketItems(fruits);
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(95);
        Assert.assertEquals(shoppingBasketInvoice.toString(), shoppingBasketCart.calculateTotalBasketCost().toString());
    }

}
