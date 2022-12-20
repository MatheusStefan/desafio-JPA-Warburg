package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

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
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
@Api(value = "API REST Academia Digital")
@CrossOrigin(origins = "*")
public class AlunoController {

	@Autowired
	private AlunoServiceImpl service;

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um aluno por id")
	public Aluno getAlunoById(@PathVariable(value = "id") Long aluno) {
		return service.get(aluno);
	}

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de todos os alunos")
	public List<Aluno> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/avaliacoes/{id}")
	@ApiOperation(value = "Retorna uma lista de avaliações por aluno")
	public List<AvaliacaoFisica> getAllAvalicaoById(@PathVariable Long id) {
		return service.getAllAvalicaoById(id);
	}

	@PostMapping
	@ApiOperation(value = "Cria um aluno novo")
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}

	@PutMapping
	@ApiOperation(value = "Atualização total de um aluno")
	public Aluno updateAll(@RequestBody Long id, AlunoUpdateForm alunoForm) {
		return service.update(id, alunoForm);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um aluno por ID")
	public void deleteById(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
