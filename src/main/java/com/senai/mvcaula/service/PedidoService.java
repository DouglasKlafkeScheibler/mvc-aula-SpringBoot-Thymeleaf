package com.senai.mvcaula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.mvcaula.model.Pedido;
import com.senai.mvcaula.repository.PedidoRepository;

@Service
public class PedidoService {
	
	private PedidoRepository repository;
	
	public PedidoService(PedidoRepository repository) {
		this.repository = repository;
	}

	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido insert(Pedido pedido) {
		return repository.save(pedido);
	}
}
