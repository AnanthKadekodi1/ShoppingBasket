package com.shoppingbasket.repository;

import com.shoppingbasket.basketproducts.BasketProduct;
import com.shoppingbasket.basketproducts.BasketProductImpl;
import com.shoppingbasket.specialoffers.FiftyPercent;
import com.shoppingbasket.specialoffers.NoOffer;
import com.shoppingbasket.specialoffers.ThirtyThreePercent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasketProductRepositoryImpl implements BasketProductRepository {

    private static final Map<String, BasketProduct> BASKET_PRODUCTS = populateBasketProducts();

    private static Map<String, BasketProduct> populateBasketProducts() {
        Map<String, BasketProduct> basketProductsMap = new HashMap<>();
        BasketProduct apple = BasketProductImpl.builder().name("APPLE").price(12).offer(new FiftyPercent()).build();
        BasketProduct banana = BasketProductImpl.builder().name("BANANA").price(51).offer(new ThirtyThreePercent()).build();
        BasketProduct orange = BasketProductImpl.builder().name("ORANGE").price(32).offer(new NoOffer()).build();
        BasketProduct pineapple = BasketProductImpl.builder().name("PINEAPPLE").price(95).offer(new NoOffer()).build();

        basketProductsMap.put(apple.getName(), apple);
        basketProductsMap.put(banana.getName(), banana);
        basketProductsMap.put(orange.getName(), orange);
        basketProductsMap.put(pineapple.getName(), pineapple);

        return basketProductsMap;
    }

    private static final List<String> BASKET_PRODUCT_NAMES = BASKET_PRODUCTS.values()
                                                                            .stream()
                                                                            .map(BasketProduct::getName)
                                                                            .collect(Collectors.toList());
    @Override
    public List<String> getBasketProductNames() { return BASKET_PRODUCT_NAMES; }

    @Override
    public BasketProduct getBasketProduct(String item) {
        return BASKET_PRODUCTS.get(item);
    }

    @Override
    public boolean validBasketProduct(String item) {
        return BASKET_PRODUCT_NAMES.contains(item);
    }
}
