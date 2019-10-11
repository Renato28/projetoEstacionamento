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
		return vaga.orElseThrow(() -> new ObjectNotFoundException(
				"Vaga não encontrada! Id: " + id + ", Tipo: " + Vaga.class.getName()));
	}

	public Vaga insert(Vaga vaga) {
		vaga.setId(null);
		vaga = vagaRepository.save(vaga);
		return vaga;
	}

	public Vaga update(Vaga vaga) {
		Vaga newVaga = find(vaga.getId());
		return vagaRepository.save(newVaga);
	}

	public void delete(Integer id) {
		vagaRepository.deleteById(id);
	}

	public List<Vaga> findAll() {
		return vagaRepository.findAll();
	}
}
