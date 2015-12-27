package smartgrabber;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import smartgrabber.entity.Book;

/**
 * Created by randriyanov on 27.12.15.
 */
public class HibernateUtil {
    private static HibernateUtil instance = null;
    private static SessionFactory sessionFactory = null;
    private static StandardServiceRegistry serviceRegistry = null;

    private HibernateUtil(){
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Book.class);
        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static HibernateUtil getInstance(){
        if(instance == null){
            instance  = new HibernateUtil();
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
