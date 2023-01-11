package com.wandeilson.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TituloController {
	@RequestMapping("/titulo/novo")
	public String novo() {
		return "CadastroTitulo";
	}
}
