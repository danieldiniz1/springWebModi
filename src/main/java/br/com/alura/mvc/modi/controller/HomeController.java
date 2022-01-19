package br.com.alura.mvc.modi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.modi.model.StatusPedido;
import br.com.alura.mvc.modi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		Sort sort = Sort.by("dataEntrega").ascending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		model.addAttribute("pedidos",pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao));
		return "home";
	}
	
	
}
