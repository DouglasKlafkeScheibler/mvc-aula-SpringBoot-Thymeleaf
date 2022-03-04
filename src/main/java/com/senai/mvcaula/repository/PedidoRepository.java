package com.senai.mvcaula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.mvcaula.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{	
}
