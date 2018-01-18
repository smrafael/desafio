package com.rafaelsm.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.messages.Messages;
import com.rafaelsm.desafio.models.Cliente;
import com.rafaelsm.desafio.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Page<Cliente> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Cliente save(Cliente cliente) throws CustomException {
		if (repository.findOneByEmail(cliente.getEmail()) != null) {
			throw new CustomException(Messages.EMAIL_ALREADY_EXISTS);
		}
		
		if (repository.findOneByCpf(cliente.getCpf()) != null) {
			throw new CustomException(Messages.CPF_ALREADY_EXISTS);
		}
		
		cliente.setId(null);
		Cliente saved = repository.save(cliente);
		return saved;
	}

	@Override
	public void update(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
	
}