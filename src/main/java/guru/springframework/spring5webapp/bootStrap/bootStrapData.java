package guru.springframework.spring5webapp.bootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.repositories.AuthorRespository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {
    private final AuthorRespository authorRespository;
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("domain deriven desing","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRespository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444" );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRespository.save(rod);
        bookRepository.save(noEJB);
    }
}
