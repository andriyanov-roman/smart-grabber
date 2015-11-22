package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(entity.Company.class);
            configuration.addAnnotatedClass(entity.Employee.class);
            configuration.addAnnotatedClass(entity.Product.class);

            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error happen while building SessionFactory");
        }
    }
    public static SessionFactory sessionFactory(){
        return sessionFactory;
    }

}
