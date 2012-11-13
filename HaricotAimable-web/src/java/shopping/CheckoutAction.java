/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import cart.ShoppingBasket;
import com.opensymphony.xwork2.ActionSupport;
import entity.Customer;
import java.util.Map;
import javax.persistence.criteria.Order;
import org.apache.struts2.interceptor.SessionAware;
import service.HaricotService;
import service.HaricotServiceLocator;

/**
 *
 * @author adminl
 */
public class CheckoutAction extends ActionSupport implements SessionAware {

    private HaricotService service = HaricotServiceLocator.getService();
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
	
        order = service.placeOrder(customer, cart);
	
        return SUCCESS;
    }
}
