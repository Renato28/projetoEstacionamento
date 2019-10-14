package com.api.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.dto.CarroDTO;
import com.api.models.Carro;
import com.api.repositories.CarroRepository;
import com.api.services.exceptions.ObjectNotFoundException;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;

	public Carro find(Integer id) {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.orElseThrow(() -> new ObjectNotFoundException(
				"Carro não encontrado! Id: " + id + ", Tipo: " + Carro.class.getName()));
	}

	@Transactional
	public Carro insert(Carro carro) {
		carro.setId(null);
		carro = carroRepository.save(carro);
		return carro;
	}

	public Carro update(Carro carro) {
		Carro newCarro = find(carro.getId());
		return carroRepository.save(newCarro);
	}

	public void delete(Integer id) {
		carroRepository.deleteById(id);
	}

	public List<Carro> findAll() {
		return carroRepository.findAll();
	}

	public Carro fromDTO(CarroDTO carroDTO) {
		return new Carro(carroDTO.getId(), carroDTO.getModelo(), carroDTO.getAno(), carroDTO.getCor(),
				carroDTO.getPrecoHora(), carroDTO.getHoraEntrada(), carroDTO.getTotalPagar());
	}

	public BigDecimal calcularDiferenca(Date horaEntrada, Date horaSaida) {

		DateTime entrada = new DateTime(horaEntrada);
		DateTime saida = new DateTime(horaSaida);

		BigDecimal minutos = new BigDecimal(Minutes.minutesBetween(entrada, saida).getMinutes());
		BigDecimal horas = minutos.divide(new BigDecimal("60"), 2, RoundingMode.HALF_UP);
		return horas;
	}

	public BigDecimal calcularPagamento(BigDecimal precoHora, BigDecimal horas) {

		BigDecimal totalPagar = precoHora.multiply(horas);
		return totalPagar;
	}
}
