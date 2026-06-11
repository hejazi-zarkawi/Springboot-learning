package com.codingshuttle.hejazi.demo;

import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.entities.ProductEntity;
import com.codingshuttle.hejazi.demo.module3_Hibernate_and_SpringJPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity= ProductEntity.builder().price(BigDecimal.valueOf(238L)).quantity(26)
				.sku("cad874682yu").title("Cadbury Co").build();
		ProductEntity saved= productRepository.save(productEntity);
		System.out.println(saved);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities= productRepository.findByTitle("parle");
//		System.out.println(entities);

//		Optional<ProductEntity> entity= productRepository.findByTitleAndPrice("Cadbury",BigDecimal.valueOf(30L));
//		entity.ifPresent(product -> System.out.println(product));

		List<ProductEntity> entities= productRepository.findByTitleLike("%Cad%");
		entities.stream().forEach(entity-> System.out.println(entity));
	}

}
