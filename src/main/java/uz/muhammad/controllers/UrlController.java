package uz.muhammad.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uz.muhammad.domains.Book;
import uz.muhammad.dto.BookCreateVO;
import uz.muhammad.dto.BookPageVO;
import uz.muhammad.dto.BookUpdateVo;
import uz.muhammad.service.BookService;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class UrlController {


    private final BookService bookService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = {"/books"}, method = RequestMethod.GET)
    public String listBookPage(
            @RequestParam(name = "size", defaultValue = "10") long size,
            @RequestParam(name = "page", defaultValue = "0") long page,
            Model model) {

        BookPageVO pageVO = bookService.getBooksPage(size, page);
        model.addAttribute("page", pageVO);
        return "book/list";
    }


    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addBookPage() {
        return "book/add";
    }


    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addBook(@ModelAttribute BookCreateVO vo) {
        Book book = bookService.create(vo);
        return "redirect:/books";
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public String deleteBookPage(
            @RequestParam(name = "book") long book,
            @RequestParam(name = "page") long page,
            Model model) {
        Book one = bookService.findOne(book);

        if (Objects.isNull(one)) {
            model.addAttribute("error", "Book not found");
        }

        model.addAttribute("book", one);
        model.addAttribute("page", page);
        return "book/delete";
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.POST)
    public String deleteBook(
            @RequestParam(name = "book") long book,
            @RequestParam(name = "page") long page
    ) {
        bookService.delete(book);

        return "redirect:/books?page=" + page;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.GET)
    public String updateBookPage(
            @RequestParam(name = "book") long book,
            @RequestParam(name = "page") long page,
            Model model) {

        Book one = bookService.findOne(book);
        model.addAttribute("book", one);
        model.addAttribute("page", page);
        return "book/update";
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String updateBook(
            @ModelAttribute BookUpdateVo vo,
            @RequestParam(name = "book") long book,
            @RequestParam(name = "page") long page
    ) {
        vo.setId(book);
        bookService.update(vo);
        return "redirect:/books?page=" + page;
    }

}
