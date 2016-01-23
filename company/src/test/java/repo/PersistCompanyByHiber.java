package repo;

import entity.Company;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faust on 27.11.15.
 */
public class PersistCompanyByHiber {
    private Company company;
    private List<Employee> employees;
    @Before
    public void beforeClass() {
        company = new Company();
        company.setCompanyName("ZAZ");
        employees= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee e = new Employee();
            e.setName("Vasyl"+i);
            e.setCompany(company);
            employees.add(e);
        }
        company.setEmployees(employees);

    }

    @Test
    public void persistCompany () {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(ssrb.build());
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(company);

        Employee e = new Employee();
        e.setName("Vasyl"+888);
        e.setCompany(company);
        session.save(e);

        session.getTransaction().commit();
        session.close();
    }
}