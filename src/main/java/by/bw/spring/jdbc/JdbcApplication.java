package by.bw.spring.jdbc;

import by.bw.spring.jdbc.dao.BookJdbcDao;
import by.bw.spring.jdbc.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

// CREATE TABLE `springtest`.`books` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(255) NOT NULL , `author` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Autowired
	BookJdbcDao bookJdbcDao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		Book book = new Book(1,"Два капитана", "Каверин");
		bookJdbcDao.addBook(book);
		Book book2 = new Book(2,"Таинственный остров", "Верн");
		bookJdbcDao.addBook(book2);
		System.out.println("+++++++++++++++");
		System.out.println(bookJdbcDao.findeAllBooks());
	}
}
