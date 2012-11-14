/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import cart.ShoppingBasket;
import cart.ShoppingBasketItem;
import entity.Customer;
import entity.CustomerOrder;
import entity.OrderedProduct;
import entity.OrderedProductPK;
import entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adminl
 */
@javax.ejb.Stateless
public class CustomerOrderFacade extends AbstractFacade<CustomerOrder> {

    @PersistenceContext(unitName = "HaricotAimablePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerOrderFacade() {
        super(CustomerOrder.class);
    }

    public CustomerOrder placeOrder(Customer c, ShoppingBasket cart) {

        em.persist(c);
        CustomerOrder order = new CustomerOrder();

        order.setCustomerId(c);
        order.setAmount(BigDecimal.valueOf(cart.getTotal()));

        Random r = new Random();
        int confirmationNumber = r.nextInt(999999999);
        order.setConfirmationNumber(confirmationNumber);
       // order.setDateCreated(new Date());
        em.persist(order);

        em.flush(); //needed ?
        order.setOrderedProductList(new ArrayList<OrderedProduct>());



        for (ShoppingBasketItem item : cart.getItems()) {
            Product p = item.getProduct();
            short quantity = (short) item.getQuantity();
            OrderedProductPK key = new OrderedProductPK(order.getId(), p.getId());
            
            
            OrderedProduct op = new OrderedProduct(key, quantity);
            order.getOrderedProductList().add(op);
            em.persist(op);


        }


        return order;
    }
}
