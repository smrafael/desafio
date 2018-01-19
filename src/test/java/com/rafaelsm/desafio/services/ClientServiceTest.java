package com.rafaelsm.desafio.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringRunner;

import com.rafaelsm.desafio.data.ClientData;
import com.rafaelsm.desafio.exception.CustomException;
import com.rafaelsm.desafio.messages.ErrorMessages;
import com.rafaelsm.desafio.models.Client;
import com.rafaelsm.desafio.repositories.ClientRepository;
import com.rafaelsm.desafio.repositories.specification.ClientSpecification;
import com.rafaelsm.desafio.repositories.specification.ClientSpecificationBuilder;
import com.rafaelsm.desafio.repositories.specification.SearchCriteria;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientServiceTest {
	
	@TestConfiguration
	static class ClientServiceTestConfiguration {
		
		@Bean
		public ClientService clientService() {
			return new ClientServiceImpl();
		}
	}
	
	@MockBean
	private ClientRepository repository;
	
	@MockBean
	private ClientSpecificationBuilder builder;
	
	@Autowired 
	private ClientServiceImpl service;
	
	@Before
	public void init() {
		PageRequest pageReq = new PageRequest(0, 5);
		
		// Mock for whenList_thenReturnListOfClients
		Page<Client> page = new PageImpl<>(ClientData.all(), pageReq, 5);
		Mockito.when(repository.findAll(null, pageReq)).thenReturn(page);
		
		// Mock givenNomeCompleto_whenList_thenReturnClient and givenNomeEmail_whenList_thenReturnClient
		Page<Client> pageRafael = new PageImpl<>(Arrays.asList(ClientData.getRafael()), pageReq, 1);
		SearchCriteria criteriaNomeCompleto = new SearchCriteria("nomeCompleto", ":", "Rafael");
		SearchCriteria criteriaEmail = new SearchCriteria("email", ":", "rafael.sm1990@gmail.com");
		Specification<Client> specNome = Specifications.where(new ClientSpecification(criteriaNomeCompleto));
		Specification<Client> specNomeEmail = Specifications.where(new ClientSpecification(criteriaNomeCompleto)).and(new ClientSpecification(criteriaEmail));
		Mockito.when(builder.build("nomeCompleto:Rafael")).thenReturn(specNome);
		Mockito.when(builder.build("nomeCompleto:Rafael,email:rafael.sm1990@gmail.com")).thenReturn(specNomeEmail);
		Mockito.when(repository.findAll(builder.build("nomeCompleto:Rafael"), pageReq)).thenReturn(pageRafael);
		Mockito.when(repository.findAll(builder.build("nomeCompleto:Rafael,email:rafael.sm1990@gmail.com"), pageReq)).thenReturn(pageRafael);
		
		// Mock givenEstado_whenList_thenReturnTwoClients
		Page<Client> pageTwoClients = new PageImpl<>(Arrays.asList(ClientData.getRafael(), ClientData.getPamella()), pageReq, 2);
		SearchCriteria criteriaEstado = new SearchCriteria("estado", ":", "PB");
		Specification<Client> specEstado = Specifications.where(new ClientSpecification(criteriaEstado));
		Mockito.when(builder.build("estado:PB")).thenReturn(specEstado);
		Mockito.when(repository.findAll(builder.build("estado:PB"), pageReq)).thenReturn(pageTwoClients);
		
		// Mock givenEstado_whenList_thenReturnNoneClients
		Page<Client> pageNone = new PageImpl<>(new ArrayList<>(), pageReq, 0);
		SearchCriteria criteriaEstadoDF = new SearchCriteria("estado", ":", "DF");
		Specification<Client> specEstadoDF = Specifications.where(new ClientSpecification(criteriaEstadoDF));
		Mockito.when(builder.build("estado:DF")).thenReturn(specEstadoDF);
		Mockito.when(repository.findAll(builder.build("estado:DF"), pageReq)).thenReturn(pageNone);
	}
	
	@Test
	public void whenList_thenReturnListOfClients() throws CustomException {
		Page<Client> page = service.list(0, 5, null);
		assertThat(page.getTotalElements()).isEqualTo(5);
		
		List<Client> clients = page.getContent();
		assertThat(ClientData.getRafael()).isIn(clients);
		
	}
	
	@Test
	public void givenSizeLessThanZero_whenList_expectException() {
		try {
			service.list(0, -1, null);
			fail("CustomException expected to be throw");
		} catch (CustomException e) {
			assertThat(e.getMessage()).isEqualTo(ErrorMessages.SIZE_LESS_THAN_ZERO);
		}
	}
	
	@Test
	public void givenPageLessThanZero_whenList_expectException() {
		try {
			service.list(-1, 5, null);
			fail("CustomException expected to be throw");
		} catch (CustomException e) {
			assertThat(e.getMessage()).isEqualTo(ErrorMessages.PAGE_LESS_THAN_ZERO);
		}
	}
	
	@Test
	public void givenSizeBiggerThan100_whenList_expectException() {
		try {
			service.list(0, 101, null);
			fail("CustomException expected to be throw");
		} catch (CustomException e) {
			assertThat(e.getMessage()).isEqualTo(ErrorMessages.SIZE_BIGGER_THAN_100);
		}
	}
	
	@Test
	public void givenNomeCompleto_whenList_thenReturnClient() throws CustomException {
		Page<Client> page = service.list(0, 5, "nomeCompleto:Rafael");
		assertThat(page.getTotalElements()).isEqualTo(1);
		
		List<Client> clients = page.getContent();
		assertThat(ClientData.getRafael()).isIn(clients);
	}
	
	@Test
	public void givenNomeEmail_whenList_thenReturnClient() throws CustomException {
		Page<Client> page = service.list(0, 5, "nomeCompleto:Rafael,email:rafael.sm1990@gmail.com");
		assertThat(page.getTotalElements()).isEqualTo(1);
		
		List<Client> clients = page.getContent();
		assertThat(ClientData.getRafael()).isIn(clients);
	}
	
	@Test
	public void givenEstado_whenList_thenReturnTwoClients() throws CustomException {
		Page<Client> page = service.list(0, 5, "estado:PB");
		assertThat(page.getTotalElements()).isEqualTo(2);
		
		List<Client> clients = page.getContent();
		assertThat(ClientData.getRafael()).isIn(clients);
		assertThat(ClientData.getPamella()).isIn(clients);
	}
	
	@Test
	public void givenEstado_whenList_thenReturnNoneClients() throws CustomException {
		Page<Client> page = service.list(0, 5, "estado:DF");
		assertThat(page.getTotalElements()).isEqualTo(0);
	}
	
	@Test
	public void whenSave_thenReturnNewClient() throws CustomException {
		Mockito.when(repository.save(ClientData.getNewUser())).thenReturn(ClientData.getNewUserSaved());
		Client saved = service.save(ClientData.getNewUser());
		
		assertThat(saved).isEqualTo(ClientData.getNewUserSaved());
	}
	
	@Test
	public void givenAlreadyExistsCpf_whenSave_expectException() throws CustomException {
		Mockito.when(repository.findOneByCpf(ClientData.getNewUserSaved().getCpf())).thenReturn(ClientData.getNewUserSaved());
		
		try {
			Client newUser = ClientData.getNewUser();
			newUser.setCpf(ClientData.getNewUserSaved().getCpf());
			service.save(newUser);
			fail("CustomException expected to be throw");
		} catch (CustomException e) {
			assertThat(e.getMessage()).isEqualTo(ErrorMessages.CPF_ALREADY_EXISTS);
		}
	}
	
	@Test
	public void givenAlreadyExistsEmail_whenSave_expectException() throws CustomException {
		Mockito.when(repository.findOneByEmail(ClientData.getNewUserSaved().getEmail())).thenReturn(ClientData.getNewUserSaved());
		
		try {
			Client newUser = ClientData.getNewUser();
			newUser.setEmail(ClientData.getNewUserSaved().getEmail());
			service.save(newUser);
			fail("CustomException expected to be throw");
		} catch (CustomException e) {
			assertThat(e.getMessage()).isEqualTo(ErrorMessages.EMAIL_ALREADY_EXISTS);
		}
	}
	
	@Test
	public void whenUpdate_thenReturnClient() throws CustomException {
		Client userModifiedBD = ClientData.getNewUserSaved();
		userModifiedBD.setBairro("UPDATED!");
		Mockito.when(repository.findOne(ClientData.getNewUserSaved().getId())).thenReturn(ClientData.getNewUserSaved());
		Mockito.when(repository.save(userModifiedBD)).thenReturn(userModifiedBD);
		
		Client user = ClientData.getNewUserSaved();
		user.setBairro("UPDATED!");
		
		Client saved = service.update(user.getId(), user);
		assertThat(saved).isEqualTo(userModifiedBD);
	}
	
	@Test
	public void givenInexistentId_whenUpdate_expectExcption() {
		Mockito.when(repository.findOne(2L)).thenReturn(null);
		try {
			Client user = ClientData.getNewUserSaved();
			user.setBairro("UPDATED!");
			service.update(2L, user);
			fail("CustomException expected to be throw");
		} catch (CustomException e) {
			assertThat(e.getMessage()).isEqualTo(ErrorMessages.CLIENT_NOT_FOUNT);
		}
	}

}
