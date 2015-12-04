package repo;

import entity.Employee;
import org.junit.Before;
import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistEmployee {

    EntityManagerFactory emf;
    EntityManager em;

    public static Employee employee;
    static {

    }

    @Before
    public void beforeClass() {
        employee = new Employee();
        employee.setName("Petro");
        emf = Persistence.createEntityManagerFactory("company");
        em = emf.createEntityManager();
    }

    @Test
    public void persistEmployee() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(employee);
        tx.commit();

        em.close();
        emf.close();
    }

}
