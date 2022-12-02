package com.algaworks;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContatosControle {
	
	private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
	
	static {
		LISTA_CONTATOS.add(new Contato("01", "Tom Zé", "74-12345678"));
		LISTA_CONTATOS.add(new Contato("02", "Gal Costa", "74-12345678"));
		LISTA_CONTATOS.add(new Contato("03", "Maria Bethânia", "74-12345678"));
		LISTA_CONTATOS.add(new Contato("04", "Chico César", "74-12345678"));
		LISTA_CONTATOS.add(new Contato("05", "Gilberto Gil", "74-12345678"));
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contatos")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listar");
		modelAndView.addObject("contatos", LISTA_CONTATOS);
		return modelAndView;
	}
	
	@GetMapping("/contatos/novo")
	public ModelAndView adicionar() {
		ModelAndView modelAndView = new ModelAndView("formulario");
		modelAndView.addObject("contato", new Contato());
		return modelAndView;
	}
	
	@PostMapping("/contatos")
	public String cadastrar(Contato contato) {
		String id = UUID.randomUUID().toString();
		contato.setId(id);
		LISTA_CONTATOS.add(contato);
		return "redirect:/contatos";
	}
}
