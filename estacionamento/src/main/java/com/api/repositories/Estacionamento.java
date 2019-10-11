package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estacionamento extends JpaRepository<Estacionamento, Integer> {

}
