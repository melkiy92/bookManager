package com.trubaieva.bookManager.dao;

import com.trubaieva.bookManager.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookDAO extends CrudRepository<Book, Long> {

    public List<Book> findAll();

    public List<Book> findByNameLike(String name);

    public List<Book> findByPublishDate(Date date);

}