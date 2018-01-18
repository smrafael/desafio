package com.rafaelsm.desafio.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rafaelsm.desafio.models.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
	
}
