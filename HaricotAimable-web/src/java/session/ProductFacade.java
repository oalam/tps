/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Category;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adminl
 */
@javax.ejb.Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "HaricotAimablePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    public List<Product> getProductsByCategoryId(int currentCategoryId) {
        Query q = em.createNamedQuery("Product.findByCategoryId");
        q.setParameter("categoryId", currentCategoryId);

        return q.getResultList();
    }

    public Product getProductById(int productId) {
        Query q = em.createNamedQuery("Product.findById");
        q.setParameter("id", productId);

        try {
            return (Product) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
