package icu.investforyou.repositories;

import org.springframework.data.repository.CrudRepository;

import icu.investforyou.domain.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
