package repo;

import entity.Company;
import entity.Employee;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by faust on 22.11.15.
 */
public class PersistCompany {
    EntityManagerFactory emf;
    EntityManager em;

    public static Company company;
    static {
        company = new Company();
    }

    @Before
    public void beforeClass() {

        company.setCompanyName("BMV");
        emf = Persistence.createEntityManagerFactory("company");
        em = emf.createEntityManager();
    }

    @Test
    public void persistCompany() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(company);
        tx.commit();

        em.close();
        emf.close();
    }
}
