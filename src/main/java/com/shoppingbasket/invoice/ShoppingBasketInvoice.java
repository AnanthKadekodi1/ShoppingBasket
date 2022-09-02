package com.shoppingbasket.invoice;

import lombok.Getter;

import java.util.Currency;
import java.util.Locale;
@Getter
public class ShoppingBasketInvoice {

    private static final String invoiceCurrencySymbol = "£";
    private int pound;
    private int pence;
    private int totalPence;

    public ShoppingBasketInvoice(int total) {
        if (total < 0)
            throw new IllegalArgumentException("Total cost cannot be negative");
        totalPence = total;
        pound = total / 100;
        pence = total % 100;
    }

    public String toString() {
        return String.format("Total cost of shopping basket: %s%,d.%02d", invoiceCurrencySymbol, pound, pence);
    }
}
