package com.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.models.Vaga;
import com.api.repositories.VagaRepository;
import com.api.services.exceptions.ObjectNotFoundException;

@Service
public class VagaService {

	@Autowired
	VagaRepository vagaRepository;

	public Vaga find(Integer id) {
		Optional<Vaga> vaga = vagaRepository.findById(id);
		return vaga.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName()));
	}
	
	public List<Vaga> findAll(){
		return vagaRepository.findAll();
	}
}
