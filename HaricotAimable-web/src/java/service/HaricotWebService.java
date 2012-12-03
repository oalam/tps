/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cart.ShoppingBasket;
import entity.Category;
import entity.Customer;
import entity.CustomerOrder;
import entity.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author adminl
 */
@WebService(serviceName = "HaricotWebService")
@Stateless()
public class HaricotWebService {
    @EJB
    private HaricotService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getAllCategories")
    public List<Category> getAllCategories() {
        return ejbRef.getAllCategories();
    }

    @WebMethod(operationName = "getCategoryById")
    public Category getCategoryById(@WebParam(name = "catId") int catId) {
        return ejbRef.getCategoryById(catId);
    }

    @WebMethod(operationName = "getProductsByCategoryId")
    public List<Product> getProductsByCategoryId(@WebParam(name = "catId") int catId) {
        return ejbRef.getProductsByCategoryId(catId);
    }

    @WebMethod(operationName = "placeOrder")
    public CustomerOrder placeOrder(@WebParam(name = "c") Customer c, @WebParam(name = "cart") ShoppingBasket cart) {
        return ejbRef.placeOrder(c, cart);
    }

    @WebMethod(operationName = "getProductById")
    public Product getProductById(@WebParam(name = "productId") int productId) {
        return ejbRef.getProductById(productId);
    }

    @WebMethod(operationName = "getAllOrders")
    public List<CustomerOrder> getAllOrders() {
        return ejbRef.getAllOrders();
    }
    
}
