package com.shoppingbasket.service;

import com.shoppingbasket.basketproducts.BasketProduct;
import com.shoppingbasket.invoice.ShoppingBasketInvoice;

import java.util.List;
import java.util.Map;

public interface ShoppingBasket {
    void addBasketItems(List<String> basketItems);

    String toString();

    ShoppingBasketInvoice calculateTotalBasketCost();

    void validateBasketItems(List<String> basketItems);

    Map<BasketProduct, Integer> groupBasketItems(List<String> basketItems);

    int totalBasketCost(Map<BasketProduct, Integer> groupedBasketItems);
}
