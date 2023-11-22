package com.example.bookStore.controller;

import com.example.bookStore.entity.Book;
import com.example.bookStore.entity.MyBookList;
import com.example.bookStore.service.BookService;
import com.example.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookService myBookService;
    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "book_register";
    }

    @GetMapping("/my_books")
    public String myBooks(Model model){
        List<MyBookList> myBookList = myBookService.getAll();
        model.addAttribute("myBook",myBookList);
        return "myBooks";
    }


    @GetMapping("/available_book")
    public String availableBook(Model model){
        List<Book> bookList = bookService.getAll();
        model.addAttribute("book",bookList);
        return "available_book";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_book";
    }

    @RequestMapping("/myList/{id}")
    public String getBookById(@PathVariable("id") int id){
        Book book = bookService.getById(id);
        MyBookList myBookList = new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookService.save(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBookById(@PathVariable("id") int id){
        myBookService.delete(id);
        return "redirect:/my_books";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model ){
        Book book = bookService.getById(id);
        model.addAttribute("book",book);
        return "edit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable("id") int id){
        bookService.delete(id);
        return "redirect:/available_book";
    }
}
