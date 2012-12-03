/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.News;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adminl
 */
@Stateless
public class NewsFacade extends AbstractFacade<News> {
    @PersistenceContext(unitName = "Twitter-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewsFacade() {
        super(News.class);
    }
    
    public List<News> findLast(){
        Query q = em.createQuery("SELECT n FROM News n ORDER BY n.postDate DESC");
        q.setMaxResults(7);
        return q.getResultList();
    }
}
