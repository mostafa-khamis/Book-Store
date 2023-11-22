package com.example.bookStore.service;

import com.example.bookStore.entity.Book;
import com.example.bookStore.entity.MyBookList;

import java.util.List;

public interface MyBookService {
    void save(MyBookList book);
    List<MyBookList> getAll();
    void delete(int id);
}
