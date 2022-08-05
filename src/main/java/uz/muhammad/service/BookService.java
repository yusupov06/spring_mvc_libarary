package uz.muhammad.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.muhammad.dao.BookDao;
import uz.muhammad.domains.Book;
import uz.muhammad.dto.BookCreateVO;
import uz.muhammad.dto.BookPageVO;
import uz.muhammad.dto.BookUpdateVo;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao dao;

    public List<Book> findAll() {
        return dao.findAll();
    }

    public Book create(BookCreateVO vo) {
        Book book = Book.builder()
                .title(vo.getTitle())
                .author(vo.getAuthor())
                .pageCount(vo.getPageCount())
                .build();
        dao.persist(book);
        return book;
    }

    public Book findOne(Long id) {
        return dao.findOne(id);
    }


    public void delete(Long id) {
        Book one = dao.findOne(id);
        dao.delete(one);
    }

    public void update(BookUpdateVo vo) {
        dao.update(Book.builder()
                .id(vo.getId())
                .title(vo.getTitle())
                .author(vo.getAuthor())
                .pageCount(vo.getPageCount())
                .build());
    }

    public BookPageVO getBooksPage(long size, long page) {

        List<Book> books = dao.findAll();

        List<Book> paginatedBooks = books.stream()
                .skip(page * size)
                .limit(size)
                .toList();



        long pagesCount = books.size() / size;
        return BookPageVO.builder()
                .next(page + 1)
                .previous(page - 1)
                .hasNext(page != pagesCount)
                .hasPrevious(page != 0)
                .currentPage(page)
                .books(paginatedBooks)
                .totalPages(pagesCount)
                .build();
    }
}
