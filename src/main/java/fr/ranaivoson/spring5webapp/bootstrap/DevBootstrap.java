package fr.ranaivoson.spring5webapp.bootstrap;

import fr.ranaivoson.spring5webapp.model.Author;
import fr.ranaivoson.spring5webapp.model.Book;
import fr.ranaivoson.spring5webapp.model.Publisher;
import fr.ranaivoson.spring5webapp.repositories.AuthorRepository;
import fr.ranaivoson.spring5webapp.repositories.BookRepository;
import fr.ranaivoson.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Vazimba");

        publisherRepository.save(publisher);

        //Arison Jaha
        Author jaha = new Author("Arison", "Jaha");
        Book toraka = new Book("Toraka", "1234", publisher);
        jaha.getBooks().add(toraka);
        toraka.getAuthors().add(jaha);

        authorRepository.save(jaha);
        bookRepository.save(toraka);

        //Ricky Olo
        Author ricky = new Author("Ricky", "Olo");
        Book pasy = new Book("Velirano", "5678", publisher);
        ricky.getBooks().add(pasy);
        pasy.getAuthors().add(ricky);

        authorRepository.save(ricky);
        bookRepository.save(pasy);
    }
}
