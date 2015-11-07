package smartgrabber;


import smartgrabber.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by randriyanov on 05.11.15.
 */
public class MainJpaExample {
    public static void main(String[] args) {
// 1. Создает экземпляр Book
        Book book = new Book("H2G2",12.5F, "Dima is mudriy",
                "1-84023-742-2", 354, false);
// 2. Получает EntityManager и транзакцию
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();
// 3. Обеспечивает постоянство Book в базе данных
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
// 4. Выполняет именованный запрос
        book = em.createNamedQuery("findBookByTitle", Book.class).getSingleResult();
        book = em.createNamedQuery("findBookByDescription", Book.class)
                .setParameter("description", "Dima is mudriy").getSingleResult();
        System.out.println(book.getId());
// 5. Закрывает EntityManager и EntityManagerFactory
        em.close();
        emf.close();
    }
}
