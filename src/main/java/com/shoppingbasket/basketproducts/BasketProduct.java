package com.shoppingbasket.basketproducts;
import com.shoppingbasket.specialoffers.Offer;

public interface BasketProduct {

    int calculateProductPrice(int numOfItems);

    int getPrice();

    String getName();

    Offer getOffer();
}
