/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.BusinessObjectFactory;
import entity.Category;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adminl
 */
public class JPACategoryDaoTest {

    public JPACategoryDaoTest() {
    }
    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction tx;

    @BeforeClass
    public static void setUpEntityManager() {
        emf = Persistence.createEntityManagerFactory("HaricotAimableTestPU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownEntityManager() {
        em.close();
        emf.close();
    }

    @Before
    public void setUpTransaction() {
        tx = em.getTransaction();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of finalize method, of class JPACategoryDao.
     */
    @Test
    public void testFinalize() throws Exception {
    }

    /**
     * Test of getAllCategories method, of class JPACategoryDao.
     */
    @Test
    public void testGetAllCategories() {


        Map<String, Category> categories =
                BusinessObjectFactory.createSampleCategoryList();


        // 3. Stockage du livre dans la base de données.
        tx.begin();
        em.persist(categories.get("dairies"));
        em.persist(categories.get("bakery"));
        em.persist(categories.get("vegetables"));
        em.persist(categories.get("meats"));
        tx.commit();

        CategoryDao dao = new JPACategoryDao();

        // requete JPQL to count previous cat size

        List<Category> cats = dao.getAllCategories();

        assertEquals(4, cats.size());





        tx.begin();
        em.remove(categories.get("dairies"));
        em.remove(categories.get("bakery"));
        em.remove(categories.get("vegetables"));
        em.remove(categories.get("meats"));
        tx.commit();

    }
}
