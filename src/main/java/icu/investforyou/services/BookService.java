package icu.investforyou.services;

import icu.investforyou.domain.Book;

public interface BookService {
    Iterable<Book> findAll();

}
