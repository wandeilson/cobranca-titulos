package com.wandeilson.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wandeilson.cobranca.model.Titulo;
import com.wandeilson.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired//O proprio spring nos dá uma implementação desse repositoty, por isso não é necessário que 
	//seja instanciada algo concreto. Isso acontece atraves do IoC
	private Titulos titulos;
	

	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		System.out.println(">>>"+ titulo.getDescricao());
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem","Título salvo com sucesso!");
		return mv;
	}
}
