/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import dao.MockProductDao;
import dao.ProductDao;
import domain.Product;
import domain.ShoppingBasket;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author adminl
 */
public class CartAction extends ActionSupport implements SessionAware {

    private Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
    private int productId = -1;
    private int selectedCat;
    private int quantity;

    public int getSelectedCat() {
        return selectedCat;
    }

    public void setSelectedCat(int selectedCat) {
        this.selectedCat = selectedCat;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String execute() {

        ShoppingBasket cart = (ShoppingBasket) map.get("cart");

        if (cart == null) {
            cart = new ShoppingBasket();
            map.put("cart", cart);
        }

        ProductDao productDao = new MockProductDao();
        Product product = productDao.getProductById(productId);

        if (product != null) {
            cart.addProduct(product);
            cart.updateProductQuantity(product, 1);
        }

        return SUCCESS;

    }

    public String exit() {


        map.clear();


        return SUCCESS;
    }

    public String update() {


        ShoppingBasket cart = (ShoppingBasket) map.get("cart");


        ProductDao productDao = new MockProductDao();
        Product product = productDao.getProductById(productId);

        if (product != null) {
            cart.addProduct(product);
            cart.updateProductQuantity(product, quantity);
        }


        return SUCCESS;
    }
}
