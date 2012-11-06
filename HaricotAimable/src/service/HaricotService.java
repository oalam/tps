/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Category;
import entity.Customer;
import entity.Order;
import entity.ShoppingBasket;
import java.util.List;

/**
 *
 * @author adminl
 */
public interface HaricotService {
 
    List<Category> getAllCategories();
    List<Order> getAllOrders();
    Order placeOrder(Customer c, ShoppingBasket sb);
}
