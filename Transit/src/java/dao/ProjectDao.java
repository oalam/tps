/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author adminl
 */
public abstract class ProjectDao<T> {

    private Class<T> entityClass;
    private final String PERSISTENCE_UNIT = "transitPU";
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    protected final EntityManager em = emf.createEntityManager();
    protected final EntityTransaction tx = em.getTransaction();

    public ProjectDao(Class<T> entityClass) {
	this.entityClass = entityClass;
    }

    public ProjectDao() {
    }

    @Override
    protected void finalize() throws Throwable {
	super.finalize();
	em.close();
	emf.close();
    }

    public boolean create(T t) {
	try {
	    tx.begin();
	    em.persist(t);
	    tx.commit();
	    return true;
	} catch (Exception ex) {
//	    String error = "unable to create entity " + t.toString();
//	    Logger.getLogger(entityClass.getName()).log(Level.WARNING, error);
	    return false;
	}
    }

    public T read(Object id) {
	return em.find(entityClass, id);
    }

    public void update(T t) {
	tx.begin();
	em.merge(t);
	tx.commit();
    }

    public void delete(T t) {
	tx.begin();
	em.remove(em.merge(t));
	tx.commit();
    }
}
