package com.rafaelsm.desafio.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rafaelsm.desafio.models.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
	
	Client findOneByEmail(String email);
	
	Client findOneByCpf(String cpf);
	
}
