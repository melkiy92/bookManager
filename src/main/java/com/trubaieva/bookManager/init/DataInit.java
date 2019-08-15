package com.trubaieva.bookManager.init;

import com.trubaieva.bookManager.dao.BookDAO;
import com.trubaieva.bookManager.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataInit implements ApplicationRunner {

    private BookDAO bookDAO;

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = bookDAO.count();

        if (count == 0) {
            Book p1 = new Book();

            p1.setName("Fairy Tale");
            p1.setAuthor("Vladimir Antonov");
            Date d1 = df.parse("1980-12-20");
            p1.setPublishDate(d1);
            p1.setPrice(135);

            Book p2 = new Book();

            p2.setName("Good story");
            p2.setAuthor("Smith Tailor");
            Date d2 = df.parse("1985-11-11");
            p2.setPublishDate(d2);
            p2.setPrice(225);

            bookDAO.save(p1);
            bookDAO.save(p2);
        }

    }

}
