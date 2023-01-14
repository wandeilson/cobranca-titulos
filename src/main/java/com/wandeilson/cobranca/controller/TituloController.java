package com.wandeilson.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wandeilson.cobranca.model.StatusTitulo;
import com.wandeilson.cobranca.model.Titulo;
import com.wandeilson.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired//O proprio spring nos dá uma implementação desse repositoty, por isso não é necessário que 
	//seja instanciada algo concreto. Isso acontece atraves do IoC
	private Titulos titulos;
	

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		//mv.addObject("todosStatusTitulo", StatusTitulo.values());
		mv.addObject(new Titulo());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		if(errors.hasErrors()) {
			return mv;
		}
		titulos.save(titulo);
		mv.addObject("mensagem","Título salvo com sucesso!");
		return mv;
	}
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos =  titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos",todosTitulos);
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}
