package com.shoppingbasket;

import com.shoppingbasket.invoice.ShoppingBasketInvoiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingBasketImplInvoiceTest {

    @Test
    public void returnZeroWhenTotalIsZero() {
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(0);
        Assert.assertEquals(0, shoppingBasketInvoiceImpl.getTotalPence());
        Assert.assertEquals(0, shoppingBasketInvoiceImpl.getPence());
        Assert.assertEquals(0, shoppingBasketInvoiceImpl.getPound());
    }

    @Test
    public void correctDisplayWithFiftyCents() {
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(50);
        Assert.assertEquals(50, shoppingBasketInvoiceImpl.getTotalPence());
        Assert.assertEquals(50, shoppingBasketInvoiceImpl.getPence());
        Assert.assertEquals(0, shoppingBasketInvoiceImpl.getPound());
        Assert.assertEquals("Total cost of shopping basket: £0.50", shoppingBasketInvoiceImpl.toString());
    }

    @Test
    public void correctDisplayWithFiveDollars() {
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(500);
        Assert.assertEquals(500, shoppingBasketInvoiceImpl.getTotalPence());
        Assert.assertEquals(0, shoppingBasketInvoiceImpl.getPence());
        Assert.assertEquals(5, shoppingBasketInvoiceImpl.getPound());
        Assert.assertEquals("Total cost of shopping basket: £5.00", shoppingBasketInvoiceImpl.toString());
    }

    @Test
    public void correctDisplayWithFiveDollarsFiftyCents() {
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(550);
        Assert.assertEquals(550, shoppingBasketInvoiceImpl.getTotalPence());
        Assert.assertEquals(50, shoppingBasketInvoiceImpl.getPence());
        Assert.assertEquals(5, shoppingBasketInvoiceImpl.getPound());
        Assert.assertEquals("Total cost of shopping basket: £5.50", shoppingBasketInvoiceImpl.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void errorNegativeValue() {
        ShoppingBasketInvoiceImpl shoppingBasketInvoiceImpl = new ShoppingBasketInvoiceImpl(-50);
    }

}
