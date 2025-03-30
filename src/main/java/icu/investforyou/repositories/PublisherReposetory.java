package icu.investforyou.repositories;

import icu.investforyou.domain.Publisher;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.data.repository.CrudRepository;

public interface PublisherReposetory extends CrudRepository<Publisher, Long> {

}
