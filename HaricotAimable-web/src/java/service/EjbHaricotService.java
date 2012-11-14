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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import session.CategoryFacade;
import session.CustomerOrderFacade;
import session.ProductFacade;

/**
 *
 * @author adminl
 */
public class EjbHaricotService implements HaricotService {
    CustomerOrderFacade customerOrderFacade = lookupCustomerOrderFacadeBean();


    ProductFacade productFacade = lookupProductFacadeBean();
    CategoryFacade categoryFacade = lookupCategoryFacadeBean();

    @Override
    public List<Category> getAllCategories() {

        return categoryFacade.getAllCategories();
    }

    @Override
    public Category getCategoryById(int catId) {
        return categoryFacade.getCategoryById(catId);
    }

    @Override
    public List<Product> getProductsByCategoryId(int catId) {
        return productFacade.getProductsByCategoryId(catId);
    }

    @Override
    public Product getProductById(int productId) {
        return productFacade.getProductById(productId);
    }

    @Override
    public CustomerOrder placeOrder(Customer c, ShoppingBasket cart) {
       return customerOrderFacade.placeOrder(c, cart);
    }
    
       @Override
    public List<CustomerOrder> getAllOrders() {
        return customerOrderFacade.findAll();
    }

    private CategoryFacade lookupCategoryFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CategoryFacade) c.lookup("java:global/HaricotAimable-web/CategoryFacade!session.CategoryFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ProductFacade lookupProductFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ProductFacade) c.lookup("java:global/HaricotAimable-web/ProductFacade!session.ProductFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CustomerOrderFacade lookupCustomerOrderFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CustomerOrderFacade) c.lookup("java:global/HaricotAimable-web/CustomerOrderFacade!session.CustomerOrderFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
