package repo;

import entity.Employee;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SessionEmployee {
    Session session;
    Transaction transaction;
    public static Employee employee;
    @Before
    public void before(){
        employee = new Employee();
        employee.setName("Petro");
        session = utils.HibernateUtils.sessionFactory().openSession();
        transaction = session.beginTransaction();

    }
    @Test
    public void sessionEmployeeTest(){
//
//        String sql = "SELECT e FROM Employee e WHERE id=1";
//        Query query = session.createQuery(sql);
//
//        String hql = "SELECT b FROM Book b";
//        Query hQuery = session.createQuery(hql);
//        employees = hQuery.list();
//        System.out.println(books);
//        //String hql = "FROM Employee E WHERE E.id = 10";
//        Criteria criteria = session.createCriteria(Book.class);
//        criteria.add(Restrictions.eq("price", 100));
//
//        SQLQuery sqlQuery = session.createSQLQuery(sql);
//        books = sqlQuery.list();
//        System.out.println(books);
        //session.persist(employee);
        session.save(employee);
        transaction.commit();

    }
    @After
    public void after(){
        if(!session.isOpen()) session.close();
    }
}
