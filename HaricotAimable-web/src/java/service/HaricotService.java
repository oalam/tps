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
import javax.persistence.criteria.Order;

/**
 *
 * @author tom
 */
public interface HaricotService {

    List<Category> getAllCategories();
    
    Product getProductById(int productId);
    
    Category getCategoryById(int categoryId);

    Order placeOrder(Customer c, ShoppingBasket cart);
}
