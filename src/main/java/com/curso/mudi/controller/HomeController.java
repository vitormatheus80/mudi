package com.curso.mudi.controller;

import com.curso.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();

		pedido.setNomeProduto("Nintendo Switch - Azul Neon e Vermelho Neon");
		pedido.setUrlProduto("https://www.amazon.com.br/Console-New-Nintendo-Switch-Vermelho/dp/B08M9S4XTR/ref=sr_1_5?crid=1FAC2SWZ0ZD8H&keywords=nintendo%2Bswitch&qid=1652206212&sprefix=nintendo%2Caps%2C280&sr=8-5&ufe=app_do%3Aamzn1.fos.95de73c3-5dda-43a7-bd1f-63af03b14751&th=1");
		pedido.setUrlImagem("https://cdn.pocket-lint.com/r/s/1200x630/assets/images/140007-games-review-nintendo-switch-review-image1-lp6zy9awm0.jpg");
		pedido.setDescricao("uma descrição para esse produto teste");

		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}



}
