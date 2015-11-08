package persist;


import org.junit.Before;
import org.junit.Test;
import smartgrabber.entity.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistEntity {
    EntityManagerFactory emf;
    EntityManager em;

    public static Address address;
    static {
        address = new Address();
        address.setCity("Kiev");
        address.setCountry("Ukrain");
        address.setState("No State");
        address.setStreet1("Pr.Pobedy");
        address.setZipcode("05502");
    }

    @Before
    public void beforeClass() {
        emf = Persistence.createEntityManagerFactory("chapter04PU");
        em = emf.createEntityManager();
    }

    @Test
    public void persistAddress() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(address);
        tx.commit();


    }

}
