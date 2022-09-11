package com.devsuperior.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.client.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
