package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.models.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {

}
