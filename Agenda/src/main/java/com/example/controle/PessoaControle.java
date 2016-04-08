package com.example.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entity.Pessoa;
import com.example.Repositorio.PessoaRepositorio;

@Controller
public class PessoaControle {
	
	@Autowired	
	private PessoaRepositorio pessoaRepositorio;
	
	@RequestMapping(value="/pessoa")
	public String listarPessoa(Pessoa a, Model model){
		model.addAttribute("pessoa", pessoaRepositorio.findAll());
		
		if(a.getId() != null){
			model.addAttribute("pessoa",pessoaRepositorio.findOne(a.getId()));
		}else{
			model.addAttribute("pessoa", new Pessoa());
		}
		
		return "index";
	}
	
@RequestMapping(value="/pessoa/salve")
	public String salvarPessoa(Pessoa pessoa){
		pessoaRepositorio.save(pessoa);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/agenda/del")
	public String deletarPessoa(Pessoa pessoa){
		pessoaRepositorio.delete(pessoa);
		return "redirect:/";
	}
	



}
