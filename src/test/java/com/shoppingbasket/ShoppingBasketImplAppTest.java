package com.shoppingbasket;
import com.shoppingbasket.invoice.ShoppingBasketInvoiceImpl;
import com.shoppingbasket.service.ShoppingBasketImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShoppingBasketImplAppTest {

    public ShoppingBasketImpl shoppingBasketImplCart;
    @Before
    public void setUp(){
        shoppingBasketImplCart = new ShoppingBasketImpl();
    }

    @Test
    public void whenNoItemsThenZero() {
        shoppingBasketImplCart.addBasketItems(Collections.emptyList());
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(0);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreInvalidItem(){
        List<String> fruits = Arrays.asList("Plum");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(0);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreIfEmptyItemPresent(){
        List<String> fruits = Arrays.asList("Orange", " ");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(32);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfTwoApples(){
        List<String> fruits = Arrays.asList("Apple", "Apple");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(12);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfThreeApples(){
        List<String> fruits = Arrays.asList("Apple", "Apple", "Apple");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(24);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfFourApples(){
        List<String> fruits = Arrays.asList("Apple", "Apple", "Apple", "Apple");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(24);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfTwoBanana(){
        List<String> fruits = Arrays.asList("Banana", "Banana");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(102);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePriceOfThreeBanana(){
        List<String> fruits = Arrays.asList("Banana", "Banana", "Banana");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(102);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreSpaceBetweenTwoFruits(){
        List<String> fruits = Arrays.asList("Banana", " ", "Banana");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(102);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void ignoreCaseSensitiveInput() {
        List<String> fruits = Arrays.asList("Banana", " ", "Banana");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(102);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validateApplePrice() {
        List<String> fruits = Arrays.asList("Apple");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(12);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validateOrangePrice() {
        List<String> fruits = Arrays.asList("Orange");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(32);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validateBananaPrice() {
        List<String> fruits = Arrays.asList("Banana");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(51);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validatePineApplePrice() {
        List<String> fruits = Arrays.asList("Pineapple");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(95);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

    @Test
    public void validateExampleShoppingBasketScenario() {
        List<String> fruits = Arrays.asList("Apple", "Apple", "Orange", "Apple", "Pineapple", "Banana", "Orange", "Banana");
        shoppingBasketImplCart.addBasketItems(fruits);
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(285);
        Assert.assertEquals(shoppingBasketInvoiceImpl.toString(), shoppingBasketImplCart.calculateTotalBasketCost().toString());
    }

}
