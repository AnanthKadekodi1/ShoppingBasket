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

public class ShoppingBasket {
    private final BasketProductRepository BASKET_PRODUCT_REPOSITORY = new BasketProductRepositoryImpl();
    private List<String> basketItems = new ArrayList<>();
    Map<BasketProduct, Integer> groupedBasketItems;
    int totalBasketCost;

    public void addBasketItems(final List<String> basketItems) {
        if (basketItems == null) {
            throw new IllegalArgumentException("Cannot add null basket items.");
        }
        this.basketItems.addAll(basketItems);
    }

    public String toString() {
        return "The Shopping Basket contains the following items - " + basketItems.stream().map(i -> i.toString()).collect(Collectors.joining(","));
    }

    public ShoppingBasketInvoice calculateTotalBasketCost() {
        validateBasketItems(basketItems);

        try {
            groupedBasketItems = groupBasketItems(basketItems);
        } catch (Exception ex) {
            System.out.println("Error grouping basket items - " + ex.getMessage());
        }

        try {
            totalBasketCost = totalBasketCost(groupedBasketItems);
        } catch (Exception ex) {
            System.out.println("Error calculating total basket cost = " + ex.getMessage());
        }

        return new ShoppingBasketInvoice(totalBasketCost);
    }

    private void validateBasketItems(List<String> basketItems){
        if (basketItems == null)
            throw new IllegalArgumentException("Null items present");
    }

    private Map<BasketProduct, Integer> groupBasketItems(List<String> basketItems)
    {
        return basketItems.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(item -> item.length() > 0)
                .peek(basketItem -> {
                    if (!BASKET_PRODUCT_REPOSITORY.isBasketProductValid(basketItem))
                        System.out.println("Invalid item " + basketItem + " found");
                })
                .map(BASKET_PRODUCT_REPOSITORY::getBasketProduct)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingInt(x -> 1)));

    }

    private int totalBasketCost(Map<BasketProduct, Integer> groupedBasketItems){
        return groupedBasketItems.entrySet()
                .stream()
                .map(entry -> entry.getKey().calculateProductPrice(entry.getValue()))
                .mapToInt(Integer::intValue)
                .sum();
    }
}
