/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import com.opensymphony.xwork2.ActionSupport;
import domain.Customer;
import domain.Order;
import domain.OrderManager;
import domain.ShoppingBasket;
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
    private Customer customer;
    private Order order;
    private String address;
    private String paiementInfo;
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaiementInfo() {
        return paiementInfo;
    }

    public void setPaiementInfo(String paiementInfo) {
        this.paiementInfo = paiementInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

        order = orderManager.placeOrder(paiementInfo, address, name, cart);
        return SUCCESS;
    }
}
