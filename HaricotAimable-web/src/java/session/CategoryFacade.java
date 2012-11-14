/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Category;
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
public class CategoryFacade extends AbstractFacade<Category> {
    @PersistenceContext(unitName = "HaricotAimablePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    public List<Category> getAllCategories() {
        return findAll();
    }
    
    public Category getCategoryById(int catId) {
        Query q = em.createNamedQuery("Category.findById");
        q.setParameter("id", catId);
        
        try{
            return (Category) q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }
    }
    
}
