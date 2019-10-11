package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Vaga;
import com.api.services.VagaService;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoController {

	@Autowired
	VagaService vagaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vaga> find(@PathVariable Integer id){
		Vaga vaga = vagaService.find(id);
		return ResponseEntity.ok().body(vaga);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Vaga>> findAll(){
		List<Vaga> lista = vagaService.findAll();
		return ResponseEntity.ok().body(lista);
	}
}
