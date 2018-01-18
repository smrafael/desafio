package com.rafaelsm.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsm.desafio.models.Cliente;
import com.rafaelsm.desafio.services.ClienteService;

@RequestMapping(value="api/cliente")
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return this.service.save(cliente);
	}
	
	@GetMapping
	public Page<Cliente> list(@RequestParam(value="page", required=true, defaultValue="0") Integer page,
			@RequestParam(value="size", required=true, defaultValue="10") Integer size) {
		return this.service.list(new PageRequest(page, size));
	}
	
}