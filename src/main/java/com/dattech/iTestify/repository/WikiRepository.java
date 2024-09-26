package com.dattech.iTestify.repository;

import com.dattech.iTestify.model.Wiki;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiRepository extends CrudRepository<Wiki, Integer> {
}
