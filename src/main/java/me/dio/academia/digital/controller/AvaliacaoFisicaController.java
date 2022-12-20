package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
@Api
@CrossOrigin(origins = "*")
public class AvaliacaoFisicaController {
	
	@Autowired
	private AvaliacaoFisicaServiceImpl service;
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma avaliação por ID")
	public AvaliacaoFisica getAvaliacaoById(@RequestBody Long id) {
		return service.get(id);
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista com todas as avaliações")
	public List<AvaliacaoFisica> getAllAvalicoes() {
		return service.getAll();
	}
	
	@PostMapping
	@ApiOperation(value = "Cria uma nova avaliação")
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
	
	@PutMapping
	@ApiOperation(value = "Atualização total de uma avaliação")
	public AvaliacaoFisica updateAll(@RequestBody Long id, AvaliacaoFisicaUpdateForm avaliacaoForm) {
		return service.update(id, avaliacaoForm);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma avaliação por ID")
	public void deleteById(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
