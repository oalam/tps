/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import entity.Customer;
import entity.Order;
import entity.OrderManager;
import entity.ShoppingBasket;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author adminl
 */
public class CheckoutAction extends ActionSupport implements SessionAware {

    private Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
    private Customer customer = new Customer();
    private Order order;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String execute() throws Exception {
        ShoppingBasket cart = (ShoppingBasket) map.get("cart");
        OrderManager orderManager = new OrderManager();

	
        order = orderManager.placeOrder(customer, cart);
        return SUCCESS;
    }
}
