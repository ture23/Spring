package icu.investforyou.services;

import icu.investforyou.domain.Book;
import icu.investforyou.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private  final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
