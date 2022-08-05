package uz.muhammad.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import uz.muhammad.config.HibernateConfigurer;
import uz.muhammad.domains.Book;


import java.util.List;


@Component
public class BookDao implements Dao<Book> {


    @Override
    public Book persist(Book book) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(book);
        transaction.commit();
        session.close();
        return book;
    }

    @Override
    public void delete(Book book) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.remove(book);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.update(book);
        transaction.commit();
        session.close();
    }

    @Override
    public Book findOne(Long id) {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Book id1 = session.createQuery("select t from Book t where t.id = :id", Book.class)
                .setParameter("id", id).getSingleResultOrNull();
        transaction.commit();
        session.close();
        return id1;
    }

    @Override
    public List<Book> findAll() {
        Session session = HibernateConfigurer.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List<Book> list = session.createQuery("select t from Book t", Book.class).getResultList();
        transaction.commit();
        session.close();
        return list;
    }
}
