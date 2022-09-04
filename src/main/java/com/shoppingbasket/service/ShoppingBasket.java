package com.shoppingbasket.service;

import com.shoppingbasket.basketproducts.BasketProduct;
import com.shoppingbasket.invoice.ShoppingBasketInvoiceImpl;

import java.util.List;
import java.util.Map;

public interface ShoppingBasket {
    void addBasketItems(List<String> basketItems);

    String toString();

    ShoppingBasketInvoiceImpl calculateTotalBasketCost();

    void validateBasketItems(List<String> basketItems);

    Map<BasketProduct, Integer> groupBasketItems(List<String> basketItems);

    int totalBasketCost(Map<BasketProduct, Integer> groupedBasketItems);
}
