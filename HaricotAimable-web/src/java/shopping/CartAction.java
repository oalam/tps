/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import entity.Product;
import cart.ShoppingBasket;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import service.HaricotService;
import service.HaricotServiceLocator;

/**
 *
 * @author adminl
 */
public class CartAction extends ActionSupport implements SessionAware {

    HaricotService service = HaricotServiceLocator.getService();
    private Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
	this.map = map;
    }
    private int productId = -1;
    private int quantity;

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

	
	Product product = service.getProductById(productId);

	if (product != null) {
	    cart.addProduct(product);
	    cart.updateProductQuantity(product, 1);
	}

	return SUCCESS;

    }

    public String clear() {

	map.put("cart", new ShoppingBasket());

	return SUCCESS;
    }

    public String update() {


	ShoppingBasket cart = (ShoppingBasket) map.get("cart");



	Product product = service.getProductById(productId);

	if (product != null) {
	    cart.addProduct(product);
	    cart.updateProductQuantity(product, quantity);
	}


	return SUCCESS;
    }
}
