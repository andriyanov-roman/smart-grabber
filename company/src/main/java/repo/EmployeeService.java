package repo;

import entity.Company;
import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by faust on 22.11.15.
 */
public class EmployeeService {
    protected EntityManager em;

    public EmployeeService(EntityManager em) {
        this.em = em;
    }
    public Company createCompany (String companyName) {
        Company comp = new Company();
        comp.setCompanyName(companyName);
        em.persist(comp);
        return comp;
    }
    public Employee createEmployee (String employeeName) {
        Employee e = new Employee();
        e.setName(employeeName);
        em.persist(e);
        return e;
    }

    public Employee setEmployeeCompany(Long emplId, Long compId) {
        Employee empl = em.find(Employee.class,emplId);
        Company comp = em.find(Company.class,compId);
        comp.addEmployee(empl);
        return empl;
    }

    public List<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return (List<Employee>) query.getResultList();
    }
}
