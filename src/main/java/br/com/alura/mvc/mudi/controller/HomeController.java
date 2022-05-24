package br.com.alura.mvc.mudi.controller;

import java.util.List;
import java.util.Locale;

import br.com.alura.mvc.mudi.model.enums.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository repository;
	
	@GetMapping
	public String home(Model model) {
		List<Pedido> pedidos = repository.findAll();
		model.addAttribute("pedidos", pedidos);
		return "home"; 
	}

	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase(Locale.ROOT)));
		model.addAttribute("pedidos", pedidos);
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError(){
		return "redirect:/home";
	}

}
