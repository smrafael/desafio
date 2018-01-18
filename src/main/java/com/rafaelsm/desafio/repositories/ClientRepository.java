package com.rafaelsm.desafio.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rafaelsm.desafio.models.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long>, JpaSpecificationExecutor<Client> {
	
	Client findOneByEmail(String email);
	
	Client findOneByCpf(String cpf);
	
}
