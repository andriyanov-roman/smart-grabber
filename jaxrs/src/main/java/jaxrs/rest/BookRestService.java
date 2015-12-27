package jaxrs.rest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import smartgrabber.HibernateUtil;
import smartgrabber.entity.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookRestService {


    @GET
    @Produces("text/plain")
    public String getBookTitle() {
        HibernateUtil util = HibernateUtil.getInstance();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT b FROM Book b";
        Query hQuery = session.createQuery(hql);
        List<Book> books = hQuery.list();
        return books.get(0).toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/jBook")
    public Book getBook() {
        HibernateUtil util = HibernateUtil.getInstance();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "SELECT b FROM Book b";
        Query hQuery = session.createQuery(hql);
        List<Book> books = hQuery.list();
        return books.get(0);
    }
}