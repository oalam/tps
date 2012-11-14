/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import entity.Customer;
import entity.CustomerOrder;
import cart.ShoppingBasket;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import service.HaricotService;
import service.HaricotServiceLocator;

/**
 *
 * @author adminl
 */
public class CheckoutAction extends ActionSupport implements SessionAware {

    HaricotService service = HaricotServiceLocator.getService();
    private Map<String, Object> map;

    @Override
    public void setSession(Map<String, Object> map) {
        this.map = map;
    }
    private Customer customer = new Customer();
    private CustomerOrder order;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerOrder order) {
        this.order = order;
    }

    @Override
    public String execute() throws Exception {
        ShoppingBasket cart = (ShoppingBasket) map.get("cart");


        order = service.placeOrder(customer, cart);
        return SUCCESS;
    }
}
