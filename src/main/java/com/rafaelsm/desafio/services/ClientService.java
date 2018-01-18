package com.rafaelsm.desafio.services;

import org.springframework.data.domain.Page;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.models.Client;

public interface ClientService {
	
	// TODO find
	
	public Page<Client> list(Integer page, Integer size, String searchQuery) throws CustomException;
	
	public Client save(Client cliente) throws CustomException;
	
	public Client update(Long id, Client cliente) throws CustomException;
	
}
