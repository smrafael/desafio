package com.rafaelsm.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.models.Client;
import com.rafaelsm.desafio.services.ClientService;

@RequestMapping(value="api/cliente")
@RestController
public class ClienteController {
	
	@Autowired
	private ClientService service;
	
	@PostMapping
	public Client save(@RequestBody Client cliente) throws CustomException {
		return this.service.save(cliente);
	}
	
	@GetMapping
	public Page<Client> list(@RequestParam(value="page", required=true, defaultValue="0") Integer page,
			@RequestParam(value="size", required=true, defaultValue="10") Integer size) throws CustomException {
		return this.service.list(page, size);
	}
	
	@PutMapping("/{id}")
	public Client update(@PathVariable(value="id") Long id, @RequestBody Client client) throws CustomException {
		return this.service.update(id, client);
	}
	
}