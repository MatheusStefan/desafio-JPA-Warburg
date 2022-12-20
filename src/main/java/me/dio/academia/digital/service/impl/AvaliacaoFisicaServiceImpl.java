package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Autowired
	private AlunoRepository AlunoRepository;

	@Override
	public AvaliacaoFisica get(Long id) {
		return avaliacaoFisicaRepository.getById(id);
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		return avaliacaoFisicaRepository.findAll();
	}

	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacao = new AvaliacaoFisica();
		Aluno aluno = AlunoRepository.findById(form.getAlunoId()).get();
		
		avaliacao.setAluno(aluno);
		avaliacao.setPeso(form.getPeso());
		avaliacao.setAltura(form.getAltura());
		
		return avaliacaoFisicaRepository.save(avaliacao);
		
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}
	
	

}
