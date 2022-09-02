package com.shoppingbasket.service;

import com.shoppingbasket.basketproducts.BasketProduct;
import com.shoppingbasket.invoice.ShoppingBasketInvoice;
import com.shoppingbasket.repository.BasketProductRepository;
import com.shoppingbasket.repository.BasketProductRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ShoppingBasketService {

    private final BasketProductRepository BASKET_PRODUCT_REPOSITORY = new BasketProductRepositoryImpl();
    private List<String> basketItems = new ArrayList<>();

    public void addBasketItems(final List<String> basketItems) {
        if (basketItems == null) {
            throw new IllegalArgumentException("Cannot add null basket items.");
        }
        this.basketItems.addAll(basketItems);
    }


    //public String toString() {
    //    return "Shopping Basket contains " + basketItems;
    //}

    public ShoppingBasketInvoice pay() {
        if (basketItems == null)
            throw new IllegalArgumentException("Items parameter was null");

        Map<BasketProduct, Integer> basketGrouping = basketItems.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(item -> item.length() > 0)
                .peek(basketItem -> {
                    if (!BASKET_PRODUCT_REPOSITORY.validBasketProduct(basketItem))
                        System.out.println("Invalid item " + basketItem + " found, will be ignored!");
                })
                .map(BASKET_PRODUCT_REPOSITORY::getBasketProduct)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingInt(x -> 1)));

        int totalCost = basketGrouping.entrySet()
                .stream()
                .map(entry -> entry.getKey().calculateProductPrice(entry.getValue()))
                .mapToInt(Integer::intValue)
                .sum();

        return new ShoppingBasketInvoice(totalCost);
    }
}
