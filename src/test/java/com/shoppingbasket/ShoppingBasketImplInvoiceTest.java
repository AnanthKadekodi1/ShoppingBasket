package com.shoppingbasket;

import com.shoppingbasket.invoice.ShoppingBasketInvoice;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingBasketImplInvoiceTest {

    @Test
    public void returnZeroWhenTotalIsZero() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(0);
        Assert.assertEquals(0, shoppingBasketInvoice.getTotalPence());
        Assert.assertEquals(0, shoppingBasketInvoice.getPence());
        Assert.assertEquals(0, shoppingBasketInvoice.getPound());
    }

    @Test
    public void correctDisplayWithFiftyCents() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(50);
        Assert.assertEquals(50, shoppingBasketInvoice.getTotalPence());
        Assert.assertEquals(50, shoppingBasketInvoice.getPence());
        Assert.assertEquals(0, shoppingBasketInvoice.getPound());
        Assert.assertEquals("Total cost of shopping basket: £0.50", shoppingBasketInvoice.toString());
    }

    @Test
    public void correctDisplayWithFiveDollars() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(500);
        Assert.assertEquals(500, shoppingBasketInvoice.getTotalPence());
        Assert.assertEquals(0, shoppingBasketInvoice.getPence());
        Assert.assertEquals(5, shoppingBasketInvoice.getPound());
        Assert.assertEquals("Total cost of shopping basket: £5.00", shoppingBasketInvoice.toString());
    }

    @Test
    public void correctDisplayWithFiveDollarsFiftyCents() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(550);
        Assert.assertEquals(550, shoppingBasketInvoice.getTotalPence());
        Assert.assertEquals(50, shoppingBasketInvoice.getPence());
        Assert.assertEquals(5, shoppingBasketInvoice.getPound());
        Assert.assertEquals("Total cost of shopping basket: £5.50", shoppingBasketInvoice.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorNegativeValue() {
        ShoppingBasketInvoice shoppingBasketInvoice = new ShoppingBasketInvoice(-50);
    }

}
