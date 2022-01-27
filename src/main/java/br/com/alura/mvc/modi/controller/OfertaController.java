package br.com.alura.mvc.modi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	public String getFormularioParaOfertas() {
		return "oferta/home";
	}
}
