/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author tom
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "HaricotAimable-webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public ProductFacade() {
	super(Product.class);
    }

    public Product getProductById(int productId) {
	Query q = em.createNamedQuery("Product.findById");
	q.setParameter("id", productId);
	Product result = null;
	try {
	    result = (Product) q.getSingleResult();
	} catch (NoResultException ex) {
	}
	return result;
    }
}
