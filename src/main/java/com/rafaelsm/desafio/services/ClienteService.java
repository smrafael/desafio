package com.rafaelsm.desafio.services;

import org.springframework.data.domain.Page;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.models.Cliente;

public interface ClienteService {
	
	public Page<Cliente> list(Integer page, Integer size, String searchQuery) throws CustomException;
	
	public Cliente save(Cliente cliente) throws CustomException;
	
	public Cliente update(Long id, Cliente cliente) throws CustomException;
	
}
