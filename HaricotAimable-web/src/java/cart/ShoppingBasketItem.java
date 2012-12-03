package cart;

import entity.Product;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
@XmlRootElement
public class ShoppingBasketItem {

    private int quantity = 0;
    private Product product = null;

    public ShoppingBasketItem() {
    }
    

    public ShoppingBasketItem(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}