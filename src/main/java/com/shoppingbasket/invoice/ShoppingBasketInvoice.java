package com.shoppingbasket.invoice;
import lombok.Getter;
@Getter
public class ShoppingBasketInvoice {

    private static final String invoiceCurrencySymbol = "£";
    private int pound;
    private int pence;
    private int totalPence;

    public ShoppingBasketInvoice(int total) {
        if (total < 0) {
            throw new IllegalArgumentException("Total cost cannot be negative");
        }

        try{
            totalPence = total;
            pound = total / 100;
            pence = total % 100;
        }catch (Exception ex) {
            System.out.println("Error calculating shopping basket invoice values = " + ex.getMessage());
        }
    }

    public String toString() {
        return String.format("Total cost of shopping basket: %s%,d.%02d", invoiceCurrencySymbol, pound, pence);
    }
}
