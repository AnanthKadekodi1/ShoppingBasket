package com.shoppingbasket.basketproducts;
import com.shoppingbasket.specialoffers.Offer;
import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class BasketProductImpl implements BasketProduct {
    private final String name;

    private final int price;
    private final Offer offer;

    @Override
    public int calculateProductPrice(int numOfItems) {
        return offer.calculateProductPrice(numOfItems, getPrice());
    }
}
