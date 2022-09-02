import com.shoppingbasket.invoice.ShoppingBasketInvoice;
import com.shoppingbasket.service.ShoppingBasketService;

import java.util.Arrays;

public class ShoppingBasketApp {

    public static void main(String[] args) {
        String[] shoppingList = {"Apple", "Apple", "Orange", "Apple", "Pineapple", "Banana", "Orange", "Banana"};
        ShoppingBasketService shoppingCart = new ShoppingBasketService();
        shoppingCart.addBasketItems(Arrays.asList(shoppingList));
        System.out.println(shoppingCart);
        System.out.println(shoppingCart.calculateTotalBasketCost());
    }

}
