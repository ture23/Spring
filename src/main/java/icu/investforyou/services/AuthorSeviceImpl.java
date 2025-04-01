package icu.investforyou.services;

import icu.investforyou.domain.Author;
import icu.investforyou.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorSeviceImpl implements AuthorSevice {

    private final AuthorRepository authorRepository;
    public AuthorSeviceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

}
