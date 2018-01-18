package com.rafaelsm.desafio.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.models.Client;

public interface ClientService {
	
	// TODO find
	
	public Page<Client> list(Pageable pageable);
	
	public Client save(Client cliente) throws CustomException;
	
	public void update(Long id, Client cliente);
	
}
