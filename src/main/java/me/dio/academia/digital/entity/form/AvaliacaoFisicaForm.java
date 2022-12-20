package me.dio.academia.digital.entity.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

	@Positive(message = "O ID precisa ser positivo.")
	private Long alunoId;

	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "O peso precisa ser positivo.")
	private double peso;
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "A altura precisa ser positiva.")
	@DecimalMin(value = "150", message = "A altura precisa ser no mínimo {value}.")
	private double altura;

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
