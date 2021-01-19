package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.ClientsEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<ClientsEntity,Long> {
    Optional<ClientsEntity> findByName(String name);
    Optional<ClientsEntity> findByMobile(int mobile);
    @Query(value = "SELECT * FROM clients WHERE  1", nativeQuery = true)
    Optional<List<ClientsEntity>> fetchAllClients();
}
