package repo;

import entity.Company;
import entity.Employee;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faust on 22.11.15.
 */
public class PersistCompany {
    EntityManagerFactory emf;
    EntityManager em;
    EmployeeService employeeService;
    static {

    }

    @Before
    public void beforeClass() {
        emf = Persistence.createEntityManagerFactory("company");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        employeeService = new EmployeeService(em);
        Company company = employeeService.createCompany("Volvo");
        List<Employee> employees= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee e = employeeService.createEmployee("Petro-"+i);
            company.addEmployee(e);
            employeeService.setEmployeeCompany(e.getId(),company.getId());
        }

    }

    @Test
    public void persistCompany() {
        em.getTransaction().commit();
        System.out.println("Show Employees");
        employeeService.findAllEmployees().forEach(System.out::println);
        System.out.println("Say GOOD BYE for connection!!!");
        em.close();
        emf.close();
    }
}
