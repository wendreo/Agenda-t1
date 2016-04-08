package com.example.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entity.Telefone;
import com.example.Repositorio.PessoaRepositorio;
import com.example.Repositorio.TelefoneRepositorio;

@Controller
public class TelefoneControle {
	

	@Autowired	
	private TelefoneRepositorio telefoneRepositorio;
	
	@Autowired 
	private PessoaRepositorio pessoaRespositorio;
	
	@RequestMapping(value="/")
	public String listarTelefone(Telefone a, Model model){
	
		// se valor id ta cadastrando
		if(a.getId() != null){
			
			model.addAttribute("telefone",telefoneRepositorio.findOne(a.getId()));
		}else{
			model.addAttribute("telefone", new Telefone());
		}
		
		model.addAttribute("telefones",  telefoneRepositorio.findAll());
		model.addAttribute("pessoa", pessoaRespositorio.findAll());
		
		return "index";	
		
	}
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/telefone/salve")
	
	public String salvarTelefone(Telefone telefone){
		Telefone telefone1 = telefone;
		telefone.setPessoa(pessoaRespositorio.save(telefone.getPessoa()));
		telefoneRepositorio.save(telefone);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/telefone/del")
	public String deletarTelefone(Telefone telefone){
		telefoneRepositorio.delete(telefone);
		return "redirect:/";
	}
	
}



