package com.shoppingbasket.specialoffers;

public class ThirtyThreePercent implements Offer {

    @Override
    public int calculateProductPrice(int numOfItems, int itemPrice) {
        return (numOfItems / 3) * itemPrice * 2 + (numOfItems % 3) * itemPrice;
    }
}
