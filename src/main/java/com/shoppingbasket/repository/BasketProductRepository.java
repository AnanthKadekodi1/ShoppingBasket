package com.shoppingbasket.repository;
import com.shoppingbasket.basketproducts.BasketProduct;

public interface BasketProductRepository {
    BasketProduct getBasketProduct(String item);
    boolean isBasketProductValid(String item);
}
