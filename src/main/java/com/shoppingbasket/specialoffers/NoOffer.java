package com.shoppingbasket.specialoffers;

public class NoOffer implements Offer {

    @Override
    public int calculateProductPrice(int numOfItems, int itemPrice) {
        return itemPrice * numOfItems;
    }
}
