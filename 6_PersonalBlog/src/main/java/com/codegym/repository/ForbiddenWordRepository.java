package com.codegym.repository;

import com.codegym.model.ForbiddenWord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForbiddenWordRepository extends PagingAndSortingRepository<ForbiddenWord, Long> {

}
