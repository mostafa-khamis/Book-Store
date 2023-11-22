package com.example.bookStore.service;

import com.example.bookStore.entity.Book;

import java.util.List;

public interface BookService {
    void save(Book book);

    List<Book> getAll();

    Book getById(int id);
    void delete(int id);
}
