package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author adminl
 * @version 1.0
 * @created 03-oct.-2012 11:28:36
 */
public class Order {

    private UUID id = UUID.randomUUID();
    private Date date = new Date();
    private boolean isShipped = false;
    private Customer customer;
    private List<OrderedProduct> orderedProducts = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public boolean isIsShipped() {
        return isShipped;
    }

    public double getTotal() {
        double total = 0.0;
        
        for (OrderedProduct item : orderedProducts) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        
        return total;
    }
}