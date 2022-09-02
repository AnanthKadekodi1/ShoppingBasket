package com.shoppingbasket.specialoffers;

public class FiftyPercent implements Offer {

    @Override
    public int calculateProductPrice(int numOfItems, int itemPrice) {
        return (numOfItems / 2) * itemPrice + (numOfItems % 2) * itemPrice;
    }
}
