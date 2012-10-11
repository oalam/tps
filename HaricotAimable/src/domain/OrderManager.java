package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
public class OrderManager {
    
    private List<Order> orders = new ArrayList<>();

    public Order placeOrder(String payementInfos, String address, String name,
            ShoppingBasket cart) throws ProductStockException {

        Customer cust = new Customer(name, address, payementInfos);
        Order order = new Order(cust);

        for (ShoppingBasketItem item : cart.getItems()) {
            Product p = item.getProduct();
            int quantity = item.getQuantity();
            int stockQuantity = p.getStockQuantity();

            // test stocks
            if (stockQuantity >= quantity) {
                // create OrderedProducts
                OrderedProduct op = new OrderedProduct(quantity, p);
                order.getOrderedProducts().add(op);
                
                p.setStockQuantity(stockQuantity-quantity);
            }else{
                
                order = null;
                throw new ProductStockException("not enough stock for " +
                        p.getName());
            }
        }

        orders.add(order);

        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}