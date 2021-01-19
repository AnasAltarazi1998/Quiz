package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.SalesEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<SalesEntity,Long> {
    @Query(value = "SELECT * FROM sales WHERE  1", nativeQuery = true)
    Optional<List<SalesEntity>> fetchAllSales();
}
