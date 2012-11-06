/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author adminl
 */
public class JPAProductDao implements ProductDao {

    private final String PERSISTENCE_UNIT = "HaricotAimableTestPU";
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction tx;

    public JPAProductDao() {
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
    public void create(Product p) {
        tx.begin();
        em.persist(p);
        tx.commit();
    }

    @Override
    public Product read(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public void update(Product p) {
        tx.begin();
        em.merge(p);
        tx.commit();
    }

    @Override
    public void delete(Product p) {
        tx.begin();
        em.remove(em.merge(p));
        tx.commit();
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProductById(int productId) {
        return read(new Long(productId));
    }
}
