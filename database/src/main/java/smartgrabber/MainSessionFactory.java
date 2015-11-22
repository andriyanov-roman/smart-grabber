package smartgrabber;


import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import smartgrabber.entity.Book;

import java.util.List;

public class MainSessionFactory {
    public static void main(String[] args) {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
//                configuration.getProperties()).build();
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        System.out.println(sessionFactory != null);

         //loads configuration and mappings
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Book.class);
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = null;
        Session session = null;

        Transaction transaction = null;
        Book book = new Book("H2G2",12.5F,"Автостопом по Галактике",
                "1-84023-742-2", 354, false);

        try {
            sessionFactory = configuration.buildSessionFactory(builder.build());

            session = sessionFactory.openSession();
            String sql = "SELECT b FROM Book b WHERE id=1";
            Query query = session.createQuery(sql);
            List<Book> books = query.list();
            System.out.println(books);
            String hql = "SELECT b FROM Book b";
            Query hQuery = session.createQuery(hql);
            books = hQuery.list();
            System.out.println(books);
            //String hql = "FROM Employee E WHERE E.id = 10";
            Criteria criteria = session.createCriteria(Book.class);
            criteria.add(Restrictions.eq("price", 100));
            transaction = session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            books = sqlQuery.list();
            System.out.println(books);
            session.save(book);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session.isOpen()) {
                session.close();
            }
            if(!sessionFactory.isClosed()) {
                sessionFactory.close();
            }

        }
    }
}
