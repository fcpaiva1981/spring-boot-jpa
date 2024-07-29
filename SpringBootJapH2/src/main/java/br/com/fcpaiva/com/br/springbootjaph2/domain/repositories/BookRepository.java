package br.com.fcpaiva.com.br.springbootjaph2.domain.repositories;

import br.com.fcpaiva.com.br.springbootjaph2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
