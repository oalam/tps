package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
public class ShoppingBasket {

    private List<ShoppingBasketItem> items = new ArrayList<>();

    public void addProduct(Product product) {
        System.out.println("ShoppingBasket add = " + product.getName());
        for (ShoppingBasketItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
              /*  int oldQuantity = item.getQuantity();
                item.updateQuantity(++oldQuantity);*/
                return;
            }
        }

        // if not found add a new item
        items.add(new ShoppingBasketItem(product));
    }

    public void updateProductQuantity(Product product, int quantity) {
        ShoppingBasketItem itemToRemove = null;

        for (ShoppingBasketItem item : items) {
            if (item.getProduct().getId() == product.getId()) {

                if (quantity > 0) {
                    item.updateQuantity(quantity);
                    return;
                } else {
                    // set a reference (memory address) 
                    // to the item to be removed
                    itemToRemove = item;
                }
            }
        }

        // remove outside the for loop
        // for security sake
        if(itemToRemove != null){
            items.remove(itemToRemove);
        }
    }

    public double getTotal() {
        double total = 0.0;
        
        for (ShoppingBasketItem item : items) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        
        return total;
    }

    public List<ShoppingBasketItem> getItems() {
        return items;
    }
}