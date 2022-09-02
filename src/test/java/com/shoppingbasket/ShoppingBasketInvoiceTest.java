package com.shoppingbasket;

import com.shoppingbasket.invoice.ShoppingBasketInvoice;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingBasketInvoiceTest {

    @Test
    public void returnZeroWhenTotalIsZero() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(0);
        Assert.assertEquals(0, shoppingBasketInvoice.getTotalInCents());
        Assert.assertEquals(0, shoppingBasketInvoice.getCents());
        Assert.assertEquals(0, shoppingBasketInvoice.getDollar());
    }

    @Test
    public void correctDisplayWithFiftyCents() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(50);
        Assert.assertEquals(50, shoppingBasketInvoice.getTotalInCents());
        Assert.assertEquals(50, shoppingBasketInvoice.getCents());
        Assert.assertEquals(0, shoppingBasketInvoice.getDollar());
        Assert.assertEquals("Total cost of shopping basket: $0.50", shoppingBasketInvoice.toString());
    }

    @Test
    public void correctDisplayWithFiveDollars() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(500);
        Assert.assertEquals(500, shoppingBasketInvoice.getTotalInCents());
        Assert.assertEquals(0, shoppingBasketInvoice.getCents());
        Assert.assertEquals(5, shoppingBasketInvoice.getDollar());
        Assert.assertEquals("Total cost of shopping basket: $5.00", shoppingBasketInvoice.toString());
    }

    @Test
    public void correctDisplayWithFiveDollarsFiftyCents() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(550);
        Assert.assertEquals(550, shoppingBasketInvoice.getTotalInCents());
        Assert.assertEquals(50, shoppingBasketInvoice.getCents());
        Assert.assertEquals(5, shoppingBasketInvoice.getDollar());
        Assert.assertEquals("Total cost of shopping basket: $5.50", shoppingBasketInvoice.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorNegativeValue() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(-50);
    }

}
