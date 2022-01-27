package br.com.alura.mvc.modi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.modi.model.Pedido;
import br.com.alura.mvc.modi.model.StatusPedido;
import br.com.alura.mvc.modi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardadndoOfertas() {
		Sort sort = Sort.by("id").ascending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
		
//		PageRequest paginacao = PageRequest.of(0, 10, Sort.by("id").ascending());
//		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
		
//		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, PageRequest.of(0, 10, Sort.by("id").descending()));
	}
}
