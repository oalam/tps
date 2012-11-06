/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author adminl
 */
public class JPACategoryDao implements CategoryDao {

    private final String PERSISTENCE_UNIT = "HaricotAimableTestPU";
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction tx;

    public JPACategoryDao() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        em.close();
        emf.close();
    }

    @Override
    public List<Category> getAllCategories() {


        String jpqlQuery = "SELECT c FROM Category c";

        Query query = em.createQuery(jpqlQuery);
        List<Category> categories = query.getResultList();

        return categories;
    }

    @Override
    public Category getCategoryByName(String name) {
        Query query2 = em.createNamedQuery("Category.findByName");
        query2.setParameter("fname", "dairies");

        return (Category) query2.getSingleResult();

    }

    @Override
    public int getCategoryCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
