package by.bw.spring.jdbc.dao;

import by.bw.spring.jdbc.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> findeAllBooks() {
        List<Book> books = jdbcTemplate.query("SELECT * from BOOKS", new BeanPropertyRowMapper<>(Book.class));
        return books;
    }

    public void addBook(Book book) {
        jdbcTemplate.update("INSERT INTO books (id, name, author) VALUES (?, ?, ?)",
                                 book.getId(), book.getName(), book.getAuthor());
    }
}
