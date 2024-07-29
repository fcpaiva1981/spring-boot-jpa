package br.com.fcpaiva.com.br.springbootjaph2;

import br.com.fcpaiva.com.br.springbootjaph2.domain.Book;
import br.com.fcpaiva.com.br.springbootjaph2.domain.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"br.com.fcpaiva.com.br.springbootjaph2.bootstrap"})
public class SpringBootJpaSpliceTest {
    
    @Autowired
    BookRepository bookRepository;

    //@Rollback(value = false)
    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("New Book","8798279879812","432"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);

    }

    @Order(2)
    @Test
    void testJpaTestTransaciton() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }

}
