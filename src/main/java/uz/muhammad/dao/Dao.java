package uz.muhammad.dao;



import uz.muhammad.domains.Book;
import uz.muhammad.domains.Domain;

import java.util.List;

public interface Dao<D extends Domain> {

    D persist(D d);
    void delete(Book book);
    void update(D d);
    D findOne(Long id);
    List<D> findAll();

}
