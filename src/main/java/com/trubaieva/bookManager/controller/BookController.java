package com.trubaieva.bookManager.controller;

import com.trubaieva.bookManager.dao.BookDAO;
import com.trubaieva.bookManager.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    private Iterable<Book> bookList;

    @Autowired
    private BookDAO bookDAO;


    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        String message = "It's a library.";
        model.addAttribute("message", message);
        return "index";
    }


    @RequestMapping(value = { "/bookList" }, method = RequestMethod.GET)
    public String viewBookList(Model model) {
        bookList = bookDAO.findAll();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

}
