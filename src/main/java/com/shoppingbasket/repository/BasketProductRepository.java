package com.shoppingbasket.repository;

import com.shoppingbasket.basketproducts.BasketProduct;

import java.util.List;

public interface BasketProductRepository {

    BasketProduct getBasketProduct(String item);

    boolean validBasketProduct(String item);
}
