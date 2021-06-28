package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByNameContaining(String q, Pageable pageable);

//    @Query(nativeQuery = true, value = "select * from product order by id limit ?1 offset ?2;")
//    Iterable<Product> findAllPaged(Long limit, Long offset);

    @Query(value = "select p from Product p order by ?1")
    Iterable<Product> findAllOrderBy(String order);

    @Query("select p from Product p order by p.name")
    List<Product> findAllOrderByName();

    @Query(value = "select * from product order by id limit ?1 offset ?2 ", nativeQuery = true)
    List<Product> findAllPaged(Long limit, Long offset);

    @Query("select p from Product p where p.id = ?1")
    Optional<Product> findByIdTest(Long id);
}
