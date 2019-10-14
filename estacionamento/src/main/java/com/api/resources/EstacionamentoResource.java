package com.api.resources;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.dto.CarroDTO;
import com.api.models.Carro;
import com.api.models.Estacionamento;
import com.api.models.Vaga;
import com.api.repositories.VagaRepository;
import com.api.services.CarroService;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoResource {

	@Autowired
	CarroService carroService;
	
	@Autowired
	VagaRepository VagaRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Carro> find(@Valid @RequestBody Vaga vaga, @PathVariable Integer id) {
		Carro carro = carroService.find(id);
		if(carro != null) {
			VagaRepository.save(vaga);
		}
		return ResponseEntity.ok().body(carro);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CarroDTO>> findAll() {
		List<Carro> lista = carroService.findAll();
		List<CarroDTO> listDto = lista.stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());
		
		for(Carro carro : carroService.findAll()) {
			BigDecimal horas = carroService.calcularDiferenca(carro.getHoraEntrada(), new Date());
			BigDecimal totalPagar = carroService.calcularPagamento(carro.getPrecoHora(), horas);
			carro.setTotalPagar(totalPagar);
		}
		
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Carro> insert(@PathVariable @RequestBody CarroDTO objDto) {
		Carro obj = carroService.fromDTO(objDto);
		obj = carroService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Carro> update(@Valid @RequestBody CarroDTO carroDTO, @PathVariable Integer id) {
		Carro obj = carroService.fromDTO(carroDTO);
		obj.setId(id);
		obj = carroService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		carroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/estacionamento/relatorio/{id}")
	@ResponseBody
	public BigDecimal relatorio (@PathVariable("id") Carro carro){
		return carro.getTotalPagar();
	}

}
