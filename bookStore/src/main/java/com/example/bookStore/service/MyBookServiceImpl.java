package com.example.bookStore.service;

import com.example.bookStore.entity.MyBookList;
import com.example.bookStore.repo.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookServiceImpl implements MyBookService{
    @Autowired
    private MyBooksRepository myBooksRepository;


    @Override
    public void save(MyBookList book) {
        myBooksRepository.save(book);
    }

    @Override
    public List<MyBookList> getAll() {
        return myBooksRepository.findAll();
    }

    @Override
    public void delete(int id) {
        myBooksRepository.deleteById(id);
    }
}
