package com.rafaelsm.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.messages.ErrorMessages;
import com.rafaelsm.desafio.models.Cliente;
import com.rafaelsm.desafio.models.Endereco;
import com.rafaelsm.desafio.repositories.ClienteRepository;
import com.rafaelsm.desafio.repositories.specification.ClienteSpecificationBuilder;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteSpecificationBuilder builder;
	
	@Override
	public Page<Cliente> list(Integer page, Integer size, String searchQuery) throws CustomException {
		if (page < 0) {
			throw new CustomException(ErrorMessages.PAGE_LESS_THAN_ZERO);
		}
		
		if (size < 1) {
			throw new CustomException(ErrorMessages.SIZE_LESS_THAN_ONE);
		}
		
		if (size > 100) {
			throw new CustomException(ErrorMessages.SIZE_BIGGER_THAN_100);
		}
		
		return repository.findAll(builder.build(searchQuery), new PageRequest(page, size));
	}

	@Override
	public Cliente save(Cliente cliente) throws CustomException {
		validate(cliente);
		
		cliente.setId(null);
		Cliente saved = repository.save(cliente);
		return saved;
	}

	@Override
	public Cliente update(Long id, Cliente client) throws CustomException {
		Cliente clientDB = repository.findOne(id);
		if (clientDB == null) {
			throw new CustomException(ErrorMessages.CLIENT_NOT_FOUNT);
		}
		
		client.setId(clientDB.getId());
		validate(client);
		validateUpdate(client, clientDB);
		
		return repository.save(client);
	}
	
	private void validate(Cliente client) throws CustomException {
		Cliente clientDB = repository.findOneByEmail(client.getEmail());
		if (clientDB != null && !clientDB.getId().equals(client.getId())) {
			throw new CustomException(ErrorMessages.EMAIL_ALREADY_EXISTS);
		}
		
		clientDB = repository.findOneByCpf(client.getCpf());
		if (clientDB != null && !clientDB.getId().equals(client.getId())) {
			throw new CustomException(ErrorMessages.CPF_ALREADY_EXISTS);
		}
	}
	
	private void validateUpdate(Cliente client, Cliente clientDB) throws CustomException {
		Endereco endereco = client.getEndereco();
		Endereco enderecoDB = clientDB.getEndereco();
		if (endereco != null && (endereco.getId() == null || !endereco.getId().equals(enderecoDB.getId()))) {
			throw new CustomException(ErrorMessages.UNKNOWN_ADDRESS);
		}
	}
	
}