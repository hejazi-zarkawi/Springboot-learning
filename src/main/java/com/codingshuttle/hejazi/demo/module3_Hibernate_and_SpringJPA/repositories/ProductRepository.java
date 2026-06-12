package com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.repositories;

import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByTitle(String title);

    @Query("select e from ProductEntity e where e.title=:title and e.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    List<ProductEntity> findByTitleLike(String s);

    List<ProductEntity> findAllByOrderByPriceAsc();

    Page<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
