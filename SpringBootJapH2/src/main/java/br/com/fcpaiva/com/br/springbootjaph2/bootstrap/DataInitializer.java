package br.com.fcpaiva.com.br.springbootjaph2.bootstrap;

import br.com.fcpaiva.com.br.springbootjaph2.domain.Book;
import br.com.fcpaiva.com.br.springbootjaph2.domain.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Design", "1234", "Random");
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookDDD2 = new Book("Spring in Action!", "4321", "RandomHouse");
        Book savedDDD2 = bookRepository.save(bookDDD2);

        bookRepository.findAll().forEach(book -> {
            System.out.println(String.format("Book ID: %s", book.getId()));
            System.out.println(String.format("Book Title: %s", book.getTitle()));
        });
    }
}
