package com.senai.mvcaula.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.senai.mvcaula.controller.dto.PedidoDTO;
import com.senai.mvcaula.model.Pedido;
import com.senai.mvcaula.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	private PedidoService service;
	
	public PedidoController(PedidoService service) {
		this.service = service;
	}
	
	@GetMapping("/todos")
	public String listPedidos(Model model){
		List<Pedido> pedidos = service.findAll();
		model.addAttribute("pedidos", pedidos);
		return "pedido";
	}
	
	@GetMapping("/formulario")
    public String formulario(PedidoDTO novoPedidoDto){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid PedidoDTO pedidoDto, BindingResult result){
        if (result.hasErrors())
            return "pedido/formulario";
        service.insert(pedidoDto.converter());
        return "redirect:/pedido/todos";
    }
}