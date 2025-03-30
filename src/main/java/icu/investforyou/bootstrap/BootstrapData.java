package icu.investforyou.bootstrap;

import icu.investforyou.domain.Author;
import icu.investforyou.domain.Book;
import icu.investforyou.domain.Publisher;
import icu.investforyou.repositories.AuthorRepository;
import icu.investforyou.repositories.BookRepository;
import icu.investforyou.repositories.PublisherReposetory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherReposetory publisherReposetory;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherReposetory publisherReposetory) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherReposetory = publisherReposetory;
    }
    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Golden");


        Book book = new Book();
        book.setTitle("Book Title");
        book.setIsbn("ISBN");

        Author erickSaved = authorRepository.save(eric);
        Book bookSaved = bookRepository.save(book);

        Author marko = new Author();
        marko.setFirstName("Marko");
        marko.setLastName("Turic");

        Book bookTuric = new Book();
        bookTuric.setTitle("Book Turic");
        bookTuric.setIsbn("ISBN");
        Author markoSaved = authorRepository.save(marko);
        Book bookTuricSaved = bookRepository.save(bookTuric);

        erickSaved.getBooks().add(bookSaved); // association between author and the book (to be in DB linked together )
        markoSaved.getBooks().add(bookTuricSaved);
        bookSaved.getAuthors().add(erickSaved);
        bookTuricSaved.getAuthors().add(markoSaved);


        Publisher publisher = new Publisher();
        publisher.setPublisherNam("Publisher Name");
        publisher.setAddress("First Street");
        publisher.setCity("New Your");
        publisher.setState("New York State");
        publisher.setZip("1234");

        Publisher publisherSaved = publisherReposetory.save(publisher);

        bookSaved.setPublisher(publisherSaved);
        bookTuric.setPublisher(publisherSaved);

        authorRepository.save(erickSaved); // save to db
        authorRepository.save(marko);
        bookRepository.save(bookSaved);
        bookRepository.save(bookTuricSaved);

        System.out.println("In BootstrapData");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());


        System.out.println("Publisher Count: " + publisherReposetory.count());
    }

}
