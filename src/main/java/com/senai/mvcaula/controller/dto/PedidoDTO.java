package com.senai.mvcaula.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.senai.mvcaula.model.Pedido;

public class PedidoDTO {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotBlank @Pattern(regexp="[0-9]{1,13}(\\.[0-9]{2})?", message = "Campo deve ser um número válido")
	private String valor;
	
	public Pedido converter() {
		Pedido pedido = new Pedido();
		pedido.setNome(nome);
		pedido.setDescricao(descricao);
		pedido.setValor(Double.parseDouble(valor));
		pedido.setDataPedido(LocalDate.now());
		return pedido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
