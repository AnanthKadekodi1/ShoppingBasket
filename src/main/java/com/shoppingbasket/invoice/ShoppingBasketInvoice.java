package com.shoppingbasket.invoice;

import java.util.Currency;
import java.util.Locale;

public class ShoppingBasketInvoice {

    private static final String invoiceCurrencySymbol = "$";
    private int dollar;
    private int cents;
    private int totalInCents;

    public ShoppingBasketInvoice(int total) {
        if (total < 0)
            throw new IllegalArgumentException("Total cannot be negative");
        totalInCents = total;
        dollar = total / 100;
        cents = total % 100;
    }

    public String toString() {
        return String.format("Cost %s%,d.%02d", invoiceCurrencySymbol, dollar, cents);
    }
}
