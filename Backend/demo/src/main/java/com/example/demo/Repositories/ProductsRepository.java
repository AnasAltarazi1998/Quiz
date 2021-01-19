package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.ProductsEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<ProductsEntity, Long> {
    Optional<ProductsEntity> findByName(String name);

    @Query(value = "SELECT * FROM products WHERE  1", nativeQuery = true)
    Optional<List<ProductsEntity>> fetchAllProducts();
          
}
