package com.trubaieva.bookManager.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "Book_Id", nullable = false)
    private int id;

    @Column(name = "Book_Name", length = 64, nullable = false)
    private String name;

    @Column(name = "Author", length = 64, nullable = false)
    private String author;

    @Temporal(TemporalType.DATE)
    @Column(name = "Publish_Date", nullable = false)
    private Date publishDate;

    @Column(name = "Book_Price", nullable = false)
    private double price;

    public Book() {
    }

    public Book(int id, String name, String author, Date publishDate, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
