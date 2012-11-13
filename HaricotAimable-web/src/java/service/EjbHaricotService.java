/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cart.ShoppingBasket;
import entity.Category;
import entity.Customer;
import entity.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.criteria.Order;
import session.CategoryFacade;
import session.ProductFacade;

/**
 *
 * @author tom
 */
public class EjbHaricotService implements HaricotService {

    ProductFacade productFacade = lookupProductFacadeBean();
    CategoryFacade categoryFacade = lookupCategoryFacadeBean();

    @Override
    public List<Category> getAllCategories() {
	return categoryFacade.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId) {
	return categoryFacade.getCategoryById(categoryId);
    }

    @Override
    public Order placeOrder(Customer c, ShoppingBasket cart) {
	throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public Product getProductById(int productId) {
	return productFacade.getProductById(productId);
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
}
