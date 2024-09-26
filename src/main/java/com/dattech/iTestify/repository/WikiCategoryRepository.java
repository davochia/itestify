package com.dattech.iTestify.repository;

import com.dattech.iTestify.model.WikiCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiCategoryRepository extends CrudRepository<WikiCategory, Integer> {
}
