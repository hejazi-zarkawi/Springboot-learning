package com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.controllers;

import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.entities.ProductEntity;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE=5;

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "1") Integer pageNumber,
                                                @RequestParam(defaultValue = "") String title
    ){
//        return productRepository.findAllByOrderByPriceAsc();
//        return productRepository.findBy(Sort.by
//                (Sort.Order.desc(sortBy)
//                ,Sort.Order.asc("title")));

        Pageable pageable= PageRequest.of(pageNumber,PAGE_SIZE, Sort.by(sortBy).ascending());

        Page<ProductEntity> result= productRepository.findByTitleContainingIgnoreCase(title,pageable);

        return result.getContent();
    }
}
