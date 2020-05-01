package com.tindao.osworks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tindao.osworks.model.StatusTitulo;
import com.tindao.osworks.model.Titulo;
import com.tindao.osworks.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController 
{	
	//Repositório
	@Autowired
	private Titulos titulos;
	
	/*
	 * Método para chamar a página web
	 */
	@RequestMapping("/novo")
	public ModelAndView novo()
	{
		ModelAndView mv = new ModelAndView("CadastroTitulo"); //retorma o nome da página que será carregada
		return (mv); 
	}
	
	/*
	 * Metodo para salvar 
	 */
	@RequestMapping(method = RequestMethod.POST)	//informa o tipo de recebimento das informações
	public ModelAndView salvar(Titulo titulo)
	{
		titulos.save(titulo);
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Título salvo com sucesso!");
		
		return (mv);
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo()
	{
		return(Arrays.asList(StatusTitulo.values()));
	}
}
