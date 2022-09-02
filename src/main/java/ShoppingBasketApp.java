import com.shoppingbasket.service.ShoppingBasketService;
import java.util.Arrays;

public class ShoppingBasketApp {

    public static void main(String[] args) {
        String[] shoppingList = {"Apple", "Apple", "Orange", "Apple", "Pineapple", "Banana", "Orange", "Banana"};
        ShoppingBasketService shoppingCart = new ShoppingBasketService();
        shoppingCart.addBasketItems(Arrays.asList(shoppingList));
        //Print out items in shopping basket
        System.out.println(shoppingCart);
        //Print out total basket cost
        System.out.println(shoppingCart.calculateTotalBasketCost());
    }

}
