package com.shoppingbasket.repository;

import com.shoppingbasket.basketproducts.BasketProduct;

import java.util.List;

public interface BasketProductRepository {

    List<String> getBasketProductNames();

    BasketProduct getBasketProduct(String item);

    boolean validBasketProduct(String item);
}
