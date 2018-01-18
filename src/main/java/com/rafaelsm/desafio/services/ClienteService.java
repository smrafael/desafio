package com.rafaelsm.desafio.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rafaelsm.desafio.models.Cliente;

public interface ClienteService {
	
	// TODO find
	
	public Page<Cliente> list(Pageable pageable);
	
	public Cliente save(Cliente cliente);
	
	public void update(Long id, Cliente cliente);
	
}
