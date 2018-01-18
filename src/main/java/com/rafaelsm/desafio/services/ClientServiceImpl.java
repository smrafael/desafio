package com.rafaelsm.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.messages.Messages;
import com.rafaelsm.desafio.models.Client;
import com.rafaelsm.desafio.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public Page<Client> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Client save(Client cliente) throws CustomException {
		if (repository.findOneByEmail(cliente.getEmail()) != null) {
			throw new CustomException(Messages.EMAIL_ALREADY_EXISTS);
		}
		
		if (repository.findOneByCpf(cliente.getCpf()) != null) {
			throw new CustomException(Messages.CPF_ALREADY_EXISTS);
		}
		
		cliente.setId(null);
		Client saved = repository.save(cliente);
		return saved;
	}

	@Override
	public void update(Long id, Client cliente) {
		
	}
	
}