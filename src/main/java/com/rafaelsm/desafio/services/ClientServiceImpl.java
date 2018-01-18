package com.rafaelsm.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.messages.ErrorMessages;
import com.rafaelsm.desafio.models.Client;
import com.rafaelsm.desafio.repositories.ClientRepository;
import com.rafaelsm.desafio.repositories.specification.ClientSpecificationBuilder;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Override
	public Page<Client> list(Integer page, Integer size, String searchQuery) throws CustomException {
		if (page < 0) {
			throw new CustomException(ErrorMessages.PAGE_LESS_THAN_ZERO);
		}
		
		if (size < 0) {
			throw new CustomException(ErrorMessages.SIZE_LESS_THAN_ZERO);
		}
		
		if (size > 100) {
			throw new CustomException(ErrorMessages.SIZE_BIGGER_THAN_100);
		}
		
		ClientSpecificationBuilder builder = new ClientSpecificationBuilder(searchQuery);
		return repository.findAll(builder.build(), new PageRequest(page, size));
	}

	@Override
	public Client save(Client cliente) throws CustomException {
		validate(cliente);
		
		cliente.setId(null);
		Client saved = repository.save(cliente);
		return saved;
	}

	@Override
	public Client update(Long id, Client client) throws CustomException {
		Client clientDB = repository.findOne(id);
		if (clientDB == null) {
			throw new CustomException(ErrorMessages.CLIENT_NOT_FOUNT);
		}
		
		client.setId(clientDB.getId());
		validate(client);
		
		return repository.save(client);
	}
	
	private void validate(Client client) throws CustomException {
		Client clientDB = repository.findOneByEmail(client.getEmail());
		if (clientDB != null && !clientDB.getId().equals(client.getId())) {
			throw new CustomException(ErrorMessages.EMAIL_ALREADY_EXISTS);
		}
		
		clientDB = repository.findOneByCpf(client.getCpf());
		if (clientDB != null && !clientDB.getId().equals(client.getId())) {
			throw new CustomException(ErrorMessages.CPF_ALREADY_EXISTS);
		}
	}
	
}