/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Category;
import entity.Customer;
import entity.CustomerOrder;
import entity.Product;
import cart.ShoppingBasket;
import java.util.List;

/**
 *
 * @author adminl
 */
public interface HaricotService {

    List<Category> getAllCategories();

    Category getCategoryById(int catId);

    List<Product> getProductsByCategoryId(int catId);

    CustomerOrder placeOrder(Customer c, ShoppingBasket cart);

    Product getProductById(int productId);
}
