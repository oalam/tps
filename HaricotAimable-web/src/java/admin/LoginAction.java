/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.opensymphony.xwork2.ActionSupport;
import entity.Customer;
import entity.CustomerOrder;
import java.util.List;
import service.HaricotService;
import service.HaricotServiceLocator;

/**
 *
 * @author adminl
 */
public class LoginAction extends ActionSupport{
    HaricotService service = HaricotServiceLocator.getService();
    
    private List<CustomerOrder> orders;
    private CustomerOrder selectedOrder;
    private int selectedOrderId;
    
    
    
    
    public String displayOrders(){
        orders = service.getAllOrders();
        return SUCCESS;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

    public CustomerOrder getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(CustomerOrder selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public int getSelectedOrderId() {
        return selectedOrderId;
    }

    public void setSelectedOrderId(int selectedOrderId) {
        this.selectedOrderId = selectedOrderId;
    }
}
