package com.example.Repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.Entity.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Long>{
	
}
