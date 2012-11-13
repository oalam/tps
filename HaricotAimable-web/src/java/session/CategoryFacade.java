/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Category;
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
public class CategoryFacade extends AbstractFacade<Category> {
    @PersistenceContext(unitName = "HaricotAimable-webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public CategoryFacade() {
	super(Category.class);
    }
    
    public Category getCategoryById(int categoryId) {
	Query q = em.createNamedQuery("Category.findById");
	q.setParameter("id", categoryId);
	Category result = null;
	try {
	    result = (Category) q.getSingleResult();
	} catch (NoResultException ex) {
	}
	return result;
    }
    
}
